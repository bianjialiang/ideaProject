package com.atguigu.bookstore.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Administrator
 * @create 2018-09-10 8:56
 **/
public class ReflectionUtils {

    public static Class getSuperClassGenericType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }

        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class) params[index];
    }

    /*
    通过反射，获得class定义声明中的父类的泛型参数
     */

    public static <T> Class<T> getSuperGenricType(Class clazz) {
        return getSuperClassGenericType(clazz, 0);
    }

    /*
    循环向上转型，获取对象的DeclaredMethod
     */

}
