package com.github.superproxy.code.generator;

import com.github.superproxy.code.generator.config.ProjectConfig;
import com.github.superproxy.code.generator.config.ConfigYamlUtils;

public class App {

    public void main(String[] args) throws Exception {
        new App().gen(args[0]);
    }

    private void gen(String path) throws Exception {
        ProjectConfig projectConfig = ConfigYamlUtils.read(path);
        new ProjectGenerator(){}.process(projectConfig);
    }

}
