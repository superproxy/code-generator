package com.github.superproxy.code.generator.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

public final class Util {

    /**
     * 把对象的属性存储在map中
     *
     * @param root
     * @param object
     */
    public static void object2Map(Map root, Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                root.put(field.getName(), BeanUtils.getProperty(object, field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

}
