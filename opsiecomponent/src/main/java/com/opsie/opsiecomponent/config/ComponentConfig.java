/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Leo
 */
@Configuration
@ComponentScan(
    basePackages = {"com.opsie.*"}
)
public class ComponentConfig {
    
}
