package edu.JamesTang.onlineExam.Model;

import java.sql.*;

/**
 * @author JamesTang
 * @date 2020/12/20 22:25
 */

public class DBConnect {

    static String url="jdbc:mysql://localhost:3306/onlineexam?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static String user="root";
    static String password="13299338749";
    static Connection connection=null;
    static PreparedStatement ps=null;
    static ResultSet result=null;
    static Statement statement=null;

    public static void init(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


    }

    public static int addUpdateDelete(String sql){

        int flag=0;
        try{
            ps=connection.prepareStatement(sql);
            if(!ps.execute()){
                flag++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return flag;
    }

    public static ResultSet selectSQL(String sql){

        try{
            ps=connection.prepareStatement(sql);
            result=ps.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public static void closeConnect() {
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
