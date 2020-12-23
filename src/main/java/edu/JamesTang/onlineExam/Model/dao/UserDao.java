package edu.JamesTang.onlineExam.Model.dao;

import edu.JamesTang.onlineExam.Model.entity.User;

import java.util.List;

/**
 * @author JamesTang
 * @date 2020/12/20 22:18
 */

public interface UserDao {

    /**
     * This method is used to login the account
     * @param iD The User ID
     * @param password The User password
     * @return true if operate success
     */
    boolean login(String iD,String password);

    /**
     *  Account register
     * @param user user obj  contain user data
     * @return true if operate success
     */
    boolean register(User user);

    /**
     * Check account is admin
     * @param iD id what to check
     * @return true if account is admin
     */
    boolean isAdmin(String iD);

    /**
     * Return a List that contain all user
     * @return a user list
     */
    List<User> getUserList();

    /**
     * Delete account from database
     * @param iD userID
     * @return true if operate success
     */
    boolean deleteAccount(String iD);

    /**
     * Change user pass word
     * @param iD userID
     * @param password new password
     * @return true if operate success
     */
    boolean updatePassword(String iD,String password);

    /**
     * Update student score
     * @param iD userID
     * @param score current score
     * @return true if operate success
     */
    boolean updateScore(String iD, int score);
}
