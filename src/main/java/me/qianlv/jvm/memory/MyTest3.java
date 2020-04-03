package me.qianlv.jvm.memory;

public class MyTest3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> A.method(), "Thread-A");
        Thread thread2 = new Thread(() -> B.method(), "Thread-B");

        thread1.start();
        thread2.start();
    }
}

class A {
    public static synchronized void method() {
        System.out.println("method from A");
        try {
            Thread.sleep(300);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {
    public static synchronized void method() {
        System.out.println("method from B");
        try {
            Thread.sleep(300);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}