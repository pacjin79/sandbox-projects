/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author leojin
 */
public class ComponentConfiguration {

    private Map<String, Object> configurationParams;

    public ComponentConfiguration() {
        configurationParams = new HashMap<>();
    }

    public Map<String, Object> getConfigurationParams() {
        return configurationParams;
    }

    public void setConfigurationParams(Map<String, Object> configurationParams) {
        this.configurationParams = configurationParams;
    }

    public void addParam(String key, Object value) {
        this.configurationParams.put(key, value);
    }

    public void addAllParams(Map<String, Object> params) {
        this.configurationParams.putAll(params);
    }
}
