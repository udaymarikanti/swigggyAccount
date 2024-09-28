package com.example.swiggyAccount.bank.repository;

import com.example.swiggyAccount.bank.model.Account;
import com.example.swiggyAccount.bank.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity,String> {
    AccountEntity findByAccountNumber(@Param("accountNumber") String accountNumber);

//@Query("select a from AccountEntity a left join a.accountAddressEntityList ad where a.accountNumber= ad.accountNumber and a.accountNumber=:accountNumber")
//    AccountEntity getAccountwithNumberAndPan(@Param("accountNumber") String accountNumber,@Param("pan")String pan);


    @Query("SELECT a FROM AccountEntity a LEFT JOIN a.accountAddressEntityList ad WHERE a.accountNumber = :accountNumber")
    AccountEntity getAccountwithNumber(@Param("accountNumber") String accountNumber);
}
