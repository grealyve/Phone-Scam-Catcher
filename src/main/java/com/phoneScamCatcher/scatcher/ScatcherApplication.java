package com.phoneScamCatcher.scatcher;

import com.phoneScamCatcher.scatcher.contracts.Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;

@SpringBootApplication
public class ScatcherApplication {

	private final static String PRIVATE_KEY = "0x5085166acc307738e10b28dbd6ed42d6fb9e460e6a324e8f707b4e0a1d3507bb";
	private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
	private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
	private final static String CONTRACT_ADDRESS = "";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ScatcherApplication.class, args);
		Web3j web3j = Web3j.build(new HttpService());

		// TransactionManager transactionManager = new RawTransactionManager(web3j, getCredentialsFromPrivateKey());
		Credentials credentials = getCredentialsFromPrivateKey();

		// Firstly, initialize a contract, then fill it up CONTRACT_ADDRESS value.
		// Then, uncomment the 33th row.
		String deployedAddress = deployContract(web3j, credentials);

		//Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport phoneScamCatcher = loadContract(CONTRACT_ADDRESS, web3j, credentials);
		System.out.println("Deployed contract address: "+ deployedAddress);

	}

	private static Credentials getCredentialsFromPrivateKey(){
		return Credentials.create(PRIVATE_KEY);
	}

	private static String deployContract(Web3j web3j, Credentials credentials) throws Exception {
		return Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT)
				.send()
				.getContractAddress();
	}

	private static Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport loadContract(String contractAddress, Web3j web3j, Credentials credentials){
		return Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
	}

}