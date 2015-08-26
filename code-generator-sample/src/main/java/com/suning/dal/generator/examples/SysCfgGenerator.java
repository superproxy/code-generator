package com.suning.dal.generator.examples;

import com.suning.dal.generator.core.model.ModuleConfig;

public class SysCfgGenerator extends AbstractMbssGenerator {

    public void gen() throws Exception {
        gen(new String[]{"mbss_sys_config"});
    }

    public static  void main(String[] args) throws Exception {
        new SysCfgGenerator().gen();
    }

    @Override
    public ModuleConfig buildProjectCofig() {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setAuthor("14120295");
        moduleConfig.setDate("2014-12-30");
        moduleConfig.setModuleName("sys");
        moduleConfig.setOutPath("d:/env");
        moduleConfig.setTablePrefix("dal");
        return moduleConfig;
    }
}
