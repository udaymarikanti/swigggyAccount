package com.example.swiggyAccount.bank.mapper;

import com.example.swiggyAccount.bank.model.Account;
import com.example.swiggyAccount.bank.model.AccountAddressEntity;
import com.example.swiggyAccount.bank.model.AccountEntity;
import com.example.swiggyAccount.bank.model.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapperImpl implements AccountMapper{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountEntity dTOtoEntity(Account account) {
        AccountAddressEntity accountAddressEntity = modelMapper.map(account.getAddress(), AccountAddressEntity.class);

        AccountEntity accountEntity = modelMapper.map(account, AccountEntity.class);

        // Prevent circular reference by not setting the full account entity again in accountAddressEntity
        accountAddressEntity.setAccountEntity(null);

        List<AccountAddressEntity> accountAddressEntityList = new ArrayList<>();
        accountAddressEntityList.add(accountAddressEntity);

        accountEntity.setAccountAddressEntityList(accountAddressEntityList);

        return accountEntity;
    }

    @Override
    public Account entityToDto(AccountEntity accountEntity) {
        Account account = modelMapper.map(accountEntity, Account.class);

        if (accountEntity.getAccountAddressEntityList() != null && !accountEntity.getAccountAddressEntityList().isEmpty()) {
            AccountAddressEntity accountAddressEntity = accountEntity.getAccountAddressEntityList().get(0);
            Address address = modelMapper.map(accountAddressEntity, Address.class);

            account.setAddress(address);
        }

        return account;
    }
}

