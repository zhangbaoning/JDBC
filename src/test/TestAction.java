package test;

import action.GoddessAction;
import dao.GoddessDAO;
import model.Goddess;
import org.junit.Test;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by zhangbaoning on 2017/3/17.
 */
public class TestAction {
    @Test
    public void testAddGoddess(){
        final String CREATE_USER = "zhangbaoning";
        final Date CRATE_DATE  = new Date(2017-3-15);
        Goddess goddess = new Goddess();
        goddess.setName("赵敏");
        goddess.setSex(2);
        goddess.setAge(23);
        goddess.setBirthday(new java.sql.Date(1900-1-1));
        goddess.setEmail("zhaomin@qq.com");
        goddess.setMobile("65511100233");
        goddess.setCreate_user(CREATE_USER);
        goddess.setCreate_date(CRATE_DATE);
        new GoddessAction().add(goddess);
    }
    @Test
    public void testDel(){
        new GoddessAction().del(7);
    }
    @Test
    public void testUpdate(){
        GoddessAction action = new GoddessAction();
        Goddess goddess = action.get(6);
        goddess.setEmail("zhang@qq.com");
        action.update(goddess);
    }
    @Test
    public  void testQuery() {
        List search  = new LinkedList();
        Map map = new HashMap();
        map.put("name","name");
        map.put("rela","like");
        map.put("value","西施");
        search.add(map);
        List<Goddess> list = new GoddessAction().query(search);
        for (Goddess goddess:list){
            System.out.println(goddess.toString());
        }
    }

}
