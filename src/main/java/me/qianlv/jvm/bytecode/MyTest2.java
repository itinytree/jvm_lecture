package me.qianlv.jvm.bytecode;

/**
 * javap -verbose -p me.qianlv.jvm.bytecode.MyTest2
 */
public class MyTest2 {
    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        myTest2.setX(8);

        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    public void test(String str) {
        synchronized (str) {
            System.out.println("Hello");
        }
    }

    public static synchronized void test2() {

    }
}
