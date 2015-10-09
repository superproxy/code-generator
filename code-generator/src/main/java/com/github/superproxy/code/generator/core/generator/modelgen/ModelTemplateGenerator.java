package com.github.superproxy.code.generator.core.generator.modelgen;

import com.github.superproxy.code.generator.core.generator.engine.CommonTplModel;
import com.github.superproxy.code.generator.core.generator.engine.TplConfig;
import com.github.superproxy.code.generator.core.generator.tplgen.AbstractTemplateGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 基于模型扩展的模型生成器
 */
public class ModelTemplateGenerator extends AbstractTemplateGenerator {
    protected ModelHandlerManager modelHandlerManager = new ModelHandlerManager();

    public ModelHandlerManager getModelHandlerManager() {
        return modelHandlerManager;
    }

    public void setModelHandlerManager(ModelHandlerManager modelHandlerManager) {
        this.modelHandlerManager = modelHandlerManager;
    }

    protected Map getExtendMap(Model dbJavaModel) {
        return modelHandlerManager.handler(dbJavaModel);
    }


    public void registerHandler(ModelMapExtendHandler handler) {
        modelHandlerManager.registerHandler(handler);
    }


    public ModelTemplateGenerator() {

    }

    @Override
    public void generator(Object o) {
        if (o instanceof ModelGeneratorConfig) {
            ModelGeneratorConfig modelGeneratorContext = (ModelGeneratorConfig) o;
            generator(modelGeneratorContext);
        }
    }

    public void generator(ModelGeneratorConfig modelGeneratorContext) {
        CommonTplModel tplModel = new CommonTplModel();
        tplModel.setOutPath(modelGeneratorContext.getOutPath());
        tplModel.setTplPath(modelGeneratorContext.getTplPath());
        tplModel.setTplsRoot(modelGeneratorContext.getTplsRoot());
        Map map = getMap(modelGeneratorContext.getModel());
        tplModel.setModelMap(map);
        TplConfig tplConfig = new TplConfig();
        tplConfig.setTplModel(tplModel);
        tplConfig.setTemplateEngine(modelGeneratorContext.getTemplateEngine());
        super.generator(tplConfig);
    }

    private Map getBaseMap(Model dbJavaModel) {
        Map root = new HashMap();
        root.put("model", dbJavaModel);
        return root;
    }

    protected Map getMap(Model dbJavaModel) {
        Map baseMap = getBaseMap(dbJavaModel);
        Map extendMap = getExtendMap(dbJavaModel);
        Map root = new HashMap();
        root.putAll(baseMap);
        root.putAll(extendMap);

        Set<Map.Entry<Object, Object>> set = root.entrySet();
        for (Map.Entry<Object, Object> entry : set) {
            System.out.println("key:" + entry.getKey() + "  value:" + entry.getValue());
        }

        return root;
    }


    @Override
    public String getId() {
        return this.getClass().getName();
    }

    @Override
    public String getDesciprtion() {
        return "模型生成器";
    }
}
