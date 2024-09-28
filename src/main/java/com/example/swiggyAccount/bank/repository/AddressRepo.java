package com.example.swiggyAccount.bank.repository;

import com.example.swiggyAccount.bank.model.AccountAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AccountAddressEntity ,Long> {
}
