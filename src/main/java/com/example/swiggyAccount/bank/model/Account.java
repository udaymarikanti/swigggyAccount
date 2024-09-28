package com.example.swiggyAccount.bank.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Account {
    private  String name;
    private  String accountNumber;
    private  String pan;
    private String mobile;
    private  double balance;
    private  Address address;
}
