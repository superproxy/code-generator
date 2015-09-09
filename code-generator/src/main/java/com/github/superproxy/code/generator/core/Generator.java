package com.github.superproxy.code.generator.core;

public interface Generator<T> {
    void generator(T t);

    String getId();

    String getDesciprtion();
}
