package me.qianlv.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @author tinytree
 */
public class MyTest27 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "username", "password");

ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
String resourceName = "java/lang/String.class";
Enumeration<URL> urls = classLoader.getResources(resourceName);
while (urls.hasMoreElements()) {
    URL url = urls.nextElement();
    System.out.println(url);
}
    }
}
