package com.phoneScamCatcher.scatcher;

import com.phoneScamCatcher.scatcher.contracts.Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.response.PollingTransactionReceiptProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;

@SpringBootApplication
public class ScatcherApplication {

	private final static String PRIVATE_KEY = "0x29ef7a421a6774e26de86fe7a4f8573e806a39268904363567fe453759f325d2";
	private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
	private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
	private final static BigInteger TIMEPERIOD = BigInteger.valueOf(84600);
	private final static String CONTRACT_ADDRESS = "0xc6296CF9af63cb1E1a443F1B924485A9aF2ca787";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ScatcherApplication.class, args);
		Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));

		// TransactionManager transactionManager = new RawTransactionManager(web3j, getCredentialsFromPrivateKey());
		Credentials credentials = getCredentialsFromPrivateKey();

		// Firstly, initialize a contract, then fill it up CONTRACT_ADDRESS value.
		// Then, uncomment the 33th row.
//		String deployedAddress = deployContract(web3j, credentials);
//		System.out.println("----------Deployed contract Address: ---------------" + deployedAddress);

		Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport phoneScamCatcher = loadContract(CONTRACT_ADDRESS, web3j, credentials);
		System.out.println("---------Deployed contract address-----------: "+ phoneScamCatcher.getContractAddress());
		String phoneNumber = "987654321";

		TransactionReceipt transactionReceipt = phoneScamCatcher.reportNumber(phoneNumber).send();
		System.out.println(transactionReceipt.getTransactionHash());

		phoneScamCatcher.reportNumber("123456789").send();
		//List<Log> logs = transactionReceipt.getLogs();
		//System.out.println(logs.toString());

		System.out.println(transactionReceipt.getBlockNumber());
		System.out.println("----------");

//		TransactionReceipt transactionReceipt1 = phoneScamCatcher.reportNumber(phoneNumber).send();
//		System.out.println(transactionReceipt1.toString());

//		phoneScamCatcher.reportNumber(phoneNumber).send();
//		phoneScamCatcher.reportNumber(phoneNumber).sendAsync();

		CompletableFuture<BigInteger> bigInteger = phoneScamCatcher.checkReports(phoneNumber).sendAsync();
		System.out.println(bigInteger.toString());
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