package me.qianlv.jvm.bytecode;

/**
 *  javap -c me.qianlv.jvm.bytecode.MyTest1
 * @author tinytree
 */
public class MyTest1 {
    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
