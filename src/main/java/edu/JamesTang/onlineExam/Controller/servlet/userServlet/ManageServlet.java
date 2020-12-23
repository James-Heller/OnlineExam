package edu.JamesTang.onlineExam.Controller.servlet.userServlet;

import edu.JamesTang.onlineExam.Model.dao.UserDao;
import edu.JamesTang.onlineExam.Model.dao.UserDaoImplement;
import edu.JamesTang.onlineExam.Model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author JamesTang
 * @date 2020/12/23 21:30
 */

public class ManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        UserDao ud=new UserDaoImplement();

        List<User> list=ud.getUserList();
        req.setAttribute("all",list);
        req.getRequestDispatcher("manage.jsp").forward(req,resp);
    }
}
