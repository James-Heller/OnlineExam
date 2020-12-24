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
 * @date 2020/12/23 23:15
 */

public class UpdateScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        String score=req.getParameter("score");

        UserDao ud=new UserDaoImplement();

        if(ud.updateScore(id,Integer.parseInt(score))){
            req.getRequestDispatcher("operatesuccess.jsp").forward(req,resp);
        }


    }
}
