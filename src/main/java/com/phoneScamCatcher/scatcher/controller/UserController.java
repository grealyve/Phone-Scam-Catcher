package com.phoneScamCatcher.scatcher.controller;

import com.phoneScamCatcher.scatcher.contracts.Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport;
import com.phoneScamCatcher.scatcher.entity.User;
import com.phoneScamCatcher.scatcher.service.ContractService;
import com.phoneScamCatcher.scatcher.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Controller
public class UserController {
    private final ContractService contractService = new ContractService();
    private final Credentials contractCredentials = contractService.getCredentialsFromPrivateKey();

    @Autowired
    private UsersService usersService;

    @GetMapping(path = "")
    public String sayHello() {
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute User user) {
        System.out.println("Register request: " + user);
        User registeredUser = usersService.registerUser(user.getName(), user.getPassword(), user.getPhoneNumber());
        return registeredUser == null ? "error!" : "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        User dbUser = usersService.authenticate(user.getPhoneNumber(), user.getPassword());
        if (dbUser != null) {
            System.out.println("Successfully loginned" + user.getName());
            return "report_page";
        } else
            return "Failed to login";
    }

    @GetMapping("/report")
    public String getReportPage(Model model) {
        model.addAttribute("reportNumber", new ContractService());
        return "report_page";
    }

    @PostMapping("/report")
    @ResponseBody
    public String reportNumber(@ModelAttribute ContractService contractService) {
        String reportedNumber = contractService.getReportedNumber();

        // Check if reportedNumber is not null
        if (reportedNumber != null) {
            // Set the reported number in the ContractService instance
            contractService.setReportedNumber(reportedNumber);

            Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport phoneNumberReport = contractService
                    .loadContract(contractService.getCONTRACT_ADDRESS(),
                            contractService.getWeb3j(), contractCredentials);

            try {
                TransactionReceipt transactionReceipt = phoneNumberReport.reportNumber(reportedNumber).send();
                System.out.println(transactionReceipt.getBlockNumber());
            } catch (Exception e) {
                System.out.println("Error during reporting a phone number: " + e);
                // Handle the error, for example, by adding an attribute to the model
                // and displaying it on the same page
                return "report_page";
            }
        } else {
            System.out.println("Reported number is null. Handle this case appropriately.");
            // Handle the case where reportedNumber is null, e.g., display an error message
            return "report_page";
        }

        // Redirect to a success page or handle it based on your requirements
        return "Successfully reported the number: " + contractService.getReportedNumber();
    }

}
