/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsie.opsiecomponent.Component;
import com.opsie.opsiecomponent.ComponentMetaData;
import com.opsie.opsiecomponent.IComponent;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author leojin
 */
@org.springframework.stereotype.Component
@Scope("prototype")
public class SectionComponent extends Component {
    
    public SectionComponent(){
        super();
        List <IComponent> subComponents = new ArrayList<>();
        setSubComponents(subComponents);
    }
    
    @Override
    protected String provideComponentType() {
        return "pageSection";
    }

    @Override
    protected String provideComponentCategory() {
        return "commons";
    }

    @Override
    protected ComponentMetaData provideComponentMetaData() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode contentData = mapper.valueToTree(getSubComponents());
        ComponentMetaData componentMetaData = new ComponentMetaData(contentData);
        return componentMetaData;
    }

    @Override
    protected void parseComponentData(JsonNode componentData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
