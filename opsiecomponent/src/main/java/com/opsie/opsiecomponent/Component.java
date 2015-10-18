/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsie.opsiecomponent.processor.IComponentProcessor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Component implements IComponent {

    private String componentInstanceId;
    private String componentType;
    private String componentCategory;
    private List<IComponent> subComponents;
    private ComponentMetaData componentMetaData;
    private ComponentConfiguration componentConfiguration;
    protected IComponentProcessor componentProcessor;

    @Override
    public void initComponentInfo() {
        componentCategory = provideComponentCategory();
        componentType = provideComponentType();
    }

    @Override
    public void loadSubComponents() {
    }

    @Override
    public void loadComponentMetaData() {
        componentMetaData = provideComponentMetaData();
    }

    @Override
    public void parseComponentInfo(String componentData) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(componentData);
        this.componentType = node.get("componentType").textValue();
        this.componentCategory = node.get("componentCategory").textValue();
        this.parseComponentData(node);
    }

    public String getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(String componentInstanceId) {
        this.componentInstanceId = componentInstanceId;
    }

    public String getComponentType() {
        return componentType;
    }

    @JsonIgnore
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

    @Autowired
    public void setComponentProcessor(IComponentProcessor componentProcessor) {
        this.componentProcessor = componentProcessor;
    }

    @Override
    public JsonNode toJson() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.valueToTree(this);
    }

    protected abstract String provideComponentType();

    protected abstract String provideComponentCategory();

    protected abstract ComponentMetaData provideComponentMetaData();
    
    protected abstract void parseComponentData(JsonNode componentData);

}
