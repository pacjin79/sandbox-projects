/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.test.entities;

import java.util.List;

/**
 *
 * @author Leo
 */
public class Phone {
    
    private String phoneNumber;
    private String phoneType;
    List <PhoneApps> phoneApps;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public List<PhoneApps> getPhoneApps() {
        return phoneApps;
    }

    public void setPhoneApps(List<PhoneApps> phoneApps) {
        this.phoneApps = phoneApps;
    }
    
    
}
