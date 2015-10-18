/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import java.util.List;


public abstract class Component implements IComponent {

    private String componentInstanceId;
    private String componentType;
    private String componentCategory;
    private List <Component> subComponents;  
    private ComponentMetaData componentMetaData;
    
    @Override
    public void initComponentInfo() {
    }

    @Override
    public void initSubComponents() {
    }

    @Override
    public void initComponentMetaData() {
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

    public List<Component> getSubComponents() {
        return subComponents;
    }

    public void setSubComponents(List<Component> subComponents) {
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
    
}
