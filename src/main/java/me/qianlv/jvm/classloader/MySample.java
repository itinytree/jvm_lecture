package me.qianlv.jvm.classloader;

/**
 * @author tinytree
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());
        new MyCat();
    }
}
