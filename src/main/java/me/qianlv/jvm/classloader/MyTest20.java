package me.qianlv.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author tinytree
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16(null, "loader1");
        MyTest16 loader2 = new MyTest16(null, "loader2");
        loader1.setPath("/Users/xiaoshu/Desktop/");
        loader2.setPath("/Users/xiaoshu/Desktop/");

        Class<?> clazz1 = loader1.loadClass("me.qianlv.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("me.qianlv.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method setMyPerson = clazz1.getMethod("setMyPerson", Object.class);
        System.out.println(setMyPerson.invoke(object1, object2));
    }
}
