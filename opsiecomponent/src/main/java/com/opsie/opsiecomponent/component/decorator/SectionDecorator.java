/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.component.decorator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsie.opsiecomponent.Component;
import com.opsie.opsiecomponent.ComponentMetaData;
import com.opsie.opsiecomponent.IComponent;
import com.opsie.opsiecomponent.component.SectionComponent;
import com.opsie.opsiecomponent.processor.IComponentProcessor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leojin
 */
public class SectionDecorator implements IComponent {
    
    private final Component componentToDecorate;
    private final boolean sectionEnabled = true;
    private final List <SectionComponent> sections = new ArrayList <> ();
    private IComponentProcessor componentProcessor = null;
    private ComponentMetaData componentMetaData = null;
    
    public SectionDecorator(Component component, IComponentProcessor componentProcessor){
        this.componentToDecorate = component;
        this.componentProcessor = componentProcessor;
    }

    @Override
    public void initComponentInfo() {
        componentToDecorate.initComponentInfo();
    }

    @Override
    public void initSubComponents() {
        componentToDecorate.initSubComponents();
        SectionComponent sectionComponent = new SectionComponent();
        sectionComponent.getSubComponents().addAll(componentToDecorate.getSubComponents());
        componentProcessor.processComponent(sectionComponent);
        componentToDecorate.setSubComponents(new ArrayList<>());
        this.sections.add(sectionComponent);
        componentToDecorate.getSubComponents().addAll(this.sections);
        componentToDecorate.initComponentMetaData();
    }

    @Override
    public void initComponentMetaData() {
        componentToDecorate.initComponentMetaData();
         //ObjectMapper mapper = new ObjectMapper();
       // JsonNode contentData = mapper.valueToTree(componentToDecorate);
 //componentMetaData = new ComponentMetaData(contentData);
    }

    @Override
    public void parseComponentInfo(String componentData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isSectionEnabled(){
        return sectionEnabled;
    }

//    public ComponentMetaData getComponentMetaData() {
//        return componentMetaData;
//    }
//
//    public void setComponentMetaData(ComponentMetaData componentMetaData) {
//        this.componentMetaData = componentMetaData;
//    }

    @Override
    public JsonNode toJson() {
        return componentToDecorate.toJson();
    }
}
