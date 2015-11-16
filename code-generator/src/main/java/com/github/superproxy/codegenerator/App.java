package com.github.superproxy.codegenerator;

import com.github.superproxy.codegenerator.config.ProjectConfig;
import com.github.superproxy.codegenerator.config.ConfigYamlUtils;

public class App {

    public void main(String[] args) throws Exception {
        new App().gen(args[0]);
    }

    private void gen(String path) throws Exception {
        ProjectConfig projectConfig = ConfigYamlUtils.read(path);
        new ProjectGenerator(){}.process(projectConfig);
    }

}
