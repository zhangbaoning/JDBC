package dao;

import db.DBUtil;
import model.Goddess;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by zhangbaoning on 2017/3/8.
 */
public class GoddessDAO {
    public void addGoddess(){

    }
    public void delGoddess(){

    }
    public void updateGoddess(){

    }
    public List query(){
        Connection connection = DBUtil.getConnection();
        List list = null;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT name,age FROM imooc_goddess";
            ResultSet set = statement.executeQuery(sql);
            list = new LinkedList();
            while (set.next()){
                Goddess goddess = new Goddess();
                goddess.setName(set.getString("name"));
                goddess.setAge(set.getInt("age"));
                list.add(goddess);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Goddess getGoddess(){
        return null;
    }

}
