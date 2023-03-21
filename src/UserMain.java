import com.javateam.po.User;
import com.javateam.service.LoginService;
import com.javateam.service.UserService;
import com.javateam.util.InPutUtil;

import java.util.List;

public class UserMain {
    static UserService us=new UserService();

    public static void queryAll() {
        List<User> users=us.queryAll();
        for(User u:users){
            System.out.println(u.getUid()+"\t"+u.getUname()+"\t"+u.getPassword()+"\t"+u.getStatus());
        }
    }

    public static void addUser(){
        System.out.println("请输入新增的用户名：");
        String uname=InPutUtil.getString();
        System.out.println("请输入新增的用户密码：");
        String password=InPutUtil.getString();
        System.out.println("请输入新增的用户身份：");
        String statue=InPutUtil.getString();
        User u=new User();
        u.setUname(uname);
        u.setPassword(password);
        u.setStatus(statue);
        boolean flag=us.addUser(u);
        if(flag){
            System.out.println("新增成功！");
        }
    }

    public static void deleteUser(){
        System.out.println("请选择需要删除的用户编号：");
        int uid=InPutUtil.getInt();
        boolean flag=us.deleteUser(uid);
        if(flag){
            System.out.println("删除成功！");
        }
    }

    public static void updateUser() {
        System.out.println("请输入要修改的用户编号：");
        int uid=InPutUtil.getInt();
        System.out.println("请输入修改后的用户名：");
        String uname=InPutUtil.getString();
        System.out.println("请输入修改后的用户密码：");
        String password=InPutUtil.getString();
        System.out.println("请输入修改后的用户身份：");
        String statue=InPutUtil.getString();
        User u=new User();
        u.setUid(uid);
        u.setUname(uname);
        u.setPassword(password);
        u.setStatus(statue);
        boolean flag=us.updateUser(u);
        if(flag) {
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
    }

    public static void main(String[] args) {
        boolean flag=true;
        String sta=null;
        flag=true;
        while(flag){
            System.out.println("**************欢迎来到用户管理平台*****************");
            System.out.println("请选择：1、查询\t2、添加\t3、修改\t4、删除\t0、退出");
            System.out.println("**************************************************");
            int i=InPutUtil.getInt();
            switch (i) {
                case 1:
                    System.out.println("查询");
                    queryAll();
                    break;
                case 2:
                    System.out.println("新增");
                    addUser();
                    break;
                case 3:
                    System.out.println("修改");
                    queryAll();
                    updateUser();
                    break;
                case 4:
                    System.out.println("删除");
                    queryAll();
                    deleteUser();
                    break;
                case 0:
                    System.out.println("系统已退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("没有此选项，请重新选择：");
                    break;
            }
        }
    }
}
