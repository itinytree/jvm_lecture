package me.qianlv.jvm.bytecode;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("From real request");
    }
}
