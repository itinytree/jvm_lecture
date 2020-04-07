package me.qianlv.jvm.gc;

import java.io.IOException;

/**
 * PretenureSizeThreshold:设置对象超过多大时直接在老年代进行分配
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=1111 -XX:+UseSerialGC
 */
public class MyTest2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc = new byte[5 * size];

        try {
            int read = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
