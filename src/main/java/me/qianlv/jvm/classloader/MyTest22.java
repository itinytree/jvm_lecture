package me.qianlv.jvm.classloader;

/**
 * 扩展类加载器比较特殊,从.jar包中加载class文件
 * 1. 直接运行main方法,由系统类加载器加载MyTest22与MyTest1
 *  输出:
 *  MyTest22 initializer
 *  sun.misc.Launcher$AppClassLoader@18b4aac2
 *  sun.misc.Launcher$AppClassLoader@18b4aac2
 * <p>
 * 2. 改变扩展类加载器的目录,将MyTest1.class 打包成 Test.jar
 *  cd /Users/tinytree/learn/idea-workspace/jvm_lecture/out/production/classes
 *  jar cvf Test.jar me/qianlv/jvm/classloader/MyTest1.class
 *  java -Djava.ext.dirs=./ me.qianlv.jvm.classloader.MyTest22
 *  输出:
 *  MyTest22 initializer
 *  sun.misc.Launcher$AppClassLoader@2a139a55
 *  sun.misc.Launcher$ExtClassLoader@33909752
 * @author tinytree
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());
    }
}
