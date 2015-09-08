package com.github.superproxy.code.generator.app;

import org.ho.yaml.Yaml;

import java.io.File;

public final class ProjectUtil {
    public static ProjectConfig read(String path) throws Exception {
        return (ProjectConfig) Yaml.load(new File(path));
    }

    public static void write(ProjectConfig projectConfig, String outPath) throws Exception {
        Yaml.dump(projectConfig, new File(outPath));
    }
}
