package com.github.superproxy.code.generator.support.model.project;

import com.github.superproxy.code.generator.core.generator.modelgen.Model;
import com.github.superproxy.code.generator.core.generator.modelgen.ModelMapExtendHandler;
import com.github.superproxy.code.generator.support.model.CommonModel;
import com.github.superproxy.code.generator.support.model.DbJavaModelConfig;

import java.util.Map;

public class ProjectModelAndModelMapExtendHandler implements ModelMapExtendHandler {

    @Override
    public String handlerId() {
        return "project";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        DbJavaModelConfig cfg = ((CommonModel) model).getDbJavaModelConfig();
        extend.put("author", cfg.getAuthor());
        extend.put("date", cfg.getDate());
        extend.put("moduleName", cfg.getModuleName());
    }
}
