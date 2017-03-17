package dao;

import db.DBUtil;
import model.Goddess;


import java.sql.*;
import java.sql.Date;
import java.util.*;


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
    public void delGoddess(Integer id){
        Connection connection  = DBUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM imooc_goddess WHERE id = "+id;
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateGoddess(Goddess goddess){
        final String UPDATE_USER = "admin";
        final long UPDATE_DATE = new java.util.Date().getTime();
        Connection connection = DBUtil.getConnection();
        String sql = "UPDATE imooc_goddess SET name=?,sex=?,age=?,birthday=?," +
                "email=?,mobile=?,update_user=?,update_date=? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,goddess.getName());
            statement.setInt(2,goddess.getSex());
            statement.setInt(3,goddess.getAge());
            statement.setDate(4,new Date(goddess.getBirthday().getTime()));
            statement.setString(5,goddess.getEmail());
            statement.setString(6,goddess.getMobile());
            statement.setString(7,UPDATE_USER);
            statement.setDate(8,new Date(UPDATE_DATE));
            statement.setInt(9,goddess.getId());    //修改的条件，如果存在会修改整个表
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /*
    从map里面取出要操作的列名、操作符（like,=,>,<）以及值
    多个条件就保存在List里面
    * */
    public List query(List<Map> search){
        StringBuilder sql = new StringBuilder("SELECT * FROM imooc_goddess WHERE 1=1");
        Connection connection = DBUtil.getConnection();
        List list = null;
        for(Map map : search){
           sql.append(" and "+map.get("name")+" "+map.get("rela")+" '"+map.get("value")+"';");
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql.toString()); //StingBuilder转String
            list = new LinkedList();
            while (set.next()){
                Goddess goddess = new Goddess();
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
                list.add(goddess);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ResultSet getGoddess(Integer id){
        Connection connection = DBUtil.getConnection();
        ResultSet set = null;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM imooc_goddess WHERE id = "+id;
            set = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

}
