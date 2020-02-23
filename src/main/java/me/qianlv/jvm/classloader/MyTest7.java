package me.qianlv.jvm.classloader;

/**
 * @author xiaoshu
 */
public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.String");
        System.out.println(cls.getClassLoader());

        Class<?> cClass = Class.forName("me.qianlv.jvm.classloader.C");
        System.out.println(cClass.getClassLoader());
    }
}

class C{

}