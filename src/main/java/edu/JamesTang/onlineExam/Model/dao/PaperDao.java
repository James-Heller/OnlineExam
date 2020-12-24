package edu.JamesTang.onlineExam.Model.dao;

import edu.JamesTang.onlineExam.Model.entity.ExamPaper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JamesTang
 * @date 2020/12/21 19:30
 */

public interface PaperDao {

    /**
     * Add a examPaper to database
     * @param paper paper obj
     * @return operate state
     */
    boolean addPaper(ExamPaper paper);

    /**
     * Delete paper from database
     * @param paperID id of the paper
     * @return operate state
     */
    boolean deletePaper(String paperID);

    /**
     * Change paper id
     * @param paperID id fo the paper
     * @param ID new id
     * @return operate state
     */
    boolean updatePaperID(String paperID, String ID);

    /**
     * Change paper title
     * @param paperID paper id
     * @param Title New title
     * @return operate state
     */
    boolean updatePaperTitle(String paperID,String Title);

    /**
     * Change optionText
     * @param paperID ID of the paper
     * @param Option The option label
     * @param optionText Text of the option
     * @return operate state
     */
    boolean updatePaperOptions(String paperID,int Option,String optionText);

    /**
     * Change the right answer
     * @param paperID Id of the paper
     * @param answerCode answer label
     * @return operate state
     */
    boolean updatePaperAnswer(String paperID,int answerCode);

    /**
     * Change the instruct of the paper
     * @param paperID Id of the paper
     * @param instruct Instruct text
     * @return operate state
     */
    boolean updatePaperInstruct(String paperID,String instruct);

    /**
     * Get the paper obj
     * @param paperID Id of the paper
     * @return A paper obj
     */
    ExamPaper getPaper(int paperID);

    /**
     * Get shuffled paper number array
     * @return paper number array
     * @throws SQLException When you call this method, it is almost impossible to generate SQLException
     */
    ArrayList<Integer> paperCount() throws SQLException;

    /**
     *  Get a array contain shuffled subject
     * @return A shuffled subject array
     * @throws SQLException When you call this method, it is almost impossible to generate SQLException
     */
    List<ExamPaper> getRandomPaper() throws SQLException;

    /**
     * Return the right answer
     * @param id The paper id
     * @return answer
     */
    char getAnswer(int id);


}
