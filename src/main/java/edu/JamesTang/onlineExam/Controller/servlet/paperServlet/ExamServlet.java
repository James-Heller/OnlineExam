package edu.JamesTang.onlineExam.Controller.servlet.paperServlet;

import edu.JamesTang.onlineExam.Model.dao.PaperDao;
import edu.JamesTang.onlineExam.Model.dao.PaperDaoImplement;
import edu.JamesTang.onlineExam.Model.dao.UserDao;
import edu.JamesTang.onlineExam.Model.dao.UserDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JamesTang
 * @date 2020/12/24 5:33
 */

public class ExamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        int maxCode=11;
        int[] subjectId=new int[11];
        char[] answer=new char[11];
        String attrib="thisID";

        for(int i=1;i<maxCode;i++){

            subjectId[i]=Integer.valueOf(req.getParameter("subjectID"+ i));
            answer[i]=req.getParameter("option"+i).charAt(0);

        }
        UserDao ud=new UserDaoImplement();
        PaperDao pd= new PaperDaoImplement();
        if(ud.updateScore((String) req.getSession().getAttribute("contentID"),getScore(subjectId,answer,pd))){
            resp.getWriter().print("<script> alert('已交卷'); </script>");
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }
    }

    private static int getScore(int[] subjectId, char[] answerArray,PaperDao pd){

        int totalScore=0;
        int maxCode=11;
        for(int i=1;i<maxCode;i++){
            if(pd.getAnswer(subjectId[i]) == answerArray[i]){
                totalScore+=10;
            }
        }

        return totalScore;
    }



}

