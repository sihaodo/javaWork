package com.database;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Util {

    private static DataSource dataSource;

    public static Connection getConnection() throws Exception{
        return Util.setConnection();
    }

    private static Connection createConnection() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
        String username = "scott";
        String password = "qwer";
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    private static DataSource setDatasource() throws  Exception{
        InputStream in = Util.class.getClassLoader().getResourceAsStream("dataBase.properties");
        Properties properties = new Properties();
        properties.load(in);
        dataSource = BasicDataSourceFactory.createDataSource(properties);
        return dataSource;
    }

    private static Connection setConnection() throws Exception{
        Util.setDatasource();
        Connection connection = dataSource.getConnection();
        return connection;
    }

}
