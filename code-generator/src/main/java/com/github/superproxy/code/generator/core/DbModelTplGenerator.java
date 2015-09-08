package com.github.superproxy.code.generator.core;

import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.handler.ModelHandlerManager;
import com.github.superproxy.code.generator.core.model.Field;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.core.model.Model;
import com.github.superproxy.code.generator.core.model.ModuleConfig;
import com.github.superproxy.code.generator.core.model.db.ColumnInfo;
import com.github.superproxy.code.generator.core.model.db.DbSchema;
import com.github.superproxy.code.generator.core.model.db.TableInfo;
import com.github.superproxy.code.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.github.superproxy.code.generator.core.model.db2java.JavaFieldConvertStrategy;
import com.github.superproxy.code.generator.util.LogUtil;
import com.github.superproxy.code.generator.util.Util;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于DB模型的模版代码生成器
 */
public abstract class DbModelTplGenerator extends TemplateGenerator {

    protected String templatePath;

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    protected DbSchema dbSchema;
    protected JavaFieldConvertStrategy javaFieldConvertStrategy;
    protected JavaBeanConvertStrategy javaBeanConvertStrategy;
    protected ModuleConfig moduleConfig;

    private ModelHandlerManager modelHandlerManager = new ModelHandlerManager();

    public DbModelTplGenerator() {

    }

    public DbModelTplGenerator(GeneratorContext generatorContext) {
        this.templateEngine = generatorContext.getTemplateEngine();
        this.moduleConfig = generatorContext.getModuleConfig();
        this.dbSchema = generatorContext.getDbSchema();
        this.javaBeanConvertStrategy = generatorContext.getJavaBeanConvertStrategy();
        this.javaFieldConvertStrategy = generatorContext.getJavaFieldConvertStrategy();
    }


    public DbSchema getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(DbSchema dbSchema) {
        this.dbSchema = dbSchema;
    }

    public JavaBeanConvertStrategy getJavaBeanConvertStrategy() {
        return javaBeanConvertStrategy;
    }

    public void setJavaBeanConvertStrategy(JavaBeanConvertStrategy javaBeanConvertStrategy) {
        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
    }

    public JavaFieldConvertStrategy getJavaFieldConvertStrategy() {
        return javaFieldConvertStrategy;
    }

    public void setJavaFieldConvertStrategy(JavaFieldConvertStrategy javaFieldConvertStrategy) {
        this.javaFieldConvertStrategy = javaFieldConvertStrategy;
    }

    public ModelHandlerManager getModelHandlerManager() {
        return modelHandlerManager;
    }

    public void setModelHandlerManager(ModelHandlerManager modelHandlerManager) {
        this.modelHandlerManager = modelHandlerManager;
    }

    @Override
    public ModuleConfig getModuleConfig() {
        return moduleConfig;
    }

    @Override
    public void setModuleConfig(ModuleConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    public void registerHandler(ModelExtendHandler handler) {
        modelHandlerManager.registerHandler(handler);
    }

    public void handler(Model model, Map root) {
        modelHandlerManager.handler(model, root);
    }

    protected List<Map> getMaps() {
        // 多个模型 一个表一个模型
        List<TableInfo> tableInfoList = this.dbSchema.getTableInfoList();
        List<Map> mapList = new ArrayList<Map>();
        for (TableInfo tableInfo : tableInfoList) {

            Model model = convert(tableInfo, moduleConfig);
            setModel(model);
            Map root = process(model);
            mapList.add(root);
        }
        return mapList;
    }

    protected Map getMap() {
        return getMaps().get(0);
    }

    private Map process(Model model) {
        // Create the root hash
        Map root = new HashMap();
        // 对象信息
        Util.object2Map(root, moduleConfig);
        modelHandlerManager.handler(model, root);
        LogUtil.debugInfo(root);
        root.put("model", model);
        return root;
    }

    protected Model model;

    protected void setModel(Model model) {
        this.model = model;
    }

    protected Model getModel() {
        return this.model;
    }

    /**
     * table和java的基础信息模型
     *
     * @param tableInfo
     * @return
     */
    private Model convert(TableInfo tableInfo, ModuleConfig moduleConfig) {
        Model model = new Model(javaBeanConvertStrategy, moduleConfig);
        try {

            // 基础表信息
            BeanUtils.copyProperties(model, tableInfo);

            // 主键
            model.setPkColumnList(tableInfo.getPkColumnList());
            List<Field> pkFieldList = new ArrayList<Field>();
            for (ColumnInfo c : model.getPkColumnList()) {

                Field field = new Field(javaFieldConvertStrategy);
                BeanUtils.copyProperties(field, c);
                pkFieldList.add(field);
            }
            model.setPkFieldList(pkFieldList);


            //  非主键
            model.setColumnInfoList(tableInfo.getColumnInfoList());
            List<Field> fieldList = new ArrayList<Field>();
            for (ColumnInfo c : model.getColumnInfoList()) {

                Field field = new Field(javaFieldConvertStrategy);
                BeanUtils.copyProperties(field, c);
                fieldList.add(field);
            }
            model.setFieldList(fieldList);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return model;

    }

    protected abstract String getTemplatePath();

    protected abstract String getOutPath();

    @Override
    public TplInfo getTplInfo() {
        TplInfoImpl tplInfo = new TplInfoImpl();
        //
        Map map = getMap();
        tplInfo.setModel(map);

        tplInfo.setTplRoot(moduleConfig.getTplsPath());

        tplInfo.setOutPath(getOutPath());
        tplInfo.setTplPath(getTemplatePath());

        return tplInfo;
    }
}
