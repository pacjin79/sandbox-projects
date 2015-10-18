/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


public abstract class Component implements IComponent {

    private String componentInstanceId;
    private String componentType;
    private String componentCategory;
    private List <IComponent> subComponents;  
    private ComponentMetaData componentMetaData;
    private ComponentConfiguration componentConfiguration;
    
    @Override
    public void initComponentInfo() {
        componentCategory = provideComponentCategory();
        componentType = provideComponentType();
    }

    @Override
    public void initSubComponents() {
    }

    @Override
    public void initComponentMetaData() {
        componentMetaData = provideComponentMetaData();
    }

    @Override
    public void parseComponentInfo(String componentData) {}
    
     public String getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(String componentInstanceId) {
        this.componentInstanceId = componentInstanceId;
    }

    public String getComponentType() {
        return componentType;
    }

    public List<IComponent> getSubComponents() {
        return subComponents;
    }

    public void setSubComponents(List<IComponent> subComponents) {
        this.subComponents = subComponents;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public ComponentMetaData getComponentMetaData() {
        return componentMetaData;
    }

    public void setComponentMetaData(ComponentMetaData componentMetaData) {
        this.componentMetaData = componentMetaData;
    }

    public String getComponentCategory() {
        return componentCategory;
    }

    public void setComponentCategory(String componentCategory) {
        this.componentCategory = componentCategory;
    }

    public ComponentConfiguration getComponentConfiguration() {
        return componentConfiguration;
    }

    public void setComponentConfiguration(ComponentConfiguration componentConfiguration) {
        this.componentConfiguration = componentConfiguration;
    }
    
    @Override
    public JsonNode toJson(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.valueToTree(this);
    }
    
    protected abstract String provideComponentType();
    protected abstract String provideComponentCategory();
    protected abstract ComponentMetaData provideComponentMetaData();
    
}
