package me.qianlv.jvm.classloader;

/**
 * 类加载器的双亲委托
 *
 * @author xiaoshu
 */
public class MyTest13 {
    public static void main(String[] args) {
//        ClassLoader classLoader = MyTest13.class.getClassLoader();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
