/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opsie.drools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.KieResources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.kie.api.builder.Message.Level.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

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
    public void testMyRulesExection() {
        KieServices kieServices = KieServices.Factory.get();
        KieResources kieResources = kieServices.getResources();
        KieRepository kieRepository = kieServices.getRepository();
        KieFileSystem fileSystem = null;

        try {
            String rulesStr = IOUtils.toString(myRulesDrl.getInputStream());
            fileSystem = kieServices.newKieFileSystem();
            org.kie.api.io.Resource resource = kieResources.newByteArrayResource(rulesStr.getBytes(Charset.defaultCharset()));
            resource.setSourcePath("demo.myrules.drl");
            fileSystem.write(resource);
           // fileSystem.write(kieResources.newFileSystemResource(myRulesDrl.getFile()));
            //fileSystem.write("src/test/resources/data/myrule.drl", kieResources.newByteArrayResource(rulesStr.getBytes(Charset.defaultCharset())));
        } catch (IOException ex) {
            Logger.getLogger(TestDroolsExecution.class.getName()).log(Level.SEVERE, null, ex);
        }
        KieBuilder kieBuilder = kieServices.newKieBuilder(fileSystem);
        kieBuilder.buildAll();

        if (kieBuilder.getResults().hasMessages(ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kieBuilder.getResults().toString());
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
        KieSession kieSession = kieContainer.newKieSession();
        Account account = new Account(200);
        account.withdraw(150);
        kieSession.insert(account);
        kieSession.fireAllRules();
    }
}
