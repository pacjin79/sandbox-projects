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
public interface IComponentEntityAware extends IComponent {
    
    public Class <? extends IComponentEntity> provideSupportedEntityClass();
}
