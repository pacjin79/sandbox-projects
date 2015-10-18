/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import java.util.List;

/**
 *
 * @author Leo
 */
public interface IComponent {  
    public void initComponentInfo();
    public void initSubComponents();
    public void initComponentMetaData();
    public void parseComponentInfo(String componentData);
}
