package com.phoneScamCatcher.scatcher.service;

import com.phoneScamCatcher.scatcher.contracts.Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport;
import lombok.Getter;
import lombok.Setter;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@Getter
@Setter
public class ContractService {
    private final Web3j web3j;
    private String reportedNumber;
    public ContractService() {
        this.web3j = Web3j.build(new HttpService("http://localhost:7545"));
    }

    public final String PRIVATE_KEY = "0x29ef7a421a6774e26de86fe7a4f8573e806a39268904363567fe453759f325d2";
    private final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private final String CONTRACT_ADDRESS = "0xc6296CF9af63cb1E1a443F1B924485A9aF2ca787";

    public Credentials getCredentialsFromPrivateKey() throws NullPointerException{
        return Credentials.create(PRIVATE_KEY);
    }

    private String deployContract(Web3j web3j, Credentials credentials) throws Exception {
        return Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT)
                .send()
                .getContractAddress();
    }

    public Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport loadContract(String contractAddress, Web3j web3j, Credentials credentials){
        return Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
    }
}
