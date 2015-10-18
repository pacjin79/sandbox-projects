/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.processor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsie.opsiecomponent.IComponent;
import com.opsie.opsiecomponent.component.PageComponent;
import org.springframework.stereotype.Component;

@Component
public class ComponentProcessorImpl implements IComponentProcessor {

    @Override
    public void processComponent(IComponent component) {
        component.initComponentInfo();
        component.loadSubComponents();
        component.loadComponentMetaData();
    }

    @Override
    public IComponent constructComponentFromMetaData(String metaData) {
        //load page
        IComponent component = new PageComponent();
        component.parseComponentInfo(metaData);
        return component;
    }
    
}
