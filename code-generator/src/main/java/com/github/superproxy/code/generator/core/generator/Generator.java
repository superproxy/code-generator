package com.github.superproxy.code.generator.core.generator;

public interface Generator<T> {
    void generator(T t);

    String getId();
    String getDesciprtion();
}
