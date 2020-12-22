package edu.JamesTang.onlineExam.Model.entity;

import java.io.Serializable;

/**
 * @author JamesTang
 * @date 2020/12/21 19:06
 */

public class ExamPaper implements Serializable {

    private String PaperID;
    private String PaperTitle;
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;
    private String Answer;
    private String Instruct;

    public ExamPaper(String paperID, String paperTitle, String optionA, String optionB, String optionC, String optionD, String answer, String instruct) {
        this.PaperID = paperID;
        this.PaperTitle = paperTitle;
        this.OptionA = optionA;
        this.OptionB = optionB;
        this.OptionC = optionC;
        this.OptionD = optionD;
        this.Answer = answer;
        this.Instruct = instruct;
    }

    public String getPaperID() {
        return PaperID;
    }

    public void setPaperID(String paperID) {
        PaperID = paperID;
    }

    public String getPaperTitle() {
        return PaperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        PaperTitle = paperTitle;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String optionA) {
        OptionA = optionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String optionB) {
        OptionB = optionB;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String optionC) {
        OptionC = optionC;
    }

    public String getOptionD() {
        return OptionD;
    }

    public void setOptionD(String optionD) {
        OptionD = optionD;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getInstruct() {
        return Instruct;
    }

    public void setInstruct(String instruct) {
        Instruct = instruct;
    }
}
