import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class BlockchainSimulation {

    static class Block {
        private final int index;
        private final long timestamp;
        private final String transactions;
        private final String previousHash;
        private String hash;
        private int nonce;

        public Block(int index, String transactions, String previousHash) {
            this.index = index;
            this.timestamp = System.currentTimeMillis();
            this.transactions = transactions;
            this.previousHash = previousHash;
            this.nonce = 0;
            this.hash = calculateHash();
        }

        public String calculateHash() {
            String data = index + timestamp + transactions + previousHash + nonce;
            return applySha256(data);
        }

        public void mineBlock(int difficulty) {
            String target = "0".repeat(difficulty);
            while (!hash.startsWith(target)) {
                nonce++;
                hash = calculateHash();
            }
        }

        public static String applySha256(String input) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hashBytes = digest.digest(input.getBytes());
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    hexString.append(String.format("%02x", b));
                }
                return hexString.toString();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public String getPreviousHash() {
            return previousHash;
        }

        public String getHash() {
            return hash;
        }

        public String getTransactions() {
            return transactions;
        }

        public int getIndex() {
            return index;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public int getNonce() {
            return nonce;
        }
    }

    static class Blockchain {
        private final List<Block> chain;
        private final int difficulty;

        public Blockchain(int difficulty) {
            this.difficulty = difficulty;
            chain = new ArrayList<>();
            chain.add(createGenesisBlock());
        }

        private Block createGenesisBlock() {
            return new Block(0, "Genesis Block", "0");
        }

        public void addBlock(String transactions) {
            Block previousBlock = chain.get(chain.size() - 1);
            Block newBlock = new Block(chain.size(), transactions, previousBlock.getHash());
            newBlock.mineBlock(difficulty);
            chain.add(newBlock);
        }

        public boolean isChainValid() {
            for (int i = 1; i < chain.size(); i++) {
                Block currentBlock = chain.get(i);
                Block previousBlock = chain.get(i - 1);

                if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                    return false;
                }
                if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                    return false;
                }
            }
            return true;
        }

        public void printChain() {
            chain.forEach(block -> {
                System.out.println("Index: " + block.getIndex());
                System.out.println("Timestamp: " + block.getTimestamp());
                System.out.println("Transactions: " + block.getTransactions());
                System.out.println("Previous Hash: " + block.getPreviousHash());
                System.out.println("Hash: " + block.getHash());
                System.out.println("Nonce: " + block.getNonce());
                System.out.println("--------------------------------------");
            });
        }
    }

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain(3);
        blockchain.addBlock("Alice pays Bob 10 BTC");
        blockchain.addBlock("Bob pays Charlie 5 BTC");
        blockchain.addBlock("Charlie pays Dave 2 BTC");

        blockchain.printChain();

        System.out.println("Blockchain valid: " + blockchain.isChainValid());
    }
}
