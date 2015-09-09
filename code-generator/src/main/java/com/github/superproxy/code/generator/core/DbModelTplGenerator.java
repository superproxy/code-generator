package com.github.superproxy.code.generator.core;

import com.github.superproxy.code.generator.core.engine.CommonTplInfo;
import com.github.superproxy.code.generator.core.engine.TplInfo;
import com.github.superproxy.code.generator.core.handler.ModelExtendHandler;
import com.github.superproxy.code.generator.core.handler.ModelHandlerManager;
import com.github.superproxy.code.generator.core.model.Field;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.core.model.MConfig;
import com.github.superproxy.code.generator.core.model.Model;
import com.github.superproxy.code.generator.core.model.db.ColumnInfo;
import com.github.superproxy.code.generator.core.model.db.TableInfo;
import com.github.superproxy.code.generator.util.LogUtil;
import com.github.superproxy.code.generator.util.Util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于DB模型的模版代码生成器
 */
public abstract class DbModelTplGenerator extends TemplateGenerator {

    private ModelHandlerManager modelHandlerManager = new ModelHandlerManager();

    public DbModelTplGenerator() {

    }

    @Override
    public void generator(Object o) {
        if (o instanceof GeneratorContext) {
            GeneratorContext generatorContext = (GeneratorContext) o;
            this.templateEngine = generatorContext.getTemplateEngine();
            DbModel dbModel = new DbModel(generatorContext);
            super.generator(buildTplInfo(dbModel));
        }

    }


    public ModelHandlerManager getModelHandlerManager() {
        return modelHandlerManager;
    }

    public void setModelHandlerManager(ModelHandlerManager modelHandlerManager) {
        this.modelHandlerManager = modelHandlerManager;
    }

    public void registerHandler(ModelExtendHandler handler) {
        modelHandlerManager.registerHandler(handler);
    }

    public void handler(MConfig mConfig, Model model, Map root) {
        modelHandlerManager.handler(mConfig, model, root);
    }

    protected List<Map> getMaps(DbModel dbModel) {
        // 多个模型 一个表一个模型
        List<TableInfo> tableInfoList = dbModel.getDbSchema().getTableInfoList();
        List<Map> mapList = new ArrayList<Map>();
        for (TableInfo tableInfo : tableInfoList) {

            Model model = convert(tableInfo, dbModel.getmConfig(), dbModel);
            dbModel.setModel(model);
            Map root = extendModel(model, dbModel);
            mapList.add(root);
        }
        return mapList;
    }

    protected Map getMap(DbModel dbModel) {
        return getMaps(dbModel).get(0);
    }

    private Map extendModel(Model model, DbModel dbModel) {
        // Create the root hash
        Map root = new HashMap();
        // 对象信息
        Util.object2Map(root, dbModel.getmConfig());
        modelHandlerManager.handler(dbModel.getmConfig(), model, root);
        LogUtil.debugInfo(root);
        root.put("model", model);
        return root;
    }

    /**
     * table和java的基础信息模型
     *
     * @param tableInfo
     * @return
     */
    private Model convert(TableInfo tableInfo, MConfig mConfig, DbModel dbModel) {
        Model model = new Model(dbModel.getJavaBeanConvertStrategy(), mConfig);
        try {

            // 基础表信息
            BeanUtils.copyProperties(model, tableInfo);

            // 主键
            model.setPkColumnList(tableInfo.getPkColumnList());
            List<Field> pkFieldList = new ArrayList<Field>();
            for (ColumnInfo c : model.getPkColumnList()) {

                Field field = new Field(dbModel.getJavaFieldConvertStrategy());
                BeanUtils.copyProperties(field, c);
                pkFieldList.add(field);
            }
            model.setPkFieldList(pkFieldList);


            //  非主键
            model.setColumnInfoList(tableInfo.getColumnInfoList());
            List<Field> fieldList = new ArrayList<Field>();
            for (ColumnInfo c : model.getColumnInfoList()) {

                Field field = new Field(dbModel.getJavaFieldConvertStrategy());
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

    protected abstract String getTplPath(DbModel dbModel);

    protected abstract String getOutPath(DbModel dbModel);

    private TplInfo buildTplInfo(DbModel dbModel) {
        CommonTplInfo tplInfo = new CommonTplInfo();
        MConfig mConfig = dbModel.getmConfig();
        Map map = getMap(dbModel);
        tplInfo.setModel(map);
        tplInfo.setTplRoot(mConfig.getTplsRoot());
        tplInfo.setOutPath(getOutPath(dbModel));
        if (StringUtils.isNotEmpty(mConfig.getTplPath())) {
            tplInfo.setTplPath(mConfig.getTplPath());
        } else {
            tplInfo.setTplPath(getTplPath(dbModel));
        }
        return tplInfo;
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

    @Override
    public String getDesciprtion() {
        return null;
    }
}
