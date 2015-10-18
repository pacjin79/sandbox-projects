/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsie.opsiecomponent.Component;
import com.opsie.opsiecomponent.ComponentMetaData;
import com.opsie.opsiecomponent.IComponent;
import com.opsie.opsieentity.TaskEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author leojin
 */
@org.springframework.stereotype.Component
@Scope("prototype")
public class TaskPanelComponent extends Component {

    private List<TaskEntity> tasksToDisplay;

    @Override
    protected String provideComponentType() {
        return "taskPanel";
    }

    @Override
    protected String provideComponentCategory() {
        return "commons";
    }

    @Override
    public void loadSubComponents() {
        List<IComponent> subComponents = new ArrayList<>();
        if (tasksToDisplay != null) {
            for (TaskEntity taskEntity : tasksToDisplay) {
                IComponent taskItemComponent = new TaskItemComponent(taskEntity);
                componentProcessor.processComponent(taskItemComponent);
                subComponents.add(taskItemComponent);
            }
        }
        setSubComponents(subComponents);
    }

    @Override
    protected ComponentMetaData provideComponentMetaData() {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode contentData = mapper.valueToTree(getSubComponents());
        ComponentMetaData metaData = new ComponentMetaData(contentData);
        return metaData;
    }

    @JsonIgnore
    public List<TaskEntity> getTasksToDisplay() {
        return tasksToDisplay;
    }

    public void setTasksToDisplay(List<TaskEntity> tasksToDisplay) {
        this.tasksToDisplay = tasksToDisplay;
    }

    @Override
    protected void parseComponentData(JsonNode componentData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
