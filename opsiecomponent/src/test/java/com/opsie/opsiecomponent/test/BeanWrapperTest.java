/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.test;

import com.opsie.opsiecomponent.test.entities.CustomerEntity;
import com.opsie.opsiecomponent.test.entities.Phone;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 *
 * @author Leo
 */
public class BeanWrapperTest {
    
    @Test
    public void testBeanWrapper(){
        CustomerEntity customerEntity = new CustomerEntity();
        BeanWrapper beanWrapper = new BeanWrapperImpl(customerEntity);
        List <Phone> phones = new ArrayList<>();
        beanWrapper.setAutoGrowNestedPaths(true);
        beanWrapper.setPropertyValue("phones[0].phoneNumber", "888-88-8888");
        System.out.println("phone size = "+customerEntity.getPhones().size());
    }
}
