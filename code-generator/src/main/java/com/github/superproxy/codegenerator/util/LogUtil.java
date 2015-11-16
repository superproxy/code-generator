package com.github.superproxy.codegenerator.util;

import java.util.Map;
import java.util.Set;

public final class LogUtil {

//    public  static Logger

    public static void debugInfo(Map root) {
        Set entrySet = root.keySet();
        for (Object o : entrySet) {
            Object value = root.get(o);
            System.out.println(o.toString() + ":" + value);
        }
    }
}
