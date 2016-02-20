/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.drools;

/**
 *
 * @author Leo
 */
public class Account {
    private Integer balance;
    
    public Account(){
    }
    
    public Account(Integer balance){
        this.balance = balance;
    }

    /**
     * @return the balance
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    
    public void withdraw(int money){
        this.balance -= money;
    }
}
