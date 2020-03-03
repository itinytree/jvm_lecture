package me.qianlv.jvm.classloader;


import java.io.*;

/**
 * @author tinytree
 * -XX:+TraceClassUnloading 类卸载信息
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;
    private String path;
    private final String fileExtension = ".class";

    public MyTest16(ClassLoader parent, String classLoaderName) {
        // 显式指定该类加载器的父类加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    public MyTest16(String classLoaderName) {
        // 将系统类加载器当作该类加载器的父类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + name);
        System.out.println("ClassLoader name: " + this.classLoaderName);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        byte[] data = null;
        name = name.replace(".", File.separator);
        try (InputStream in = new FileInputStream(new File(path + name + this.fileExtension)); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int ch;
            while (-1 != (ch = in.read())) {
                out.write(ch);
            }
            data = out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("me.qianlv.jvm.classloader.MyTest1");
        System.out.println(aClass.getClassLoader());
        Object o = aClass.newInstance();
        System.out.println(o);
    }

    @Override
    public String toString() {
        return "CustomClassLoader [" + this.classLoaderName + "]";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/tinytree/Desktop/");

        Class<?> clazz = loader1.loadClass("me.qianlv.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println();
        object = null;
        clazz = null;
        loader1 = null;
        System.gc();


        loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/tinytree/Desktop/");

        clazz = loader1.loadClass("me.qianlv.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);


//        MyTest16 loader2 = new MyTest16("loader2");
//        loader2.setPath("/Users/tinytree/Desktop/");
//        Class<?> clazz2 = loader2.loadClass("me.qianlv.jvm.classloader.MyTest1");
//        System.out.println("class: " + clazz2.hashCode());
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);
//        System.out.println();
//
//        MyTest16 loader3 = new MyTest16(loader2, "loader3");
//        loader3.setPath("/Users/tinytree/Desktop/");
//        Class<?> clazz3 = loader3.loadClass("me.qianlv.jvm.classloader.MyTest1");
//        System.out.println("class: " + clazz2.hashCode());
//        Object object3 = clazz2.newInstance();
//        System.out.println(object2);
//        System.out.println();
    }
}
