/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.component.decorator;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsie.opsiecomponent.Component;
import com.opsie.opsiecomponent.IComponent;
import com.opsie.opsiecomponent.processor.IComponentProcessor;

/**
 *
 * @author Leo
 */
public abstract class ComponentDecorator implements IComponent {
    
    protected Component componentToDecorate;
    protected IComponentProcessor componentProcessor;

    public ComponentDecorator(Component componentToDecorate, IComponentProcessor componentProcessor){
        this.componentToDecorate = componentToDecorate;
        this.componentProcessor = componentProcessor;
    }
            
    @Override
    public void initComponentInfo() {
        componentToDecorate.initComponentInfo();
    }

    @Override
    public void loadSubComponents() {
        componentToDecorate.loadSubComponents();
    }

    @Override
    public void loadComponentMetaData() {
        componentToDecorate.loadComponentMetaData();
    }

    @Override
    public void parseComponentInfo(String componentData) {
        componentToDecorate.parseComponentInfo(componentData);
    }

    @Override
    public JsonNode toJson() {
       return componentToDecorate.toJson();
    }
    
}
