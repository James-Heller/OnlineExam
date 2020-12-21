package edu.JamesTang.onlineExam.Model.dao;

import edu.JamesTang.onlineExam.Model.entity.User;

import java.util.List;

/**
 * @author JamesTang
 * @date 2020/12/20 22:18
 */

public interface UserDao {

    boolean login(String ID,String Password);
    boolean isAdmin(String ID);
    List<User> getUserList();
    boolean deleteAccount();
    boolean updatePassword(String ID);
    boolean updateScore(String ID, int Score);
}
