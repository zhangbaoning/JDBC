import dao.GoddessDAO;
import model.Goddess;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/3/14.
 */
public class Test {
    public static void main(String[] args) {
        GoddessDAO dao = new GoddessDAO();
        List<Goddess> list = dao.query();
        for (Goddess goddess:list){
            System.out.print("姓名:"+goddess.getName()+" ");
            System.out.println("年龄"+goddess.getAge());
        }
    }
}
