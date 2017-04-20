package com.ottozhang.ism.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhangruoqiu on 2017/4/20.
 */
public class ConnectionConfig {
    public static String driver;
    public static String dburl;
    public static String user;
    public static String password;

    private static final ConnectionConfig connectionConfig = new ConnectionConfig();

    static {
        Properties prop = new Properties();
        try {
            InputStream in = ConnectionConfig.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            prop.load(in);
        } catch (IOException e) {
            System.err.println("===============load files error==============");
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }
}
