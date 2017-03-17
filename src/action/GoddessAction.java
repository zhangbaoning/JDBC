package action;

import dao.GoddessDAO;
import model.Goddess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangbaoning on 2017/3/16.
 */
public class GoddessAction {
    public void add(Goddess goddess){
        GoddessDAO dao = new GoddessDAO();
        dao.addGoddess(goddess);
    }
    public void del(Integer id){
        GoddessDAO dao = new GoddessDAO();
        dao.delGoddess(id);//未完成
    }
    public void update(Goddess goddess){
        GoddessDAO dao = new GoddessDAO();
        dao.updateGoddess(goddess);//未完成
    }
    public Goddess get(Integer id){
        GoddessDAO dao = new GoddessDAO();
        Goddess goddess = new Goddess();
        ResultSet set  = dao.getGoddess(id);
        try {
            while (set.next()){
                goddess.setId(set.getInt("id"));
                goddess.setName(set.getString("name"));
                goddess.setSex(set.getInt("sex"));
                goddess.setAge(set.getInt("age"));
                goddess.setBirthday(set.getDate("birthday"));
                goddess.setEmail(set.getString("email"));
                goddess.setMobile(set.getString("mobile"));
                goddess.setCreate_user(set.getString("create_user"));
                goddess.setCreate_date(set.getDate("create_date"));
                goddess.setUpdate_user(set.getString("update_user"));
                goddess.setUpdate_date(set.getDate("update_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goddess;
    }
    public List query(){
        GoddessDAO dao = new GoddessDAO();
        return null;//未完成
    }

    public List query(List<Map> list){
        GoddessDAO dao = new GoddessDAO();
        return dao.query(list);
    }
}
