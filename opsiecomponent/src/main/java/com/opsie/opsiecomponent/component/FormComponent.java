/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.opsie.opsiecomponent.ComponentEntityAware;
import com.opsie.opsiecomponent.ComponentMetaData;
import com.opsie.opsieentity.IComponentEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leo
 */
@Component
@Scope("prototype")
public class FormComponent extends ComponentEntityAware {

    public FormComponent(IComponentEntity entity) {
        super(entity);
    }

    public FormComponent(Class<? extends IComponentEntity> entityClass) {
        super(entityClass);
    }

    @Override
    public void loadSubComponents() {
        
    }

    @Override
    protected String provideComponentType() {
        return "formContainer";
    }

    @Override
    protected String provideComponentCategory() {
        return "commons";
    }

    @Override
    protected ComponentMetaData provideComponentMetaData() {
return null;
    }

    @Override
    protected void parseComponentData(JsonNode componentData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
