package edu.JamesTang.onlineExam.Controller.servlet.userServlet;

import edu.JamesTang.onlineExam.Model.dao.UserDao;
import edu.JamesTang.onlineExam.Model.dao.UserDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JamesTang
 * @date 2020/12/22 21:27
 */

public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ID=req.getParameter("id");
        String passWord=req.getParameter("password");

        UserDao ud= new UserDaoImplement();
        if(ud.login(ID,passWord)){
            //TODO
        }

    }
}
