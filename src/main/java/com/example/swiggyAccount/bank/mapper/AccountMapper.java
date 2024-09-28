package com.example.swiggyAccount.bank.mapper;

import com.example.swiggyAccount.bank.model.Account;
import com.example.swiggyAccount.bank.model.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")  // If you use Spring for dependency injection
public interface AccountMapper {

AccountEntity dTOtoEntity(Account account);

Account entityToDto(AccountEntity accountEntity);

}
