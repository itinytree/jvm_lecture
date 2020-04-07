package me.qianlv.jvm.gc;

/**
 * -verbose:gc 输出详细的GC信息
 * -Xms20M 堆容量初始值
 * -Xmx20M 对容量最大值
 * -Xmn10M 新生代大小
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8 eden与survivor的比例
 *
 * PSYoungGen: Parallel Scavenge(新生代垃圾收集器)
 * ParOldGen: Parallel Old(老年代垃圾收集器)
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];

        System.out.println("hello world");
    }
}
