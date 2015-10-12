package com.github.superproxy.code.generator.config;

import com.github.superproxy.code.generator.support.domain.bean.ComposeModel;
import org.ho.yaml.Yaml;

import java.io.File;

public final class ConfigYamlUtils {
    public static ProjectConfig read(String path) throws Exception {
        return (ProjectConfig) Yaml.load(new File(path));
    }

    public static void write(ProjectConfig projectConfig, String outPath) throws Exception {
        Yaml.dump(projectConfig, new File(outPath));
    }

    public static ComposeModel readDoamin(String path) throws Exception {
        return (ComposeModel) Yaml.load(new File(path));
    }

    public static void writeDomain(ComposeModel domain, String outPath) throws Exception {
        Yaml.dump(domain, new File(outPath));
    }
}
