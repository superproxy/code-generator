package com.github.superproxy.code.generator.config;

//import com.github.superproxy.code.generator.plugins.contoller.ControllerTplGenerator;
//import com.github.superproxy.code.generator.plugins.dao.DaoImplTplGenerator;
//import com.github.superproxy.code.generator.plugins.dao.DaoMapperTplGenerator;
//import com.github.superproxy.code.generator.plugins.dao.DaoTplGenerator;
//import com.github.superproxy.code.generator.plugins.model.ModelTplGenerator;
//import com.github.superproxy.code.generator.plugins.service.ServiceImplTplGenerator;
//import com.github.superproxy.code.generator.plugins.service.ServiceTplGenerator;
//import com.github.superproxy.code.generator.plugins.sqlmap.SqlMapTplGenerator;
import com.github.superproxy.code.generator.ProjectGenerator;
import org.testng.annotations.Test;

import java.io.File;

public class MbssGenerator {
    boolean useLocalDb = false;

    @Test
    public void testWrite() throws Exception {
        ProjectUtil.write(buildProjectCofig(), "src\\test\\resources\\mbss.yml");
    }

    @Test(dependsOnMethods = "testWrite")
    public void testGenFromFile() throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read("src\\test\\resources\\mbss.yml");
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        new ProjectGenerator().process(projectConfig);
    }

    @Test
    public void testGen() throws Exception {
        ProjectConfig projectConfig = buildProjectCofig();
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        new ProjectGenerator().process(projectConfig);

    }

    public ProjectConfig buildProjectCofig() {
        ProjectConfig projectConfig = new ProjectConfig();
        projectConfig.setAuthor("14120295");
        projectConfig.setDate("2014-12-30");
        projectConfig.setOutPath("d:/env");
        projectConfig.setTplRoot(new File("src\\main\\resources\\templates\\snf").getAbsolutePath());

        if (useLocalDb) {
            projectConfig.setDbConfig(buildH2DbConfig());

        } else {
            projectConfig.setDbConfig(buildMysqlDbConfig());
        }
        projectConfig.addModule(getModuleConfig());
        projectConfig.addModule(getModuleConfig2());
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

    private ModuleConfig getModuleConfig() {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setTableName("mbss_account");
        moduleConfig.setModuleName("account");
        moduleConfig.setTablePrefix("mbss");

        registerPart(moduleConfig);
        return moduleConfig;
    }

    private ModuleConfig getModuleConfig2() {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setTableName("mbss_video");
        moduleConfig.setModuleName("video");
        moduleConfig.setTablePrefix("mbss");

        registerPart(moduleConfig);

        return moduleConfig;
    }

    private void registerPart(ModuleConfig moduleConfig) {
//        moduleConfig.addModulePartConfig(new ModulePartConfig(ModelTplGenerator.class.getName(), "com.sunning.mbss.model", "Mapper"));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(SqlMapTplGenerator.class.getName(), "", ""));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(DaoTplGenerator.class.getName(), "com.sunning.mbss.dao", "Dao", "Dao.ftl"));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(DaoImplTplGenerator.class.getName(), "com.sunning.mbss.dao.impl", "DaoImpl"));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(DaoMapperTplGenerator.class.getName(), "com.sunning.mbss.dao", "Mapper"));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(ServiceTplGenerator.class.getName(), "com.sunning.mbss.inf", "Service"));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(ServiceImplTplGenerator.class.getName(), "com.sunning.mbss.impl", "ServiceImpl"));
//        moduleConfig.addModulePartConfig(new ModulePartConfig(ControllerTplGenerator.class.getName(), "com.sunning.mbss.controller", "Controller"));
    }


}
