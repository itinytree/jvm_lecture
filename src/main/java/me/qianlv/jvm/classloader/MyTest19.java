package me.qianlv.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * -Djava.ext.dirs=  更改扩展类加载器的路径
 *
 * @author tinytree
 */
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
