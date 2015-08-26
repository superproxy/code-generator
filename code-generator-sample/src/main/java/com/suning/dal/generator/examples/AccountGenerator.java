package com.suning.dal.generator.examples;

import com.suning.dal.generator.core.model.ModuleConfig;

public class AccountGenerator extends AbstractMbssGenerator {

    public void gen() throws Exception {
        gen(new String[]{"mbss_account"});
    }

    @Override
    public ModuleConfig buildProjectCofig() {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setAuthor("14120295");
        moduleConfig.setDate("2014-12-30");
        moduleConfig.setModuleName("account");
        moduleConfig.setOutPath("d:/env");
        moduleConfig.setTablePrefix("dal");
        return moduleConfig;
    }
}
