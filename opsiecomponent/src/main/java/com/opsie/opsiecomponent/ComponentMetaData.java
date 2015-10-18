/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import com.fasterxml.jackson.databind.JsonNode;

/**
 *
 * @author Leo
 */
public class ComponentMetaData {

    private JsonNode contentData;

    public ComponentMetaData(JsonNode contentData) {
        this.contentData = contentData;
    }

    public JsonNode getContentData() {
        return contentData;
    }
}
