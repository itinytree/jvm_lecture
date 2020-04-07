package me.qianlv.jvm.gc;

/**
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=5 -XX:+PrintTenuringDistribution
 *
 * MaxTenuringThreshold: 在可以自动调节对象晋升(Promote)到老年代阈值的GC中,设置该阈值的最大值.
 * 该参数的默认值为15,CMS中默认值为6,G1中默认值为15(在JVM中,该数值是由4个bit来表示的,所以最大值 1111, 即15)
 *
 * 经历了多次GC后,存活的对象会在From Survivor与To Survivor之间来回存放,而这里的一个前提原则是这两个空间有足够的大小来存放这些数据,在GC算法中,会计算每个对象的年龄大小,如果达到某个年龄后发现,
 * 总大小已经大于了Survivor空间50%,那么这时就需要调整阈值,不能再继续等到默认的15次GC后才完成晋升,因为这样会导致Survivor空间不足,所以需要调整阈值,让这些存活对象尽快完成晋升
 *
 * PrintTenuringDistribution: 经理
 */
public class MyTest3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];

        System.out.println("hello world");
    }
}
