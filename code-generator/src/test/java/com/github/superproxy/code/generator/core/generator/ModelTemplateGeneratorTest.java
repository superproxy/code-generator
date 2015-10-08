package com.github.superproxy.code.generator.core.generator;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelExtendHandler;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelHandlerManager;
import com.github.superproxy.code.generator.core.generator.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelGeneratorConfig;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelTemplateGenerator;
import com.github.superproxy.code.generator.support.model.java.service.ServiceExtendHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

public class ModelTemplateGeneratorTest {
    @Test
    public void testGenerator() throws Exception {

        ModelTemplateGenerator generator = new ModelTemplateGenerator();
        ModelGeneratorConfig cfg = new ModelGeneratorConfig();
        cfg.setTemplateEngine(new FreeMarkerTplEngine());
        cfg.setOutPath("d:/env/test-model.java");
        cfg.setTplsRoot(new File("src/test/resources").getAbsolutePath());
        cfg.setTplPath("test-model.ftl");
        cfg.setModel(new Model() {
        });

        ModelHandlerManager modelHandlerManager = new ModelHandlerManager();
        modelHandlerManager.registerHandler(new ModelExtendHandler() {
            @Override
            public String handlerId() {
                return "test";
            }

            @Override
            public void extendModel(Model model, Map extend) {
                extend.put("test", "test");
                extend.put("extend", "extend");

            }
        });

        modelHandlerManager.registerHandler(new ServiceExtendHandler());
        generator.setModelHandlerManager(modelHandlerManager);
        generator.generator(cfg);

    }
}