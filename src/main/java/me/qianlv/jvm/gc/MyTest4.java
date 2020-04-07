package me.qianlv.jvm.gc;

/**
 * -verbose:gc -Xmx200m -Xmn50m -XX:TargetSurvivorRatio=60 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:MaxTenuringThreshold=3
 */
public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("111");

        myGc();
        Thread.sleep(1000);

        System.out.println("222");

        myGc();
        Thread.sleep(1000);

        System.out.println("333");

        myGc();
        Thread.sleep(1000);

        System.out.println("444");

        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("555");

        myGc();
        Thread.sleep(1000);

        System.out.println("666");
    }

    private static void myGc() {
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
