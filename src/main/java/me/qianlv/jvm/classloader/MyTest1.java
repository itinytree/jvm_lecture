package me.qianlv.jvm.classloader;

/**
 * 主动使用与被动使用
 * <p>
 * 对于静态字段来说,只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时,要求其父类全部都已经初始化完毕了
 * <p>
 * -XX:+TraceClassLoading 用于追踪类的加载信息并打印出来
 *
 * @author xiaoshu
 */
public class MyTest1 {
    public static void main(String[] args) {
        // 没有对MyChild1初始化,也加载了该类
        //System.out.println(MyChild1.str);
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "Hello World!";

    static {
        System.out.println("MyParent1 static block.");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
