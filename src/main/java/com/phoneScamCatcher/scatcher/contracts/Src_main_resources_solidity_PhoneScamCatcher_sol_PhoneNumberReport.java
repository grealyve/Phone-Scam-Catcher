package com.phoneScamCatcher.scatcher.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.0.
 */
@SuppressWarnings("rawtypes")
public class Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport extends Contract {
    public static final String BINARY = "608060405234801561000f575f80fd5b506102c38061001d5f395ff3fe608060405234801561000f575f80fd5b5060043610610034575f3560e01c806385556f9114610038578063911e904e1461005d575b5f80fd5b61004b610046366004610138565b610072565b60405190815260200160405180910390f35b61007061006b366004610138565b610098565b005b5f80826040516100829190610205565b9081526040519081900360200190205492915050565b60015f826040516100a99190610205565b90815260200160405180910390205f015f8282546100c79190610220565b925050819055507fc46aa8ae8d7178a76af2501d0c47d7ce3f8ef2c4f8023b31247c04c7ef02d5c2815f836040516100ff9190610205565b908152604051908190036020018120546101199291610253565b60405180910390a150565b634e487b7160e01b5f52604160045260245ffd5b5f60208284031215610148575f80fd5b813567ffffffffffffffff8082111561015f575f80fd5b818401915084601f830112610172575f80fd5b81358181111561018457610184610124565b604051601f8201601f19908116603f011681019083821181831017156101ac576101ac610124565b816040528281528760208487010111156101c4575f80fd5b826020860160208301375f928101602001929092525095945050505050565b5f5b838110156101fd5781810151838201526020016101e5565b50505f910152565b5f82516102168184602087016101e3565b9190910192915050565b8082018281125f83128015821682158216171561024b57634e487b7160e01b5f52601160045260245ffd5b505092915050565b604081525f83518060408401526102718160608501602088016101e3565b602083019390935250601f91909101601f19160160600191905056fea2646970667358221220755eaf21e6c1490b7561634e76a2d58ec1a5623c611f9691e21f1934539eb90064736f6c63430008170033";

    public static final String FUNC_CHECKREPORTS = "checkReports";

    public static final String FUNC_REPORTNUMBER = "reportNumber";

    public static final Event PHONENUMBERREPORTED_EVENT = new Event("PhoneNumberReported", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<PhoneNumberReportedEventResponse> getPhoneNumberReportedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PHONENUMBERREPORTED_EVENT, transactionReceipt);
        ArrayList<PhoneNumberReportedEventResponse> responses = new ArrayList<PhoneNumberReportedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PhoneNumberReportedEventResponse typedResponse = new PhoneNumberReportedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.phoneNumber = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static PhoneNumberReportedEventResponse getPhoneNumberReportedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PHONENUMBERREPORTED_EVENT, log);
        PhoneNumberReportedEventResponse typedResponse = new PhoneNumberReportedEventResponse();
        typedResponse.log = log;
        typedResponse.phoneNumber = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<PhoneNumberReportedEventResponse> phoneNumberReportedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getPhoneNumberReportedEventFromLog(log));
    }

    public Flowable<PhoneNumberReportedEventResponse> phoneNumberReportedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PHONENUMBERREPORTED_EVENT));
        return phoneNumberReportedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> checkReports(String phoneNumber) {
        final Function function = new Function(FUNC_CHECKREPORTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(phoneNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> reportNumber(String phoneNumber) {
        final Function function = new Function(
                FUNC_REPORTNUMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(phoneNumber)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class PhoneNumberReportedEventResponse extends BaseEventResponse {
        public String phoneNumber;

        public BigInteger count;
    }
}
