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

@Controller
public class UserController {
    private final ContractService contractService = new ContractService();
    private final Credentials contractCredentials = contractService.getCredentialsFromPrivateKey();

    @Autowired
    private UsersService usersService;

    @GetMapping(path="")
    public String sayHello(){
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute User user){
        System.out.println("Register request: "+ user);
        User registeredUser = usersService.registerUser(user.getName(), user.getPassword(), user.getPhoneNumber());
        return registeredUser == null ? "error!" : "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        User dbUser = usersService.authenticate(user.getPhoneNumber(), user.getPassword());
        if (dbUser != null){
            System.out.println("Successfully loginned" + user.getName());
            return "report_page";
        }else
            return "Failed to login";
    }

    @GetMapping("/report")
    public String getReportPage(){
        return "report_page";
    }

    @PostMapping("/report")
    public String reportNumber(Model model){
        model.addAttribute("reportNumber");
        Src_main_resources_solidity_PhoneScamCatcher_sol_PhoneNumberReport phoneNumberReport = contractService
                .loadContract(contractService.getCONTRACT_ADDRESS(),
                        contractService.getWeb3j(), contractCredentials);

        
        return "A number has been reported: ";
    }

}
