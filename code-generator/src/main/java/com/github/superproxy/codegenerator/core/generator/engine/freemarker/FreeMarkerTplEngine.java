package com.github.superproxy.codegenerator.core.generator.engine.freemarker;

import com.github.superproxy.codegenerator.core.generator.engine.TplModel;
import com.github.superproxy.codegenerator.core.generator.engine.TemplateEngine;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Map;

public final class FreeMarkerTplEngine implements TemplateEngine {
    /**
     * 获取模版引擎config
     *
     * @param templateRoot
     * @return
     * @throws java.io.IOException
     */
    private Configuration getConfiguration(String templateRoot) throws IOException {
        Configuration cfg = new Configuration();
        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(new File(templateRoot));
        cfg.setTemplateLoader(fileTemplateLoader);
//        cfg.setDirectoryForTemplateLoading(new File(templateRoot));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }

    @Override
    public void process(TplModel tplModel) {
        String tplRoot = tplModel.getTplsRoot();
        String tplPath = tplModel.getTplPath();
        String outPath = tplModel.getOutPath();
        Map model = tplModel.getModelMap();
        // 通过freemarker进行解析生成
        try {
//            for (Map model : modelList) {
            Configuration cfg = getConfiguration(tplRoot);
            Template template = cfg.getTemplate(tplPath); //  相对路径
            File file = new File(outPath);
            file.delete();
            OutputStream os = new FileOutputStream(file);
            Writer out = new OutputStreamWriter(os);
//                Writer out = new OutputStreamWriter(System.out);
            template.process(model, out);
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }

}
