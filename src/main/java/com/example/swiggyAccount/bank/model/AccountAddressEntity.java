package com.example.swiggyAccount.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_address", schema = "bank")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountAddressEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "add1", nullable = false)
 private String add1;

 @Column(name = "add2")
 private String add2;

 @Column(name = "city", nullable = false)
 private String city;

 @Column(name = "state", nullable = false)
 private String state;

 @Column(name = "pincode", nullable = false)
 private String pincode;

 @Column(name = "status", nullable = false)
 private int status;

 @ManyToOne
 @JoinColumn(name = "accountnumber")
 private AccountEntity accountEntity;
}
