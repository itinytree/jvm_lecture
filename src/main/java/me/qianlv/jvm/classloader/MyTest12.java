package me.qianlv.jvm.classloader;

class CL {
    static {
        System.out.println("Class CL");
    }
}

/**
 * 调用ClassLoader类的loadClass方法加载一个类,并不是对类的主动使用,不会导致类的初始化
 *
 * @author xiaoshu
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // 不会导致类的初始化
        Class<?> clazz = systemClassLoader.loadClass("me.qianlv.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("----------------");
        // 会导致类的初始化
        Class<?> cLClass = Class.forName("me.qianlv.jvm.classloader.CL");
        System.out.println(cLClass);
    }
}
