package edu.JamesTang.onlineExam.Controller.servlet.userServlet;

import edu.JamesTang.onlineExam.Model.dao.UserDao;
import edu.JamesTang.onlineExam.Model.dao.UserDaoImplement;
import edu.JamesTang.onlineExam.Model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JamesTang
 * @date 2020/12/23 19:01
 */

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String iD =req.getParameter("id");
        String passWord=req.getParameter("password");
        String name=req.getParameter("name");
        int score=0;
        String Sclass="";
        User user=new User(iD,passWord,name,score,Sclass, false);

        UserDao ud=new UserDaoImplement();

        if(ud.register(user)){
            req.setAttribute("id",iD);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }
    }
}
