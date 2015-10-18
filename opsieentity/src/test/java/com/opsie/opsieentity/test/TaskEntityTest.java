/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.opsieentity.test;

import com.opsie.opsieentity.TaskEntity;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class TaskEntityTest {
    
    public TaskEntityTest() {
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
     * Test of getTaskName method, of class TaskEntity.
     */
    @Test
    public void testGetTaskName() {
        System.out.println("getTaskName");
        TaskEntity instance = new TaskEntity();
        String expResult = "";
        String result = instance.getTaskName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskName method, of class TaskEntity.
     */
    @Test
    public void testSetTaskName() {
        System.out.println("setTaskName");
        String taskName = "";
        TaskEntity instance = new TaskEntity();
        instance.setTaskName(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDueDate method, of class TaskEntity.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        TaskEntity instance = new TaskEntity();
        Date expResult = null;
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDueDate method, of class TaskEntity.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        Date dueDate = null;
        TaskEntity instance = new TaskEntity();
        instance.setDueDate(dueDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
