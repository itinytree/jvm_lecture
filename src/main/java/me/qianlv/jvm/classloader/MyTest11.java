package me.qianlv.jvm.classloader;

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent 3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child3 static block");
    }
}

/**
 * 子类使用父类的静态变量或者静态方法,表示对于父类的主动使用
 *
 * @author xiaoshu
 */
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("------------------");
        Child3.doSomething();
    }
}
