package com.SpringExample.ui.testSpring;

import java.sql.*;

public class JdbcDemo1 {

    public static void main(String[] args) throws SQLException {
        //mysql-connector-java 6.x
        //riverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //mysql-connector-java 5.x
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teaching", "root","health");
        PreparedStatement preparedStatement = conn.prepareStatement("select * from account");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement.close();
        conn.close();
    }
}
