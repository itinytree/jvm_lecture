package me.qianlv.jvm.classloader;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 主动使用与被动使用
 * <p>
 * 当一个接口在初始化时,并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候(如引用接口中所定义的常量时),才会初始化
 * <p>
 * 当一个类被初始化的时候,它所实现的接口不会被初始化
 * 在初始化一个接口时,并不会先初始化它的父接口
 *
 * @author xiaoshu
 */
public class MyTest5 {
    public static void main(String[] args) {
        // System.out.println(MyChild5.b);
//        System.out.println(MyChild5.b);
        System.out.println(MyParent5_1.thread);
    }
}


interface MyParent5 {
//    public final static int a = 5;

    public static final Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

class MyChild5 implements MyParent5 {
    public static final int b = ThreadLocalRandom.current().nextInt(100);
}

interface MyGrandpa5_1 {
    public static final Thread thread = new Thread() {
        {
            System.out.println("MyGrandpa5_1 invoked");
        }
    };
}

interface  MyParent5_1 extends MyGrandpa5_1 {
    public static final Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 invoked");
        }
    };
}