package me.qianlv.jvm.bytecode;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject rs = new RealSubject();
        DynamicSubject dynamicSubject = new DynamicSubject(rs);
        Subject subject = (Subject) Proxy.newProxyInstance(rs.getClass().getClassLoader(), new Class[]{Subject.class}, dynamicSubject);
        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
