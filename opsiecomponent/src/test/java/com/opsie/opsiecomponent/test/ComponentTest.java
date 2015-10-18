/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsiecomponent.test;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Leo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ComponentConfig.class})
public class ComponentTest {
    
    @Autowired
    private IComponentProcessor componentProcessor;
    
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
    public void test_component_decorate(){
        PageComponent pageComponent = new PageComponent();
        componentProcessor.processComponent(pageComponent);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String data = objectMapper.writeValueAsString(pageComponent);
            System.out.println("data = "+data);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ComponentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        SectionDecorator sectionDecorator = new SectionDecorator(pageComponent, componentProcessor);
        componentProcessor.processComponent(sectionDecorator);
        try {
            String data = objectMapper.writeValueAsString(sectionDecorator.getComponentMetaData());
            System.out.println("after decorate data = "+data);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ComponentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
