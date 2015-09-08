package com.github.superproxy.code.generator.core;

/**
 * 生成器
 */
public interface Generator<T> {
    //    void generator(T object);
    void generator();

    String getType();
}
