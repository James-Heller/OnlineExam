package edu.JamesTang.onlineExam.Model.dao;

import edu.JamesTang.onlineExam.Model.DBConnect;
import edu.JamesTang.onlineExam.Model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JamesTang
 * @date 2020/12/20 22:23
 */

public class UserDaoImplement implements UserDao{

    @Override
    public boolean register(User user) {

        checkExist(user);

        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete("INSERT INTO user VALUES ('"+user.getID()+"', '"+user.getPassword()+"', " +
                "'"+user.getName()+"', '"+user.getClassid()+"', '"+user.getScore()+"', '"+parseBoolean(user.getAdmin())+"')");

        if(i>0){
            flag=true;
        }
        DBConnect.closeConnect();
        return flag;
    }


    @Override
    public boolean login(String iD, String password){

        DBConnect.init();
        boolean flag=false;

        try {
            ResultSet result=DBConnect.selectSQL("SELECT * FROM user WHERE ID='"+iD+"' AND PASSWORD='"+password+"';");
            while (result.next()){
                if(result.getString("ID").equals(iD) && result.getString("PASSWORD").equals(password)){
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

        DBConnect.init();
        ArrayList<User> list=new ArrayList<>();
        try{
            ResultSet result=DBConnect.selectSQL("SELECT * FROM user;");
            while (result.next()){
                list.add(new User(result.getString("ID"), result.getString("PASSWORD"), result.getString("NAME"),
                        result.getInt("SCORE"),result.getString("CLASS"), result.getInt("isAdmin") == 1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        DBConnect.closeConnect();
        return list;
    }

    @Override
    public boolean deleteAccount(String iD) {

        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete("DELETE FROM user where ID='"+iD+"';");
        if(i>0){
            flag=true;
        }

        DBConnect.closeConnect();
        return flag;
    }

    @Override
    public boolean updatePassword(String iD,String password) {

        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete("UPDATE user SET PASSWORD='"+password+"' WHERE ID='"+iD+"';");
        if(i>0){
            flag=true;
        }
        DBConnect.closeConnect();
        return flag;
    }

    @Override
    public boolean updateScore(String iD, int score) {

        DBConnect.init();
        boolean flag=false;
        String sql="UPDATE user SET SCORE='"+score+"' WHERE ID='"+iD+"';";
        if(DBConnect.addUpdateDelete(sql) > 0){
            flag=true;
        }
        DBConnect.closeConnect();
        return flag;
    }

    private static  int parseBoolean(boolean bool){
        if(bool){
            return 1;
        }
        else {
            return 0;
        }
    }

    private boolean checkExist(User user){

        DBConnect.init();

        ResultSet result=DBConnect.selectSQL("SELECT * FROM user WHERE ID='"+user.getID()+"';");
        try{
            if(result.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public User getUser(String id) {

        DBConnect.init();
        User user=null;
        try {
            ResultSet result=DBConnect.selectSQL("SELECT * FROM user WHERE ID='"+id+"';");
            while (result.next()){
                user=new User(result.getString("ID"), result.getString("PASSWORD"), result.getString("NAME"),
                        result.getInt("SCORE"),result.getString("CLASS"), result.getInt("isAdmin") == 1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
