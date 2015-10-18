/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsie.opsiecomponent.component.PageComponent;
import com.opsie.opsiecomponent.component.TaskPanelComponent;
import com.opsie.opsiecomponent.component.decorator.SectionDecorator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.opsie.opsiecomponent.config.ComponentConfig;
import com.opsie.opsiecomponent.processor.IComponentProcessor;
import com.opsie.opsieentity.TaskEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
/**
 *
 * @author Leo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ComponentConfig.class})
public class ComponentTest {
    
    @Autowired
    private IComponentProcessor componentProcessor;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Value("classpath:testdata/TestPageWithTaskComponentData.json")
    Resource testPageWithTestsData;
    
    public ComponentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initComponentInfo method, of class Component.
     */
    @Test
    public void test_component_init() {
        TaskPanelComponent taskComponent = new TaskPanelComponent();
        componentProcessor.processComponent(taskComponent);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String data = objectMapper.writeValueAsString(taskComponent);
            System.out.println("data = "+data);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ComponentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void test_component_decorate(){        PageComponent pageComponent = applicationContext.getBean(PageComponent.class);
        componentProcessor.processComponent(pageComponent);
        TaskPanelComponent taskComponent = applicationContext.getBean(TaskPanelComponent.class);
        List <TaskEntity> tasks = new ArrayList <>();
        for(int i=0; i < 2; i++){
            TaskEntity entity = new TaskEntity();
            entity.setTaskName("Task"+i);
            entity.setDueDate(new Date());
            tasks.add(entity);
        }
        taskComponent.setTasksToDisplay(tasks);
        componentProcessor.processComponent(taskComponent);
        pageComponent.getSubComponents().add(taskComponent);
        componentProcessor.processComponent(pageComponent);
        System.out.println("prior to decorate data = "+pageComponent.toJson().toString());
        SectionDecorator sectionDecorator = new SectionDecorator(pageComponent, componentProcessor);
        componentProcessor.processComponent(sectionDecorator);
        System.out.println("after decorate data = "+pageComponent.toJson().toString());
    }
    
    @Test
    public void test_parse_json(){
        String testData = null;
        try {
            testData = IOUtils.toString(testPageWithTestsData.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ComponentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(testData);
        System.out.println("node here = "+node.toString());
    }
}
