package com.example.swiggyAccount.bank.service;

import com.example.swiggyAccount.bank.mapper.AccountMapper;
import com.example.swiggyAccount.bank.mapper.AccountMapperImpl;
import com.example.swiggyAccount.bank.model.Account;
import com.example.swiggyAccount.bank.model.AccountEntity;
import com.example.swiggyAccount.bank.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    AccountRepo accountRepo;
    public Account getAccountByAccountNumber(String accountNumber) {
       AccountEntity accountEntity = accountRepo.findByAccountNumber(accountNumber);
     Account account =  accountMapper.entityToDto(accountEntity);

        return account;
    }

    public Account getAccountByAccountNumberSql(String accountNumber) {
        AccountEntity accountEntity = accountRepo.findByAccountNumber(accountNumber);
        Account account =  accountMapper.entityToDto(accountEntity);

        return account;
    }

//    public Account getAccountByAccountNumberAndPan(String accountNumber,String pan) {
//        AccountEntity accountEntity = accountRepo.getAccountwithNumber(accountNumber,pan);
//        Account account =  accountMapper.entityToDto(accountEntity);
//
//        return account;
//    }

    public  AccountEntity createAccount(Account account){
       AccountEntity accountEntity = accountMapper.dTOtoEntity(account);
       accountEntity.setAccountNumber(UUID.randomUUID().toString());
       return accountRepo.save(accountEntity);
    }



}
