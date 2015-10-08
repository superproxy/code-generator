package com.github.superproxy.code.generator.source.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class InnerField {
    private String name;
    private String diplayName;
    private String type;
    private boolean isPk;
    private boolean isNull;
    private boolean isAutoCreament;

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
