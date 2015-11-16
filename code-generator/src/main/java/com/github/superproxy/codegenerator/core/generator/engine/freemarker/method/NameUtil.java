package com.github.superproxy.codegenerator.core.generator.engine.freemarker.method;

public class NameUtil {
    public static String getCamelStyleName(String s) {
        String name = String.valueOf(s.charAt(0)).toLowerCase() + s.substring(1);
        return name;
    }

    public static String getSetName(String s) {
        String name = getCamelStyleName(s);
        char c = name.charAt(name.length() - 1);
        if (name.endsWith("s") || name.endsWith("sh") || name.endsWith("ch") || name.endsWith("x")) {
            return name + "es";
        }
        if (name.endsWith("y")) {
            if (name.endsWith("ay") || name.endsWith("ey") || name.endsWith("iy") || name.endsWith("oy")
                    || name.endsWith("uy")) {
                return name.substring(0, name.length() - 1) + "ies";
            } else {
                return name + "s";
            }
        }
        // if(name.endsWith("o"))
        // {
        //            
        // }

        return name + "s";
    }

    public static String getUnderLineName(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                sb.append("_");
                sb.append(s.charAt(i));
            } else {
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            }
        }
        return sb.toString();
    }

    public static String getPascalStyleName(String s) {
        String name = String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
        return name;
    }

    public static String getLowerCase(String s) {
        return s.toLowerCase();
    }
}
