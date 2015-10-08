package com.github.superproxy.code.generator.core.generator;

import com.github.superproxy.code.generator.core.generator.engine.TplConfig;
import com.github.superproxy.code.generator.core.generator.engine.TplModel;
import com.github.superproxy.code.generator.core.generator.engine.freemarker.FreeMarkerTplEngine;
import com.github.superproxy.code.generator.core.generator.tplgen.AbstractTemplateGenerator;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TemplateGeneratorTest {

    @Test
    public void testGenerator() throws Exception {

        AbstractTemplateGenerator generator = new AbstractTemplateGenerator() {
            @Override
            public String getId() {
                return "test";
            }

            @Override
            public String getDesciprtion() {
                return "test";
            }
        };

        TplConfig config = new TplConfig();
        config.setTemplateEngine(new FreeMarkerTplEngine());
        config.setTplModel(getTplModel());

        generator.generator(config);
    }

    private TplModel getTplModel() {
        return new TplModel() {
            @Override
            public String getTplPath() {
                return "test.ftl";
            }

            @Override
            public String getTplsRoot() {
                return new File("src\\test\\resources").getAbsolutePath();
            }

            @Override
            public String getOutPath() {
                return "d:/env/test.java";
            }

            @Override
            public Map getModelMap() {
                Map map = new HashMap();
                map.put("test", "abc");
                return map;
            }
        };
    }
}