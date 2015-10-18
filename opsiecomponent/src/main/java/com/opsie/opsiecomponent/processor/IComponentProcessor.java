/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.processor;

import com.opsie.opsiecomponent.IComponent;

/**
 *
 * @author Leo
 */
public interface IComponentProcessor {
    
    public void processComponent(IComponent component);
    public IComponent constructComponentFromMetaData(String metaData);
}
