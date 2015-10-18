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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author leojin
 */
public class TaskPanelComponent extends Component {

    @Override
    protected String provideComponentType() {
        return "taskPanel";
    }

    @Override
    protected String provideComponentCategory() {
        return "commons";
    }

    @Override
    protected ComponentMetaData provideComponentMetaData() {
        Map<String, String> testTaskData = new HashMap<>();
        testTaskData.put("task1", "Go do Laundry");
        testTaskData.put("task2", "Pick up the kids");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode contentData = mapper.valueToTree(testTaskData);
        ComponentMetaData metaData = new ComponentMetaData(contentData);
        return metaData;
    }
    
}
