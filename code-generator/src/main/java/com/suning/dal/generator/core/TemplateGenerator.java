package com.suning.dal.generator.core;

import com.suning.dal.generator.core.model.Model;
import com.suning.dal.generator.core.model.ModuleConfig;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 基于模版机制的代码生成器
 */
public abstract class TemplateGenerator implements Generator {
    protected ModuleConfig moduleConfig;

    public TemplateGenerator(ModuleConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    /**
     * 获取模版引擎config
     *
     * @param templateRoot
     * @return
     * @throws IOException
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
    public void generator() {
        // 通过freemarker进行解析生成
        try {
            List<Map> modelList = getModels();
            for (Map model : modelList) {
                Configuration cfg = getConfiguration(moduleConfig.getTplsPath());
//            System.out.println(new File(".").toString());
                String templatePath = getTemplatePath();
//            System.out.println(new File(templateRoot + File.separator + templatePath).toString());
                Template template = cfg.getTemplate(templatePath); //  相对路径

                File file = new File(getOutPath((Model) model.get("model")));
                file.delete();
                OutputStream os = new FileOutputStream(file);
                Writer out = new OutputStreamWriter(os);
//                Writer out = new OutputStreamWriter(System.out);
                template.process(model, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 模版路径
     *
     * @return
     */
    protected abstract String getTemplatePath();

    /**
     * 输出路径
     *
     * @param model
     * @return
     */
    protected abstract String getOutPath(Model model);


    /**
     * 获取模型
     *
     * @return
     */
    protected abstract List<Map> getModels();
}
