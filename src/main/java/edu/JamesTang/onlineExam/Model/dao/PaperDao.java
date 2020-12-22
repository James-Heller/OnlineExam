package edu.JamesTang.onlineExam.Model.dao;

import edu.JamesTang.onlineExam.Model.entity.ExamPaper;

/**
 * @author JamesTang
 * @date 2020/12/21 19:30
 */

public interface PaperDao {

    boolean addPaper(ExamPaper paper);
    boolean deletePaper(String paperID);
    boolean updatePaperID(String paperID, String ID);
    boolean updatePaperTitle(String paperID,String Title);
    boolean updatePaperOptions(String paperID,int Option,String optionText);
    boolean updatePaperAnswer(String paperID,int answerCode);
    boolean updatePaperInstruct(String paperID,String instruct);
    ExamPaper getPaper(String paperID);

}
