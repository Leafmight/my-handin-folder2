/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class CustomerDTO {

    private Long customerID;
    private String fullName;
    private String accountNumber;
    private double balance;

    public CustomerDTO(BankCustomer bankCustomer) {
        String fn = bankCustomer.getFirstName() + " " + bankCustomer.getLastName();
        this.customerID = bankCustomer.getId();
        this.fullName = fn;
        this.accountNumber = bankCustomer.getAccountNumber();
        this.balance = bankCustomer.getBalance();
    }
    
    

}
