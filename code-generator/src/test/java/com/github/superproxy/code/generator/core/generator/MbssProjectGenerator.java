package com.github.superproxy.code.generator.core.generator;

import com.github.superproxy.code.generator.ProjectGenerator;
import com.github.superproxy.code.generator.config.*;
import com.github.superproxy.code.generator.support.model.rules.contoller.ControllerTpl;
import com.github.superproxy.code.generator.support.model.rules.dao.DaoImplTpl;
import com.github.superproxy.code.generator.support.model.rules.dao.DaoMapperTpl;
import com.github.superproxy.code.generator.support.model.rules.dao.DaoTpl;
import com.github.superproxy.code.generator.support.model.rules.model.ModelTpl;
import com.github.superproxy.code.generator.support.model.rules.service.ServiceImplTpl;
import com.github.superproxy.code.generator.support.model.rules.service.ServiceTpl;
import com.github.superproxy.code.generator.support.model.rules.sqlmap.SqlMapTpl;
import com.github.superproxy.code.generator.tpl.CommonTpl;
import org.testng.annotations.Test;

import java.io.File;

public class MbssProjectGenerator extends ProjectGenerator {
    boolean useLocalDb = false;

    /**
     * save config
     *
     * @throws Exception
     */
    @Test
    public void testWrite() throws Exception {
        ProjectUtil.write(buildProjectConfig(), "src/test/resources/mbss.yml");
    }

    /**
     * read the config from mbss.yml
     *
     * @throws Exception
     */
    @Test(dependsOnMethods = "testWrite")
    public void testGenFromFile() throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read("src/test/resources/mbss.yml");
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        process(projectConfig);
    }


    @Test
    public void testGen() throws Exception {
        ProjectConfig projectConfig = buildProjectConfig();
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        process(projectConfig);

    }

    public ProjectConfig buildProjectConfig() {
        ProjectConfig projectConfig = new ProjectConfig();
        projectConfig.setAuthor("14120295");
        projectConfig.setDate("2014-12-30");
        projectConfig.setOutPath("d:/env");
        projectConfig.setTplRoot(new File("src/main/resources/templates/snf").getAbsolutePath());

        if (useLocalDb) {
            projectConfig.setDbConfig(buildH2DbConfig());

        } else {
            projectConfig.setDbConfig(buildMysqlDbConfig());
        }
        projectConfig.addModule(buildAccountModuleConfig());
        projectConfig.addModule(buildVideoModuleConfig());
        return projectConfig;
    }

    private DbConfig buildH2DbConfig() {
        DbConfig dbConfig = new DbConfig();
        dbConfig.setDriverClass("org.h2.Driver");
        dbConfig.setUrl("jdbc:h2:~/code-generator.db");
        dbConfig.setUserName("admin");
        dbConfig.setPassword("123456");
        return dbConfig;
    }

    private DbConfig buildMysqlDbConfig() {
        DbConfig dbConfig = new DbConfig();
        dbConfig.setDriverClass("com.mysql.jdbc.Driver");
        dbConfig.setUrl("jdbc:mysql://10.27.25.97:3306/mbssdb?characterEncoding=utf8");
        dbConfig.setUserName("root");
        dbConfig.setPassword("sn123456");
        return dbConfig;
    }

    private ModuleConfig buildAccountModuleConfig() {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setTableName("mbss_account");
        moduleConfig.setModuleName("account");
        moduleConfig.setTablePrefix("mbss");
        // 依赖
        registerPart(moduleConfig);
        return moduleConfig;
    }

    private ModuleConfig buildVideoModuleConfig() {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setTableName("mbss_video");
        moduleConfig.setModuleName("video");
        moduleConfig.setTablePrefix("mbss");

        registerPart(moduleConfig);

        return moduleConfig;
    }

    private void registerPart(ModuleConfig moduleConfig) {
        moduleConfig.addModulePartConfig(new ModulePartConfig(new ModelTpl(), "com.sunning.mbss.model", "Mapper"));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(new CommonTpl("test", "model.ftl", "test.java"), "com.sunning.mbss.model", "Mapper"));
        moduleConfig.addModulePartConfig(new ModulePartConfig(new SqlMapTpl(), "", ""));
        moduleConfig.addModulePartConfig(new ModulePartConfig(new DaoTpl(), "com.sunning.mbss.dao", "Dao"));
        moduleConfig.addModulePartConfig(new ModulePartConfig(new DaoImplTpl(), "com.sunning.mbss.dao.impl", "DaoImpl"));
        moduleConfig.addModulePartConfig(new ModulePartConfig(new DaoMapperTpl(), "com.sunning.mbss.dao", "Mapper"));
        moduleConfig.addModulePartConfig(new ModulePartConfig(new ServiceTpl(), "com.sunning.mbss.inf", "Service"));
        moduleConfig.addModulePartConfig(new ModulePartConfig(new ServiceImplTpl(), "com.sunning.mbss.impl", "ServiceImpl"));
        moduleConfig.addModulePartConfig(new ModulePartConfig(new ControllerTpl(), "com.sunning.mbss.controller", "Controller"));
    }


}
