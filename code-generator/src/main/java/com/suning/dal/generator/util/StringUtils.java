package com.suning.dal.generator.util;

public final class StringUtils {
    public static String removeUnderLineUpper(String columnName) {
        boolean needUpper = false;
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columnName.length(); i++) {
            c = columnName.charAt(i);
            if (c == '_') {
                needUpper = true;
                continue;
            } else {
                if (needUpper) {
                    sb.append(Character.toUpperCase(c));
                    needUpper = false;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeUnderLineUpper("aa_abc_c"));
    }

    public static String upperFirst(String s) {
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (i == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean isEmpty(String moduleName) {
        if (moduleName == null || moduleName.trim().isEmpty())
            return true;
        else
            return false;
    }
}
