package dao;

import db.DBUtil;
import model.Goddess;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by zhangbaoning on 2017/3/8.
 */
public class GoddessDAO {
    public void addGoddess(Goddess goddess){
        Connection connection = DBUtil.getConnection();
        String sql = "INSERT INTO imooc_goddess(name,sex,age,birthday,email,mobile" +
                ",create_user,create_date)"+
                "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,goddess.getName());
            statement.setInt(2,goddess.getSex());
            statement.setInt(3,goddess.getAge());
            statement.setDate(4, (Date) goddess.getBirthday());
            statement.setString(5,goddess.getEmail());
            statement.setString(6,goddess.getMobile());
            statement.setString(7,goddess.getCreate_user());
            //util.date向sql.date转换：new Date(goddess.getCreate_date().getTime())
            statement.setDate(8, new Date(goddess.getCreate_date().getTime()));
//            statement.setString(9,goddess.getUpdate_user());
//            statement.setDate(10, (Date) goddess.getUpdate_date());
            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
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
