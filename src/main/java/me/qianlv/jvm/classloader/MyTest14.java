package me.qianlv.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = loader.getResources("me/qianlv/jvm/classloader/MyTest13.class");
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }

        System.out.println("--------------------");
        System.out.println(MyTest14.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}
