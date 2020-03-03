package me.qianlv.jvm.classloader;

/**
 * @author tinytree
 */
public class MyTest18_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/tinytree/Desktop/");

        Class<?> clazz = loader1.loadClass("me.qianlv.jvm.classloader.MyTest1");
        System.out.println(clazz.hashCode());
        System.out.println(clazz.getClassLoader());
    }
}
