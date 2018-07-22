package com.java.aop.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

/**
 * @Auther: YSFY
 * @Date: 2018/7/22 00:00
 * @Pacage_name: com.java.aop.util
 * @Project_Name: javaTest
 * @Description:    JDBC数据库连接工厂
 */
public class JDBCFactory {

    private static Vector vector = new Vector();

    static {
        InputStream inputStream = JDBCFactory.class.getClassLoader().getResourceAsStream("mybatis/mybatis.properties");
        Properties properties = new Properties();

        try {
            properties.load(inputStream);

            Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动

            String driver = properties.getProperty("jdbc_driver");
            String url = properties.getProperty("jdbc_url");
            String username = properties.getProperty("jdbc_username");
            String password = properties.getProperty("jdbc_password");
            Integer size = Integer.valueOf(properties.getProperty("jdbc_initConnectionSize"));

            for(int i=0;i<size;i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                if(null != connection) {
                    vector.add(connection);
                }
            }

            System.out.println("成功初始化：" + size + "个数据库连接");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        if(vector.size()>0) {
            connection = (Connection) vector.remove(0);
        }

        return connection;
    }

    public static void stopConnection(Connection connection) throws SQLException {
        if(null != connection) {
            connection.close();
        }
    }
}
