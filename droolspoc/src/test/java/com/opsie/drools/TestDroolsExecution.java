/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.drools;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Leo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class}, loader = ContextLoader.class)
public class TestDroolsExecution {
    
    @Value("classpath:data/myrule.drl")
    private Resource myRulesDrl;
    
    @Test
    public void testMyRulesExection (){
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        try {
            String rulesStr = IOUtils.toString(myRulesDrl.getInputStream());
            knowledgeBuilder.add(ResourceFactory.newByteArrayResource(rulesStr.getBytes(Charset.defaultCharset())), ResourceType.DRL);
        } catch (IOException ex) {
            Logger.getLogger(TestDroolsExecution.class.getName()).log(Level.SEVERE, null, ex);
        }
        KnowledgeBase knowledgeBase = knowledgeBuilder.newKnowledgeBase();
        StatelessKnowledgeSession knowledgeSession = knowledgeBase.newStatelessKnowledgeSession();
        Account account = new Account(200);
        account.withdraw(150);
        knowledgeSession.execute(account);
    }
}
