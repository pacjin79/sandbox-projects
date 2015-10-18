/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

/**
 *
 * @author Leo
 */
public interface IComponent {  
    public void initComponentInfo();
    public void loadSubComponents();
    public void loadComponentMetaData();
    public void parseComponentInfo(String componentData);
    public JsonNode toJson();
}
