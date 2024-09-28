package com.example.swiggyAccount.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "account", schema = "bank")
@Data
@AllArgsConstructor
public class AccountEntity {


  public AccountEntity(){

  }

  @Id
  @Column(name = "accountnumber", nullable = false)
  private String accountNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pan", nullable = false)
  private String pan;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "balance", nullable = false)
  private double balance;

  @OneToMany(mappedBy = "accountEntity", cascade = CascadeType.ALL)
  private List<AccountAddressEntity> accountAddressEntityList;
}
