package me.qianlv.jvm.classloader;

/**
 * 数组类型是有jvm在运行时创建的
 * 数组的类加载器与数组中元素的类加载器一致
 *
 * @author tinytree
 */
public class MyTest15 {
    public static void main(String[] args) {
        // 启动类加载器
        String[] strings = new String[10];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("------------------");

        // 应用类加载器
        MyTest15[] myTest15s = new MyTest15[10];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("------------------");

        // 原生类型的数组没有类加载器
        int[] ints = new int[10];
        System.out.println(ints.getClass().getClassLoader());

    }
}
