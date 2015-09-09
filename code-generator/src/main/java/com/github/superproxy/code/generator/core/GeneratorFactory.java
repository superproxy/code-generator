package com.github.superproxy.code.generator.core;

import java.util.HashMap;
import java.util.Map;

public class GeneratorFactory {

    private static Map<String, Generator> generatorMap = new HashMap<String, Generator>();

    public static  void registerGenerator(Generator generator) {
        generatorMap.put(generator.getId(), generator);
    }

    public static Generator getGenerator(String type) {
        return generatorMap.get(type);
    }

}
