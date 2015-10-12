package com.github.superproxy.code.generator.support.domain.extend.project;

import com.github.superproxy.code.generator.core.modelgen.Model;
import com.github.superproxy.code.generator.core.modelgen.ModelMapExtendHandler;
import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
import com.github.superproxy.code.generator.support.domain.bean.DomainConfig;

import java.util.Map;

public class ProjectModelMapExtendHandler implements ModelMapExtendHandler {

    @Override
    public String handlerId() {
        return "project";
    }

    @Override
    public void extendModelMap(Model model, Map extend) {
        DomainConfig cfg = ((ComposeModel) model).getDomainConfig();
        extend.put("author", cfg.getAuthor());
        extend.put("date", cfg.getDate());
        extend.put("moduleName", cfg.getModuleName());
    }
}
