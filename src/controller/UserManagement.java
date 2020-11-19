package controller;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserManagement {
    //管理用户
    //每个用户的账号都是唯一的

    public static User user_logged_into_this_system;//登录此系统的用户

    public static ArrayList<User> userArrayList;
    //存储数据类型为User的ArrayList集合

    public static void Read() {
        //读取User.txt文件到ArrayList集合
        userArrayList = new ArrayList<>();
        try {
            File file = new File("src\\model\\User.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null) {
                User user = new User();
                user.setType(Integer.parseInt(temp.split(",")[0]));
                user.setID(Integer.parseInt(temp.split(",")[1]));
                user.setPassword(temp.split(",")[2]);
                user.setName(temp.split(",")[3]);
                user.setUnit(temp.split(",")[4]);
                user.setTelephone(Integer.parseInt(temp.split(",")[5]));
                user.setCount(Integer.parseInt(temp.split(",")[6]));

                userArrayList.add(user);
            }
            reader.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void Write(ArrayList<User> userArrayList) {
        //写入文件User.txt
        Compare(userArrayList);
        try {
            FileWriter fileWriter = new FileWriter("src\\model\\User.txt");
            for (User user : userArrayList) {
                fileWriter.write(user.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean Login(int ID, String password) {
        //登录方法
        if (JudgmentAccountPassword(ID, password)) {
            user_logged_into_this_system = new User(
                    Objects.requireNonNull(Query(ID)));
            return true;
        } else {
            return false;
        }
    }

    public static void Input(int type, int ID, String password, String name,
                             String unit, int telephone, int count) {
        //用户信息录入
        User user = new User(type, ID, password, name, unit, telephone, count);
        Read();
        userArrayList.add(user);
        Write(userArrayList);
    }

    public static void Update(int ID, String name, String unit, int telephone, int count) {
        //用户信息修改
        Read();
        for (User user : userArrayList) {
            if (ID == user.getID()) {
                user.setName(name);
                user.setUnit(unit);
                user.setTelephone(telephone);
                user.setCount(count);
                break;
            }
        }
        Write(userArrayList);
    }

    public static void Delete(int ID) {
        //用户信息删除
        Read();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (ID == userArrayList.get(i).getID()) {
                userArrayList.remove(i);
                Write(userArrayList);
                break;
            }
        }
        Write(userArrayList);
    }

    public static User Query(int ID) {
        //用户信息查询
        //查找账号并返回账号
        Read();
        for (User user : userArrayList) {
            if (ID == user.getID()) {
                return user;
            }
        }
        return null;
    }

    public static void ChangePassword(int ID, String password) {
        //用户密码修改
        Read();
        for (User user : userArrayList) {
            if (ID == user.getID()) {
                user.setPassword(password);
                break;
            }
        }
        Write(userArrayList);
    }

    public static boolean JudgmentAccount(int ID) {
        //判断账号是否存在
        Read();
        for (User user : userArrayList) {
            if (ID == user.getID()) {
                return true;
            }
        }
        return false;
    }

    public static boolean JudgmentAccountPassword(int ID, String password) {
        //判断账号密码是否存在
        Read();
        for (User user : userArrayList) {
            if (ID == user.getID()
                    && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static void FindIDMakeCountPlusOne(int ID) {
        //查找账号并使借书量加一
        Read();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (ID == userArrayList.get(i).getID()
                    && userArrayList.get(i).getCount() != 0) {
                userArrayList.get(i).setCount(userArrayList.get(i).getCount() + 1);
                Write(userArrayList);
            }
        }
    }

    public static void FindIDMakeCountMinusOne(int ID) {
        //查找账号并使借书量减一
        Read();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (ID == userArrayList.get(i).getID()
                    && userArrayList.get(i).getCount() != 0) {
                userArrayList.get(i).setCount(userArrayList.get(i).getCount() - 1);
                Write(userArrayList);
            }
        }
    }

    public static void Compare(ArrayList<User> userArrayList) {
        //选择排序
        //按照账号ID从小到大开始排序
        for (int i = 0; i < userArrayList.size(); i++) {
            int temp = i;
            for (int j = i + 1; j < userArrayList.size(); j++) {
                if (userArrayList.get(j).getID() < userArrayList.get(temp).getID()) {
                    temp = j;
                }
            }
            User user1 = new User(userArrayList.get(temp));
            userArrayList.set(temp, userArrayList.get(i));
            userArrayList.set(i, user1);
        }
    }
}
