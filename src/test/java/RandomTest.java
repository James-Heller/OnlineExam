import edu.JamesTang.onlineExam.Model.DBConnect;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author JamesTang
 * @date 2020/12/24 3:00
 */

public class RandomTest {

    @Test
    public void getRandom() throws SQLException {
        DBConnect.init();
        ArrayList<Integer> array=new ArrayList<>();
        ResultSet result=DBConnect.selectSQL("SELECT COUNT(*) FROM tb_subject");
        while(result.next()){

            for (int j = 1; j <= result.getInt("COUNT(*)"); j++) {
               array.add(j);
            }
        }

    }

    @Test
    public void testselect() throws SQLException{
        int i=1;
        DBConnect.init();
        ResultSet result=DBConnect.selectSQL("SELECT * FROM tb_subject WHERE subjectID="+i+"");
        while(result.next()){
            System.out.println(result.getString("subjectAnswer"));
        }
        DBConnect.closeConnect();
    }
}
