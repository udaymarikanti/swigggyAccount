package com.example.swiggyAccount.bank.controller;

import com.example.swiggyAccount.bank.model.Account;
import com.example.swiggyAccount.bank.model.AccountEntity;
import com.example.swiggyAccount.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping(value="/accountCreation",
            consumes = "application/json",
            produces = "application/json")

    public AccountEntity getAccountNumber(@RequestBody Account account) throws Exception {

        AccountEntity accountEntity  = accountService.createAccount(account);
        return  accountEntity;
    }


    @GetMapping(value="/accountSerach",
            consumes = "application/json",
            produces = "application/json")

    public  Account getAccountNumber(@RequestHeader("accountinput")
                                             String accountNumber) throws Exception {

        Account account =  accountService.getAccountByAccountNumberSql(accountNumber);
        return  account;

    }

//    @GetMapping(value="/accountSerachPan",
//            consumes = "application/json",
//            produces = "application/json")
//
//    public  Account getAccountNumberWithPan(@RequestHeader("accountinput")
//                                     String accountNumber,@RequestHeader("paninput")String pan) throws Exception {
//
//        Account account =  accountService.getAccountByAccountNumberAndPan(accountNumber,pan);
//        return  account;
//
//    }


    @GetMapping(value="/accountSerachPan",
            consumes = "application/json",
            produces = "application/json")

    public  Account getAccountNumberWithPan(@RequestHeader("accountinput")
                                            String accountNumber) {

        Account account =  accountService.getAccountByAccountNumber(accountNumber);
        return  account;

    }

}
