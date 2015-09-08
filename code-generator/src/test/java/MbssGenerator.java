import com.github.superproxy.code.generator.app.*;
import com.github.superproxy.code.generator.plugins.dao.DaoImplTplGenerator;
import com.github.superproxy.code.generator.plugins.dao.DaoMapperTplGenerator;
import com.github.superproxy.code.generator.plugins.dao.DaoTplGenerator;
import com.github.superproxy.code.generator.plugins.model.ModelTplGenerator;
import com.github.superproxy.code.generator.plugins.service.ServiceImplTplGenerator;
import com.github.superproxy.code.generator.plugins.service.ServiceTplGenerator;
import com.github.superproxy.code.generator.plugins.sqlmap.SqlMapTplGenerator;
import org.testng.annotations.Test;

import java.io.File;

public class MbssGenerator {
    public ProjectConfig buildProjectCofig() {
        ProjectConfig projectConfig = new ProjectConfig();
        projectConfig.setAuthor("14120295");
        projectConfig.setDate("2014-12-30");
        projectConfig.setOutPath("d:/env");
        projectConfig.setTplRoot(new File("src\\main\\resources\\templates\\snf").getAbsolutePath());
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setTableName("mbss_account");
        moduleConfig.setModuleName("account");
        moduleConfig.setTablePrefix("mbss");

        moduleConfig.addLayerConfig(new ModulePartConfig(ModelTplGenerator.class.getName(), "com.sunning.mbss.model", "Mapper"));
        moduleConfig.addLayerConfig(new ModulePartConfig(SqlMapTplGenerator.class.getName(), "", ""));
        moduleConfig.addLayerConfig(new ModulePartConfig(DaoTplGenerator.class.getName(), "com.sunning.mbss.dao", "Dao"));
        moduleConfig.addLayerConfig(new ModulePartConfig(DaoImplTplGenerator.class.getName(), "com.sunning.mbss.dao.impl", "DaoImpl"));
        moduleConfig.addLayerConfig(new ModulePartConfig(DaoMapperTplGenerator.class.getName(), "com.sunning.mbss.dao", "Mapper"));
        moduleConfig.addLayerConfig(new ModulePartConfig(ServiceTplGenerator.class.getName(), "com.sunning.mbss.inf", "Service"));
        moduleConfig.addLayerConfig(new ModulePartConfig(ServiceImplTplGenerator.class.getName(), "com.sunning.mbss.impl", "ServiceImpl"));
        projectConfig.addModule(moduleConfig);
        return projectConfig;
    }

    @Test
    public void testWrite() throws Exception {
        ProjectUtil.write(buildProjectCofig(), "src\\test\\resources\\mbss.yaml");
    }

    @Test(dependsOnMethods = "testWrite")
    public void testRead() throws Exception {
        ProjectConfig projectConfig = ProjectUtil.read("src\\test\\resources\\mbss.yaml");
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        ProjectGenerator.process(projectConfig);
    }

    @Test
    public void gen() throws Exception {
        ProjectConfig projectConfig = buildProjectCofig();
        System.out.println("@@@@@@@@@@@@@@@@@@@" + new File(".").getAbsolutePath());
        ProjectGenerator.process(projectConfig);

    }


}
