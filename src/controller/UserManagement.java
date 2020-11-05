package controller;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {
    //管理用户
    //每个用户的账号都是唯一的

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

    public static ArrayList<User> getUsers() {
        //获取所有用户信息
        Read();
        return userArrayList;
    }
    /*
    public ArrayList<User> login(){//登录方法

    }
    */


    public static void Input() {
        //用户信息录入
        Scanner scanner;
        System.out.println("请输入账号类型");
        scanner = new Scanner(System.in);
        int type = scanner.nextInt();

        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        while (FindAccount(ID)) {
            System.out.println("此账号已存在，请输入新的账号");
            scanner = new Scanner(System.in);
            ID = scanner.nextInt();
        }

        System.out.println("请输入密码");
        scanner = new Scanner(System.in);
        String password = scanner.next();

        System.out.println("请输入姓名");
        scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println("请输入单位");
        scanner = new Scanner(System.in);
        String unit = scanner.next();

        System.out.println("请输入电话");
        scanner = new Scanner(System.in);
        int telephone = scanner.nextInt();

        System.out.println("请输入可借书数");
        scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        User user = new User(type, ID, password, name, unit, telephone, count);
        Read();
        userArrayList.add(user);
        Write(userArrayList);
    }

    public static void Update() {
        //用户信息修改
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        Read();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (ID == userArrayList.get(i).getID()) {
                System.out.println("请输入姓名");
                scanner = new Scanner(System.in);
                userArrayList.get(i).setName(scanner.next());

                System.out.println("请输入单位");
                scanner = new Scanner(System.in);
                userArrayList.get(i).setUnit(scanner.next());

                System.out.println("请输入电话");
                scanner = new Scanner(System.in);
                userArrayList.get(i).setTelephone(scanner.nextInt());

                System.out.println("请输入可借书数");
                scanner = new Scanner(System.in);
                userArrayList.get(i).setCount(scanner.nextInt());
                break;
            }
            if (i == userArrayList.size() - 1) {
                System.out.println("没有找到账号");
            }
        }
    }

    public static void Delete() {
        //用户信息删除
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        Read();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (ID == userArrayList.get(i).getID()) {
                userArrayList.remove(i);
                break;
            }
            if (i == userArrayList.size() - 1) {
                System.out.println("没有找到账号");
            }
        }
    }

    public static void Query() {
        //用户信息查询
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        Read();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (ID == userArrayList.get(i).getID()) {
                System.out.println(userArrayList.get(i).toString());
                break;
            }
            if (i == userArrayList.size() - 1) {
                System.out.println("没有找到账号");
            }
        }
    }

    public static void ChangePassword() {
        //用户密码修改
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        Read();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (ID == userArrayList.get(i).getID()) {
                System.out.println("请输入密码");
                scanner = new Scanner(System.in);
                userArrayList.get(i).setPassword(scanner.next());
                break;
            }
            if (i == userArrayList.size() - 1) {
                System.out.println("没有找到账号");
            }
        }

    }

    public static boolean FindAccount(int ID) {
        //查找账号
        Read();
        for (User user : userArrayList) {
            if (ID == user.getID()) {
                return true;
            }
        }
        return false;
    }


    public static int FindAccountReturnType(int ID) {
        //查找账号并返回账号类型
        Read();
        for (User user : userArrayList) {
            if (ID == user.getID()) {
                return user.getType();
            }
        }
        return 0;
    }


    public static boolean FindAccountPassword(int type, int ID, String password) {
        //查找账号密码
        Read();
        for (User user : userArrayList) {
            if (type == user.getType()
                    && ID == user.getID()
                    && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
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
        }/*
        for (User user : userArrayList) {
            System.out.println(user.getID());
        }*/
    }
}
