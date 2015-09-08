import com.github.superproxy.code.generator.app.MConfig;
import com.github.superproxy.code.generator.app.ModulePartConfig;
import com.github.superproxy.code.generator.app.ProjectConfig;
import com.github.superproxy.code.generator.app.ProjectUtil;
import com.github.superproxy.code.generator.core.FreeMarkerTemplateEngine;
import com.github.superproxy.code.generator.core.Generator;
import com.github.superproxy.code.generator.core.model.GeneratorContext;
import com.github.superproxy.code.generator.core.model.ModuleConfig;
import com.github.superproxy.code.generator.core.model.db.DbSchema;
import com.github.superproxy.code.generator.core.model.db.DbSchemaFactory;
import com.github.superproxy.code.generator.core.model.db.DbSchemaFactoryImpl;
import com.github.superproxy.code.generator.core.model.db2java.impl.JavaBeanConvertStrategyImpl;
import com.github.superproxy.code.generator.core.model.db2java.impl.JavaFieldStrategyImpl;
import com.github.superproxy.code.generator.plugins.dao.DaoImplTplGenerator;
import com.github.superproxy.code.generator.plugins.dao.DaoMapperTplGenerator;
import com.github.superproxy.code.generator.plugins.dao.DaoTplGenerator;
import com.github.superproxy.code.generator.plugins.model.ModelTplGenerator;
import com.github.superproxy.code.generator.plugins.service.ServiceImplTplGenerator;
import com.github.superproxy.code.generator.plugins.service.ServiceTplGenerator;
import com.github.superproxy.code.generator.plugins.sqlmap.SqlMapTplGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.File;
import java.lang.reflect.Constructor;

public class MbssGenerator {
    public ProjectConfig buildProjectCofig() {
        ProjectConfig projectConfig = new ProjectConfig();
        projectConfig.setAuthor("14120295");
        projectConfig.setDate("2014-12-30");
        projectConfig.setOutPath("d:/env");
        projectConfig.setTplsPath(new File("src\\main\\resources\\templates\\snf").getAbsolutePath());
        MConfig mConfig = new MConfig();
        mConfig.setTableName("mbss_account");
        mConfig.setModuleName("account");
        mConfig.setTablePrefix("mbss");


        mConfig.addLayerConfig(new ModulePartConfig(ModelTplGenerator.class.getName(), "com.sunning.mbss.model", "Mapper"));
        mConfig.addLayerConfig(new ModulePartConfig(SqlMapTplGenerator.class.getName(), "", ""));
        mConfig.addLayerConfig(new ModulePartConfig(DaoTplGenerator.class.getName(), "com.sunning.mbss.dao", "Dao"));
        mConfig.addLayerConfig(new ModulePartConfig(DaoImplTplGenerator.class.getName(), "com.sunning.mbss.dao.impl", "DaoImpl"));
        mConfig.addLayerConfig(new ModulePartConfig(DaoMapperTplGenerator.class.getName(), "com.sunning.mbss.dao", "Mapper"));
        mConfig.addLayerConfig(new ModulePartConfig(ServiceTplGenerator.class.getName(), "com.sunning.mbss.inf", "Service"));
        mConfig.addLayerConfig(new ModulePartConfig(ServiceImplTplGenerator.class.getName(), "com.sunning.mbss.impl", "ServiceImpl"));
        projectConfig.addModule(mConfig);
        return projectConfig;
    }

    @Test
    public void testWrite() throws Exception {
        ProjectUtil.write(buildProjectCofig(), "d:/env/mbss.yaml");
    }

    @Test
    public void testRead() throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read("E:\\projects\\code-generator\\code-generator\\src\\test\\resources\\project.yaml");
        System.out.println(projectConfig);
    }

    @Test
    public void testRead2() throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read("E:\\projects\\code-generator\\code-generator\\src\\test\\resources\\mbss.yaml");
        System.out.println(projectConfig);
    }

    @Test
    public void gen() throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read(new File("src/test/resources/").getAbsolutePath() + File.separator + "mbss.yaml");
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        process(projectConfig);
    }

    @Test
    public void gen2() throws Exception {
        ProjectConfig projectConfig = buildProjectCofig();
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        process(projectConfig);

    }

    private void process(ProjectConfig projectConfig) throws Exception {
        for (MConfig mConfig : projectConfig.getModules()) {
            for (ModulePartConfig partConfig : mConfig.getLayerConfig()) {
                ModuleConfig moduleConfig = covert2ModuleConfig(projectConfig, mConfig, partConfig);
                DbSchema dbSchema = getDbSchema(moduleConfig.getTableName());

                GeneratorContext generatorContext = getGeneratorContext(moduleConfig, dbSchema);
//                GeneratorFactory.registerGenerator(new ModelTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new SqlMapTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new DaoTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new DaoImplTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new DaoMapperTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new ServiceTplGenerator(generatorContext));
//                GeneratorFactory.registerGenerator(new ServiceImplTplGenerator(generatorContext));
                Constructor<?> constructor = Class.forName(partConfig.getGenerator()).getConstructor(GeneratorContext.class);
                Generator generator = (Generator) constructor.newInstance(generatorContext);
                generator.generator();
            }
        }
    }

    private ModuleConfig covert2ModuleConfig(ProjectConfig projectConfig, MConfig mConfig, ModulePartConfig partConfig) {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setAuthor(projectConfig.getAuthor());
        moduleConfig.setDate(projectConfig.getDate());
        moduleConfig.setOutPath(projectConfig.getOutPath());
        moduleConfig.setTplsPath(projectConfig.getTplsPath());
        moduleConfig.setTableName(mConfig.getTableName());
        moduleConfig.setModuleName(mConfig.getModuleName());
        moduleConfig.setClassPostfix(partConfig.getClassPostfix());
        moduleConfig.setPackageName(partConfig.getPackageName());
        return moduleConfig;
    }


    private DbSchema getDbSchema(String tableName) throws Exception {
        DataSource dataSource = getDataSource();
        DbSchemaFactory dbSchemaFactory = new DbSchemaFactoryImpl(dataSource);
        // 所有表
//        DbSchema dbSchema = dbSchemaFactory.genDbSchema(null);
        return dbSchemaFactory.genDbSchema(new String[]{tableName});
    }

    private GeneratorContext getGeneratorContext(ModuleConfig moduleConfig, DbSchema dbSchema) {
        GeneratorContext generatorContext = new GeneratorContext();
        generatorContext.setModuleConfig(moduleConfig);
        generatorContext.setDbSchema(dbSchema);
        generatorContext.setJavaBeanConvertStrategy(new JavaBeanConvertStrategyImpl());
        generatorContext.setJavaFieldConvertStrategy(new JavaFieldStrategyImpl());
        generatorContext.setTemplateEngine(new FreeMarkerTemplateEngine());
        return generatorContext;
    }

    private DataSource getDataSource() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-res.xml");
        return (DataSource) context.getBean("dataSource");
    }

}
