/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import com.opsie.opsieentity.IComponentEntity;

/**
 *
 * @author Leo
 */
public abstract class ComponentEntityAware extends Component implements IComponentEntityAware {

    protected Class<? extends IComponentEntity> supportedEntityClass;
    protected IComponentEntity componentEntity;

    public ComponentEntityAware(IComponentEntity entity){
        this.componentEntity = entity;
        this.supportedEntityClass = entity.getClass();
    }
    
    public ComponentEntityAware(Class <? extends IComponentEntity> entityClass){
        this.supportedEntityClass = entityClass;
    }
    
    @Override
    public Class<? extends IComponentEntity> provideSupportedEntityClass() {
        return supportedEntityClass;
    }
}
