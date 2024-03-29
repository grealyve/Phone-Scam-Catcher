<h1 align="center">
  <br>
  <a href="https://github.com/grealyve/Phone-Scam-Catcher/static/PhoneScamCatcher.png"><img src="static/PhoneScamCatcher.jpg" width="200px" ></a>
</h1>

<h4 align="center">Reporting and checking scammer phone number tool based on decentralized network.</h4>

# Phone Scam Catcher
Blockchain project based on Java Spring backend and stores the user data in a MySql server. Users can report a phone number and every phone number is written a block.

````powershell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.1)
````

## Table of Contents
<p align="center">
  <a href="#features">Features</a> •
  <a href="#model">Model</a> •
  <a href="#install">Install</a> •
  <a href="#build">Build</a> •
  <a href="#web-page-endpoints">Web Page Endpoints</a> •
  <a href="#examples">Examples</a> •
  <a href="#mysql-properties">MySql Connection</a> •
  <a href="#contributing">Contributing</a> •
  <a href="#license">License</a>
</p>

<p align="center">
  <a href="https://github.com/grealyve/Phone-Scam-Catcher/blob/main/README_TR.md">Turkish</a>
</p>

---

## Features

- User registration and login
- Reporting and checking phone numbers for scams
- Integration with Ethereum blockchain for secure reporting

## Model
This is model diagram of our project:
![blockchain_model.jpg](static%2Fblockchain_model.jpg)

## Install
This project requires Java 21.
````shell
git clone https://github.com/grealyve/Phone-Scam-Catcher
````

## Build
- These are the required `npm` libraries
```shell
$ npm install solc

$ npm install -g truffle

$ npm install ganache --global
```

- To compile the Solidity contract first you need to use `solc` library:
```shell
$ solcjs .\src\main\resources\solidity\PhoneScamCatcher.sol --bin --abi --optimize -o .\src\main\resources\out\
```

- To translate the contract's functions to Java code by using `web3j` library:
```powershell
              _      _____ _
             | |    |____ (_)
__      _____| |__      / /_
\ \ /\ / / _ \ '_ \     \ \ |
 \ V  V /  __/ |_) |.___/ / |
  \_/\_/ \___|_.__/ \____/| |
                         _/ |
                        |__/
by Web3Labs

$ web3j generate solidity -b .\src\main\resources\out\src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.bin 
    -a .\src\main\resources\out\src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.abi 
        -o .\src\main\java -p com.phoneScamCatcher.scatcher.contracts
```
- Implementation Java libraries:
```java
implementation 'org.web3j:core:4.10.0'
```
- To visualize and connect the contract with `Ganache` use this codes: 
```bash
$ truffle init
Starting init...
================

> Copying project files to E:\Java Projects\Phone-Scam-Catcher\src\main\resources

Init successful, sweet!

Try our scaffold commands to get started:
  $ truffle create contract YourContractName # scaffold a contract
  $ truffle create test YourTestName         # scaffold a test

http://trufflesuite.com/docs

$ truffle compile

Compiling your contracts...
===========================
> Compiling .\contracts\PhoneNumberReport.sol
> Artifacts written to E:\Java Projects\Phone-Scam-Catcher\src\main\resources\build\contracts
> Compiled successfully using:
   - solc: 0.8.13+commit.abaa5c0e.Emscripten.clang
   
$ truffle migrate
Compiling your contracts...
===========================
> Compiling .\contracts\PhoneNumberReport.sol
> Artifacts written to E:\Java Projects\Phone-Scam-Catcher\src\main\resources\build\contracts
> Compiled successfully using:
   - solc: 0.8.13+commit.abaa5c0e.Emscripten.clang


Starting migrations...
======================
> Network name:    'development'
> Network id:      5777
> Block gas limit: 6721975 (0x6691b7)


2_deploy_contract.js
====================

   Deploying 'PhoneNumberReport'
   -----------------------------
   > transaction hash:    0xcbacd8b491bfff13efb6721401d23e1b3736a93c1f5452c3afec60856c93d4f0
   > Blocks: 0            Seconds: 0
   > contract address:    0x00542DB10f49022B9Be9d991d3C03A43894F4fCA
   > block number:        36
   > block timestamp:     1705150712
   > account:             0x7804085AB0194CCF1f64A76C565F8d8C3d24A960
   > balance:             99.86384585291458718
   > gas used:            335806 (0x51fbe)
   > gas price:           2.518245123 gwei
   > value sent:          0 ETH
   > total cost:          0.000845641821774138 ETH

   > Saving artifacts
   -------------------------------------
   > Total cost:     0.000845641821774138 ETH

Summary
=======
> Total deployments:   1
> Final cost:          0.000845641821774138 ETH
```
- The `abi` of the smart contract named `PhoneScamCatcher.sol`.
`````json
[{"anonymous":false,"inputs":[{"indexed":false,"internalType":"string","name":"phoneNumber","type":"string"},
  {"indexed":false,"internalType":"int256","name":"count","type":"int256"}],"name":"PhoneNumberReported","type":"event"},
  {"inputs":[{"internalType":"string","name":"phoneNumber","type":"string"}],"name":"checkReports","outputs":[{"internalType":"int256","name":"","type":"int256"}],"stateMutability":"view","type":"function"},
  {"inputs":[{"internalType":"string","name":"phoneNumber","type":"string"}],"name":"reportNumber","outputs":[],"stateMutability":"nonpayable","type":"function"}]
`````

## Web Page Endpoints

### Home Page
``http://localhost:8080/home``
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/18c7f652-f2ce-4799-9815-7448de6459c5)

### Register Page
``http://localhost:8080/register``
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/48d5bfba-2e45-4480-83b9-14799f9ffd83)

### Login Page
``http://localhost:8080/login``
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/38dd48d6-4570-43a9-a304-89540daff694)

### Report Page
``http://localhost:8080/report``
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/580b2849-03aa-40d5-b598-353a239b0b29)

### Report Check Page
``http://localhost:8080/reportCheck``
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/cc607a29-8ffd-4fca-9eed-958411ae4b4d)

## Examples

### Ganache
- Smart Contract
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/04457acc-728f-4e2e-a4c0-bed6157276bc)
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/b2cb7b27-dfd0-4086-98c4-25b3c4802285)

- Example Written Block 
![image](https://github.com/grealyve/Phone-Scam-Catcher/assets/41903311/4a199fe6-6bdd-48f4-b2d9-13fd693e501f)


## MySql Properties
application.properties
````mysql-sql
spring.datasource.url=jdbc:mysql://localhost:3306/scammerDB
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
````

## Ethereum Smart Contract
The application uses an Ethereum smart contract for securely storing and retrieving reported phone numbers. The smart contract is written in Solidity and is available in the `src/main/resources/solidity/` directory.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please feel free to create an issue or submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
```shell
Make sure to customize the placeholders such as `your-username`, add more details about the project's structure, dependencies, and any other relevant information. Additionally, consider adding sections like "Deployment" or "Troubleshooting" based on your project's needs.
```
