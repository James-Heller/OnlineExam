package edu.JamesTang.onlineExam.Controller.servlet.paperServlet;

import edu.JamesTang.onlineExam.Model.DBConnect;
import edu.JamesTang.onlineExam.Model.dao.PaperDao;
import edu.JamesTang.onlineExam.Model.dao.PaperDaoImplement;
import edu.JamesTang.onlineExam.Model.entity.ExamPaper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author JamesTang
 * @date 2020/12/24 0:45
 */

public class GetExamServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        PaperDao pd=new PaperDaoImplement();
        try {
            List<ExamPaper> list=pd.getRandomPaper();
            req.setAttribute("papers",list);
            req.getRequestDispatcher("exam.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
