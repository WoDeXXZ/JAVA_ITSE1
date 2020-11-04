package USER;

import java.io.*;
import java.util.ArrayList;

public class UserManagement {
    private static ArrayList<User> userArrayList;//存储数据类型为User的List集合


    public static void Read() {
        //读取文件
        try {
            File file = new File("src\\USER\\User.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null) {
                User user1 = new User();
                user1.setType(Integer.parseInt(temp.split(",")[0]));
                user1.setID(Integer.parseInt(temp.split(",")[1]));
                user1.setPassword(temp.split(",")[2]);
                user1.setName(temp.split(",")[3]);
                user1.setUnit(temp.split(",")[4]);
                user1.setTelephone(Integer.parseInt(temp.split(",")[5]));
                user1.setCount(Integer.parseInt(temp.split(",")[6]));

                userArrayList.add(user1);
            }
            reader.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void Write(ArrayList<User> userArrayList) {
        //写入文件
        try {
            FileWriter fileWriter = new FileWriter("src\\USER\\User.txt");
            for (User u : userArrayList) {
                fileWriter.write(u.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public List<User> getUsers(){//获取所有用户信息

    }

    public List<User> login(){//登录方法

    }
    */

    public void input() {//用户信息录入

    }

    public void update() {//用户信息修改

    }

    public void delete() {//用户信息删除

    }

    public void query() {//用户信息查询

    }

    public void changePassword() {//用户密码修改

    }

    public static boolean FindAccountPassword(int type, int ID, String password) {
        //查找账号密码
        UserManagement.Read();
        for (User user : userArrayList) {
            if (type == user.getType()
                    && ID == user.getID()
                    && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

}
