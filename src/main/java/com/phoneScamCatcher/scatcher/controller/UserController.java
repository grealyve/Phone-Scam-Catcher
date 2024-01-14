package com.phoneScamCatcher.scatcher.controller;

import com.phoneScamCatcher.scatcher.contracts.Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport;
import com.phoneScamCatcher.scatcher.entity.BlockNumberForm;
import com.phoneScamCatcher.scatcher.entity.User;
import com.phoneScamCatcher.scatcher.service.ContractService;
import com.phoneScamCatcher.scatcher.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;

@Controller
public class UserController {
    private final ContractService contractService = new ContractService();
    private final Credentials contractCredentials = contractService.getCredentialsFromPrivateKey();

    @Autowired
    private UsersService usersService;

    // Home page GET method handler
    @GetMapping(path = "")
    public String sayHello() {
        return "index";
    }

    // Register page GET method handler
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    // Register page POST method handler
    @PostMapping("/register")
    @ResponseBody
    public ModelAndView register(@ModelAttribute User user) {
        System.out.println("Register request: " + user);
        User registeredUser = usersService.registerUser(user.getName(), user.getPassword(), user.getPhoneNumber());
        return registeredUser == null ? new ModelAndView("redirect:/register") : new ModelAndView("redirect:/login");
    }

    // Login page GET method handler
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    // Login page POST method handler
    @PostMapping("/login")
    @ResponseBody
    public ModelAndView login(@ModelAttribute User user, Model model) {
        User dbUser = usersService.authenticate(user.getPhoneNumber(), user.getPassword());
        if (dbUser != null) {
            System.out.println("Successfully loginned: " + dbUser.getName() + "\nPhone Number: " + dbUser.getPhoneNumber());
            return new ModelAndView("redirect:/");
        } else {
            model.addAttribute("error", "Failed to login user");
            return new ModelAndView("redirect:/login");
        }
    }

    // Report page GET method handler
    @GetMapping("/report")
    public String getReportPage(Model model) {
        model.addAttribute("reportNumber", new ContractService());
        return "report_page";
    }

    // Report page POST method handler
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
            return "Please enter a valid phone number";
        }

        // Redirect to a success page or handle it based on your requirements
        return "Successfully reported the number: " + contractService.getReportedNumber();
    }

    // Report Check page GET method handler
    @GetMapping("/reportCheck")
    public String getReportCheckPage(Model model) {
        model.addAttribute("blockNumber", new BlockNumberForm());
        return "report_check";
    }

    // Report Check page POST method handler
    @PostMapping("/reportCheck")
    @ResponseBody
    public String checkReportedBlock(@ModelAttribute BlockNumberForm blockNumberForm) {
        int blockNumber = blockNumberForm.getBlockNumber();

        // Retrieve block information from Ganache
        String blockInfo;
        try {
            blockInfo = contractService.retrieveBlockInfoFromGanache(blockNumber);
        } catch (IOException e) {
            System.out.println("Error: " + e);
            return "Error during checking" + e;
        }


        return "Block Information: " + blockInfo;
    }


}
