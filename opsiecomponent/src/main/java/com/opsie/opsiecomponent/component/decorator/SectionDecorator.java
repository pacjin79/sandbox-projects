/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.component.decorator;

import com.opsie.opsiecomponent.Component;
import com.opsie.opsiecomponent.component.SectionComponent;
import com.opsie.opsiecomponent.processor.IComponentProcessor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leojin
 */
public class SectionDecorator extends ComponentDecorator {
    
    private final List <SectionComponent> sections = new ArrayList <> ();
    
    public SectionDecorator(Component component, IComponentProcessor componentProcessor){
       super(component, componentProcessor);
    }

    @Override
    public void loadSubComponents() {
        componentToDecorate.loadSubComponents();
        SectionComponent sectionComponent = new SectionComponent();
        sectionComponent.getSubComponents().addAll(componentToDecorate.getSubComponents());
        componentProcessor.processComponent(sectionComponent);
        componentToDecorate.setSubComponents(new ArrayList<>());
        this.sections.add(sectionComponent);
        componentToDecorate.getSubComponents().addAll(this.sections);
        componentToDecorate.loadComponentMetaData();
    }
    
    @Override
    public void parseComponentInfo(String componentData) {
        componentToDecorate.parseComponentInfo(componentData);
    }
}
