package com.github.superproxy.code.generator;

import com.github.superproxy.code.generator.core.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.modelgen.*;
import com.github.superproxy.code.generator.support.domain.bean.Domain;
import com.github.superproxy.code.generator.support.domain.extend.java.service.ServiceExtendHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

public class DomainTemplateGeneratorTest {
    @Test
    public void testGenerator() throws Exception {

        ModelTemplateGenerator generator = new ModelTemplateGenerator();
        ModelGeneratorConfig cfg = new ModelGeneratorConfig();
        cfg.setTemplateEngine(new FreeMarkerTplEngine());
        cfg.setOutPath("d:/env/test-model.java");
        cfg.setTplsRoot(new File("src/test/resources").getAbsolutePath());
        cfg.setTplPath("test-model.ftl");
        cfg.setModel(new Domain());

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

        modelAndModelMapHandlerManager.registerModelMapHandler(new ServiceExtendHandler());
        generator.setModelAndModelMapHandlerManager(modelAndModelMapHandlerManager);
        generator.generator(cfg);

    }
}