package com.suning.dal.generator.core;

import com.suning.dal.generator.core.handler.ExtendHandler;
import com.suning.dal.generator.core.handler.HandlerManager;
import com.suning.dal.generator.core.model.Field;
import com.suning.dal.generator.core.model.Model;
import com.suning.dal.generator.core.model.ModuleConfig;
import com.suning.dal.generator.core.model.db.ColumnInfo;
import com.suning.dal.generator.core.model.db.DbSchema;
import com.suning.dal.generator.core.model.db.TableInfo;
import com.suning.dal.generator.core.model.db2java.JavaBeanConvertStrategy;
import com.suning.dal.generator.core.model.db2java.JavaFieldConvertStrategy;
import com.suning.dal.generator.util.LogUtil;
import com.suning.dal.generator.util.Util;
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
    protected DbSchema dbSchema;
    protected JavaFieldConvertStrategy javaFieldConvertStrategy;
    protected JavaBeanConvertStrategy javaBeanConvertStrategy;

    private HandlerManager handlerManager = new HandlerManager();

    public DbModelTplGenerator(ModuleConfig moduleConfig, DbSchema dbSchema,
                               JavaBeanConvertStrategy javaBeanConvertStrategy, JavaFieldConvertStrategy javaFieldConvertStrategy) {
        super(moduleConfig);
        this.dbSchema = dbSchema;
        this.javaBeanConvertStrategy = javaBeanConvertStrategy;
        this.javaFieldConvertStrategy = javaFieldConvertStrategy;
    }


    public void registerHandler(ExtendHandler handler) {
        handlerManager.registerHandler(handler);
    }

    public void handler(Model model, Map root) {
        handlerManager.handler(model, root);
    }

    @Override
    protected List<Map> getModels() {
        // 多个模型 一个表一个模型
        List<TableInfo> tableInfoList = this.dbSchema.getTableInfoList();
        List<Map> mapList = new ArrayList<Map>();
        for (TableInfo tableInfo : tableInfoList) {
            Map root = getMap(tableInfo);
            mapList.add(root);
        }
        return mapList;
    }

    private Map getMap(TableInfo tableInfo) {
        // Create the root hash
        Map root = new HashMap();
        // 对象信息
        Util.object2Map(root, moduleConfig);
        LogUtil.debugInfo(root);

        //
        Model model = convert(tableInfo);
        handlerManager.handler(model, root);

        root.put("model", model);
        return root;
    }

    /**
     * table和java的基础信息模型
     *
     * @param tableInfo
     * @return
     */
    private Model convert(TableInfo tableInfo) {
        Model model = new Model(javaBeanConvertStrategy);
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
}
