package edu.JamesTang.onlineExam.Model.dao;

import edu.JamesTang.onlineExam.Model.DBConnect;
import edu.JamesTang.onlineExam.Model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JamesTang
 * @date 2020/12/20 22:23
 */

public class UserDaoImplement implements UserDao{


    @Override
    public boolean login(String ID, String Password){

        DBConnect.init();
        boolean flag=false;

        try {
            ResultSet result=DBConnect.selectSQL("SELECT * FROM user WHERE ID='"+ID+"' AND PASSWORD='"+Password+"';");
            while (result.next()){
                if(result.getString("ID").equals(ID) && result.getString("PASSWORD").equals(Password)){
                    flag=true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnect.closeConnect();
        }
        return flag;
    }

    @Override
    public boolean isAdmin(String ID) {

        DBConnect.init();
        boolean flag=false;
        try{
            ResultSet result=DBConnect.selectSQL("SELECT isAdmin FROM user WHERE ID='"+ID+"';");
            while(result.next()){
                if(result.getString("isAdmin").equals("1")){
                    flag=true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnect.closeConnect();
        }
        return flag;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public boolean deleteAccount() {
        return false;
    }

    @Override
    public boolean updatePassword(String ID) {
        return false;
    }

    @Override
    public boolean updateScore(String ID,int Score) {

        DBConnect.init();
        boolean flag=false;
        String sql="UPDATE user SET SCORE='"+Score+"' WHERE ID='"+ID+"';";
        if(DBConnect.addUpdateDelete(sql) > 0){
            flag=true;
        }
        DBConnect.closeConnect();
        return flag;
    }
}
