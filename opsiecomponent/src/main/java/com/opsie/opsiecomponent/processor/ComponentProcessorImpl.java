/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.processor;

import com.opsie.opsiecomponent.IComponent;
import org.springframework.stereotype.Component;

@Component
public class ComponentProcessorImpl implements IComponentProcessor {

    @Override
    public void processComponent(IComponent component) {
        component.initComponentInfo();
        component.initSubComponents();
        component.initComponentMetaData();
    }
    
}
