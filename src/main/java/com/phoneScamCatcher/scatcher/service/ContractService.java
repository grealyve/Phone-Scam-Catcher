package com.phoneScamCatcher.scatcher.service;

import com.phoneScamCatcher.scatcher.contracts.Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport;
import lombok.Getter;
import lombok.Setter;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;

@Getter
@Setter
public class ContractService {
    private final Web3j web3j;
    private String reportedNumber;
    public ContractService(){
        this.web3j = Web3j.build(new HttpService("http://localhost:7545"));
    }

    // Private key of an account.
    public final String PRIVATE_KEY = "0x29ef7a421a6774e26de86fe7a4f8573e806a39268904363567fe453759f325d2";
    private final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    // HEX Contract address of the solidity contract.
    private final String CONTRACT_ADDRESS = "0x00542DB10f49022B9Be9d991d3C03A43894F4fCA";

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

    public String retrieveBlockInfoFromGanache(int blockNumber) throws IOException {
        // Implement the logic to retrieve block information from Ganache
        EthBlock.Block block = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(blockNumber)), true).send().getBlock();
        String blockInfo = block.toString();

        return blockInfo;
    }
}
