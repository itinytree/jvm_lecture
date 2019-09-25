package me.qianlv.jvm.classloader;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 当一个接口在初始化时,并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候(如引用接口中所定义的常量时),才会初始化
 *
 * @author xiaoshu
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.a);
    }
}


interface MyParent5 {
    int a = 5;
}

interface MyChild5 extends MyParent5 {
    public static final int b = ThreadLocalRandom.current().nextInt(2);
}