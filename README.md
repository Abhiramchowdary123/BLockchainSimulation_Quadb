# Blockchain Simulation in Java

This is a simple **Blockchain Simulation** written in Java. It demonstrates the fundamental concepts of blockchain, including block creation, mining, and validation.

## Features
- Implements a **basic blockchain** with proof-of-work.
- Uses **SHA-256 hashing** for block security.
- Includes **block mining** with adjustable difficulty.
- Ensures **chain integrity** through validation.

## Prerequisites
Ensure you have the following installed:
- **Java 8 or higher**
- Any Java IDE (IntelliJ, Eclipse, VS Code) or a terminal with `javac` and `java` commands available.

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/Abhiramchowdary123/blockchain-simulation.git
   ```
2. Navigate to the project folder:
   ```sh
   cd blockchain-simulation
   ```
3. Compile the Java file:
   ```sh
   javac BlockchainSimulation.java
   ```
4. Run the application:
   ```sh
   java BlockchainSimulation
   ```

## Code Structure
- `Block` class: Represents an individual block in the blockchain.
- `Blockchain` class: Manages the chain and validates its integrity.
- `main` method: Demonstrates block addition and prints the blockchain.

## Example Output
```
Index: 0
Timestamp: 1700000000000
Transactions: Genesis Block
Previous Hash: 0
Hash: 000abcdef...
Nonce: 12345
--------------------------------------
Index: 1
Timestamp: 1700000001000
Transactions: Alice pays Bob 10 BTC
Previous Hash: 000abcdef...
Hash: 000xyz...
Nonce: 67890
--------------------------------------
Blockchain valid: true
```

## Future Enhancements
- Implementing a peer-to-peer network for decentralization.
- Adding digital signatures for transaction authentication.
- Improving performance with optimized mining algorithms.

## License
This project is **open-source** and available under the MIT License.

## Author
**Gaddipati Abhiram**

