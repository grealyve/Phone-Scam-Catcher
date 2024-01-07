package com.phoneScamCatcher.scatcher.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
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
    public static final String BINARY = "608060405234801561000f575f80fd5b5061088c8061001d5f395ff3fe608060405234801561000f575f80fd5b5060043610610055575f3560e01c80633f5f32b514610059578063632b2d6b1461006e5780636fa3885e146100cf5780638ddce039146100e2578063a87430ba14610103575b5f80fd5b61006c610067366004610549565b610124565b005b6100af61007c366004610549565b805160208183018101805160018083529383019290940191909120929052815490820154600290920154909160ff169083565b604080519384529115156020840152908201526060015b60405180910390f35b61006c6100dd366004610583565b610250565b6100f56100f03660046105f9565b610306565b6040519081526020016100c6565b61011661011136600461063b565b610376565b6040516100c69291906106ae565b335f9081526020819052604081206001018054610140906106db565b9050116101865760405162461bcd60e51b815260206004820152600f60248201526e2932b3b4b9ba32b9103334b939ba1760891b60448201526064015b60405180910390fd5b6001816040516101969190610713565b9081526040519081900360200190206001015460ff1661021957604051806060016040528060018152602001600115158152602001428152506001826040516101df9190610713565b9081526040805160209281900383019020835181559183015160018301805460ff1916911515919091179055919091015160029091015550565b6001808260405161022a9190610713565b90815260200160405180910390205f015f828254610248919061072e565b909155505050565b335f908152602081905260409020600101805461026c906106db565b1590506102bb5760405162461bcd60e51b815260206004820152601860248201527f5573657220616c726561647920726567697374657265642e0000000000000000604482015260640161017d565b6040805180820182528381526020808201849052335f9081529081905291909120815181906102ea9082610796565b50602082015160018201906102ff9082610796565b5050505050565b5f806001846040516103189190610713565b90815260408051918290036020908101832060608401835280548452600181015460ff161515918401919091526002015490820181905290915061035d90849061072e565b421161036b57519050610370565b5f9150505b92915050565b5f60208190529081526040902080548190610390906106db565b80601f01602080910402602001604051908101604052809291908181526020018280546103bc906106db565b80156104075780601f106103de57610100808354040283529160200191610407565b820191905f5260205f20905b8154815290600101906020018083116103ea57829003601f168201915b50505050509080600101805461041c906106db565b80601f0160208091040260200160405190810160405280929190818152602001828054610448906106db565b80156104935780601f1061046a57610100808354040283529160200191610493565b820191905f5260205f20905b81548152906001019060200180831161047657829003601f168201915b5050505050905082565b634e487b7160e01b5f52604160045260245ffd5b5f67ffffffffffffffff808411156104cb576104cb61049d565b604051601f8501601f19908116603f011681019082821181831017156104f3576104f361049d565b8160405280935085815286868601111561050b575f80fd5b858560208301375f602087830101525050509392505050565b5f82601f830112610533575f80fd5b610542838335602085016104b1565b9392505050565b5f60208284031215610559575f80fd5b813567ffffffffffffffff81111561056f575f80fd5b61057b84828501610524565b949350505050565b5f8060408385031215610594575f80fd5b823567ffffffffffffffff808211156105ab575f80fd5b818501915085601f8301126105be575f80fd5b6105cd868335602085016104b1565b935060208501359150808211156105e2575f80fd5b506105ef85828601610524565b9150509250929050565b5f806040838503121561060a575f80fd5b823567ffffffffffffffff811115610620575f80fd5b61062c85828601610524565b95602094909401359450505050565b5f6020828403121561064b575f80fd5b81356001600160a01b0381168114610542575f80fd5b5f5b8381101561067b578181015183820152602001610663565b50505f910152565b5f815180845261069a816020860160208601610661565b601f01601f19169290920160200192915050565b604081525f6106c06040830185610683565b82810360208401526106d28185610683565b95945050505050565b600181811c908216806106ef57607f821691505b60208210810361070d57634e487b7160e01b5f52602260045260245ffd5b50919050565b5f8251610724818460208701610661565b9190910192915050565b8082018082111561037057634e487b7160e01b5f52601160045260245ffd5b601f82111561079157805f5260205f20601f840160051c810160208510156107725750805b601f840160051c820191505b818110156102ff575f815560010161077e565b505050565b815167ffffffffffffffff8111156107b0576107b061049d565b6107c4816107be84546106db565b8461074d565b602080601f8311600181146107f7575f84156107e05750858301515b5f19600386901b1c1916600185901b17855561084e565b5f85815260208120601f198616915b8281101561082557888601518255948401946001909101908401610806565b508582101561084257878501515f19600388901b60f8161c191681555b505060018460011b0185555b50505050505056fea264697066735822122033140ef385ee727ec6f8aec78cd64c7fe4d4444fcee014fc0396e4eee77b4b5164736f6c63430008170033";

    public static final String FUNC_CHECKREPORTS = "checkReports";

    public static final String FUNC_REGİSTERUSER = "registerUser";

    public static final String FUNC_REPORTNUMBER = "reportNumber";

    public static final String FUNC_REPORTS = "reports";

    public static final String FUNC_USERS = "users";

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

    public RemoteFunctionCall<BigInteger> checkReports(byte[] phoneNumber, BigInteger timePeriod) {
        final Function function = new Function(FUNC_CHECKREPORTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(phoneNumber), 
                new org.web3j.abi.datatypes.generated.Uint256(timePeriod)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerUser(String name, byte[] phone) {
        final Function function = new Function(
                FUNC_REGİSTERUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.DynamicBytes(phone)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> reportNumber(byte[] phoneNumber) {
        final Function function = new Function(
                FUNC_REPORTNUMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(phoneNumber)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, Boolean, BigInteger>> reports(byte[] param0) {
        final Function function = new Function(FUNC_REPORTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, Boolean, BigInteger>>(function,
                new Callable<Tuple3<BigInteger, Boolean, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, Boolean, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<String, byte[]>> users(String param0) {
        final Function function = new Function(FUNC_USERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}));
        return new RemoteFunctionCall<Tuple2<String, byte[]>>(function,
                new Callable<Tuple2<String, byte[]>>() {
                    @Override
                    public Tuple2<String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, byte[]>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue());
                    }
                });
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
}
