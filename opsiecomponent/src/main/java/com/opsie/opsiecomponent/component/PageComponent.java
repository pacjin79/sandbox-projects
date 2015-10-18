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
import java.util.ArrayList;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author leojin
 */
@org.springframework.stereotype.Component
@Scope("prototype")
public class PageComponent extends Component {
    
    public PageComponent(){
        super();
        setSubComponents(new ArrayList <>());
    }

    @Override
    protected String provideComponentType() {
        return "page";
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
        
        
    }
    
}
