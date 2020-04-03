package me.qianlv.jvm.bytecode;

import java.util.Date;

/**
 * 针对方法调用动态分派的过程,虚拟机会在类的方法区建立一个虚方法表的数据结构(virtual method table, vtable)
 * 针对于invokeinterface指令来说,虚拟机会建立一个叫做接口方法表的数据结构(interface method table, itable)
 */
public class MyTest7 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        animal.test("Hello");
        dog.test(new Date());
    }
}


class Animal {
    public void test(String str) {
        System.out.println("animal str");
    }

    public void test(Date date) {
        System.out.println("animal date");
    }
}

class Dog extends Animal {
    @Override
    public void test(String str) {
        System.out.println("Dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("Dog date");
    }

    public void method() {
        System.out.println("Dog method");
    }
}