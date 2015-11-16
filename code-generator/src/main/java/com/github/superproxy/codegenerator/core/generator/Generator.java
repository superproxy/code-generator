package com.github.superproxy.codegenerator.core.generator;

public interface Generator<T> {
    void generator(T t);

    String getId();
    String getDesciprtion();
}
