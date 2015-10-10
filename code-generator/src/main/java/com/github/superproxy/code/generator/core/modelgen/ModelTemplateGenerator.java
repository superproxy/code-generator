package com.github.superproxy.code.generator.core.modelgen;

import com.github.superproxy.code.generator.core.engine.CommonTplModel;
import com.github.superproxy.code.generator.core.engine.TplConfig;
import com.github.superproxy.code.generator.core.tplgen.AbstractTemplateGenerator;

import java.util.Map;

/**
 * 基于模型扩展的模型生成器
 */
public class ModelTemplateGenerator extends AbstractTemplateGenerator {
    private ModelAndModelMapHandlerManager modelAndModelMapHandlerManager;

    public ModelTemplateGenerator() {
    }

    @Override
    public void generator(Object o) {
        if (o instanceof ModelGeneratorConfig) {
            ModelGeneratorConfig modelGeneratorContext = (ModelGeneratorConfig) o;
            generator(modelGeneratorContext);
        }
    }


    public void generator(ModelGeneratorConfig modelGeneratorConfig) {
        CommonTplModel tplModel = new CommonTplModel();
        Map map = modelAndModelMapHandlerManager.extendMap(modelGeneratorConfig.getModel());
        tplModel.setModelMap(map);
        tplModel.setOutPath(modelGeneratorConfig.getOutPath());
        tplModel.setTplPath(modelGeneratorConfig.getTplPath());
        tplModel.setTplsRoot(modelGeneratorConfig.getTplsRoot());

        TplConfig tplConfig = new TplConfig();
        tplConfig.setTplModel(tplModel);
        tplConfig.setTemplateEngine(modelGeneratorConfig.getTemplateEngine());
        super.generator(tplConfig);
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }

    @Override
    public String getDesciprtion() {
        return "模型生成器";
    }

    public void setModelAndModelMapHandlerManager(ModelAndModelMapHandlerManager modelAndModelMapHandlerManager) {
        this.modelAndModelMapHandlerManager = modelAndModelMapHandlerManager;
    }
}
