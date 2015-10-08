package com.github.superproxy.code.generator.core.generator;

import com.github.superproxy.code.generator.core.generator.engine.TplModel;
import com.github.superproxy.code.generator.core.generator.tplgen.AbstractTemplateGenerator;

import java.util.Map;

public class ExcelTplGeneratorAbstract extends AbstractTemplateGenerator {
    @Override
    public void generator(Object o) {
        TplModel tplModel = buildTplModel();
        super.generator(tplModel);
    }

    private TplModel buildTplModel() {
        return new TplModel() {
            @Override
            public String getTplPath() {
                return null;
            }

            @Override
            public String getTplsRoot() {
                return null;
            }

            @Override
            public String getOutPath() {
                return null;
            }

            @Override
            public Map getModelMap() {
                return null;
            }
        };
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

    @Override
    public String getDesciprtion() {
        return "Excel ";
    }
}
