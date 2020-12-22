package edu.JamesTang.onlineExam.Model.dao;

import edu.JamesTang.onlineExam.Model.DBConnect;
import edu.JamesTang.onlineExam.Model.entity.ExamPaper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author JamesTang
 * @date 2020/12/21 19:34
 */

public class PaperDaoImplement implements PaperDao{

    @Override
    public boolean addPaper(ExamPaper paper){

        String sql="INSERT INTO tb_subject VALUES ('"+paper.getPaperID()+"', '"+paper.getPaperTitle()+"', '"+paper.getOptionA()+"', " +
                "'"+paper.getOptionB()+"', '"+paper.getOptionC()+"', '"+paper.getOptionD()+"', '"+paper.getAnswer()+"', '"+paper.getInstruct()+"')";
        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete(sql);
        if(i>0){
            flag=true;
        }

        DBConnect.closeConnect();
        return flag;
    }

    @Override
    public boolean deletePaper(String paperID) {

        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete("DELETE FROM tb_subject WHERE subjectID='"+paperID+"'");
        if(i>0){
            flag=true;
        }

        DBConnect.closeConnect();
        return flag;
    }


    @Override
    public boolean updatePaperID(String paperID, String ID){

        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectID='"+ID+"' WHERE subjectID='"+paperID+"'");
        if(i>0){
            flag=true;
        }

        DBConnect.closeConnect();
        return flag;
    }

    @Override
    public boolean updatePaperTitle(String paperID,String Title){

        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectTitle='"+Title+"' WHERE subjectID='"+paperID+"'");
        if(i>0){
            flag=true;
        }

        DBConnect.closeConnect();
        return flag;

    }

    @Override
    public boolean updatePaperOptions(String paperID,int Option,String optionText){

        if(Option>4 || Option <0){
            return false;
        }
        DBConnect.init();
        boolean flag=false;
        int i=0;
        
        switch (Option){
            case 1: i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectOptionA='"+optionText+"' WHERE subjectID='"+paperID+"'");break;
            case 2: i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectOptionB='"+optionText+"' WHERE subjectID='"+paperID+"'");break;
            case 3: i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectOptionC='"+optionText+"' WHERE subjectID='"+paperID+"'");break;
            case 4: i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectOptionD='"+optionText+"' WHERE subjectID='"+paperID+"'");break;
        }

        if(i>0){
            flag=true;
        }

        DBConnect.closeConnect();
        return flag;
    }

    @Override
    public boolean updatePaperAnswer(String paperID,int answerCode){

        DBConnect.init();
        boolean flag=false;
        int i=0;

        switch (answerCode){
            case 1:i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectAnswer='A' WHERE subjectID='"+paperID+"'");break;
            case 2:i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectAnswer='B' WHERE subjectID='"+paperID+"'");break;
            case 3:i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectAnswer='C' WHERE subjectID='"+paperID+"'");break;
            case 4:i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectAnswer='D' WHERE subjectID='"+paperID+"'");break;
        }

        if(i>0){
            flag=true;
        }

        return flag;
    }

    @Override
    public boolean updatePaperInstruct(String paperID,String instruct){

        DBConnect.init();
        boolean flag=false;

        int i=DBConnect.addUpdateDelete("UPDATE tb_subject SET subjectParse='"+instruct+"' WHERE subjectID='"+paperID+"'");
        if(i>0){
            flag=true;
        }

        return flag;
    }

    @Override
    public ExamPaper getPaper(String paperID) {

        DBConnect.init();
        ExamPaper paper;

        ResultSet result=DBConnect.selectSQL("SELECT * FROM tb_subject WHERE subjectID='"+paperID+"'");

       try {

           while (result.next()){
               paper=new ExamPaper(result.getString("subjectID"),result.getString("subjectTitle"),result.getString("subjectOptionA"),
                       result.getString("subjectOptionB"),result.getString("subjectOptionC"),result.getString("subjectOptionD"),
                       result.getString("subjectAnswer"),result.getString("subjectParse"));
               return paper;
           }
       }catch (SQLException e){
           e.printStackTrace();
       }

       return null;
    }
}
