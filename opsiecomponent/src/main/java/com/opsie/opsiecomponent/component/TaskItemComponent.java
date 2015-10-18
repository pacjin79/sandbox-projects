/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsie.opsiecomponent.ComponentEntityAware;
import com.opsie.opsiecomponent.ComponentMetaData;
import com.opsie.opsieentity.IComponentEntity;
import com.opsie.opsieentity.TaskEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leo
 */
@Component
@Scope("prototype")
public class TaskItemComponent extends ComponentEntityAware {

    public TaskItemComponent(TaskEntity entity) {
        super(entity);
    }

    @Override
    protected String provideComponentType() {
        return "taskItem";
    }

    @Override
    protected String provideComponentCategory() {
        return "commmons";
    }

    @Override
    protected ComponentMetaData provideComponentMetaData() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode contentData = mapper.valueToTree(componentEntity);
        ComponentMetaData metaData = new ComponentMetaData(contentData);
        return metaData;
    }

    @Override
    protected void parseComponentData(JsonNode componentData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
