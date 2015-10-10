package com.github.superproxy.code.generator;

import com.github.superproxy.code.generator.core.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.modelgen.*;
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

        ModelAndModelMapHandlerManager modelAndModelMapHandlerManager = new ModelAndModelMapHandlerManager();
        modelAndModelMapHandlerManager.registerModelMapHandler(new ModelAndModelMapExtendHandler() {
            @Override
            public String handlerId() {
                return "test";
            }

            @Override
            public void extendModelMap(Model model, Map extend) {
                extend.put("test", "test");
                extend.put("extend", "extend");
            }

            @Override
            public void extendModel(Model model) {

            }
        });

        generator.setModelAndModelMapHandlerManager(modelAndModelMapHandlerManager);
        generator.generator(cfg);

    }
}