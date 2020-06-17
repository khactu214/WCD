package com.example.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserData {
    public static boolean checkUser(String username,String password) throws SQLException, ClassNotFoundException{
        boolean sts = false;
        DbConnection dbConnection = new DbConnection();
        if (username != null && password != null){
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement("select * from tbuser where username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            sts = resultSet.next();
        }
        return sts;
    }
}
