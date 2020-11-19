package view;

import controller.UserManagement;

import java.util.Scanner;

public class UserDeleteMenu {
    public UserDeleteMenu() {
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        while (!UserManagement.FindAccount(ID)) {
            System.out.println("此账号不存在，请输入新的账号");
            System.out.println("或输入0返回主界面");
            scanner = new Scanner(System.in);
            if (scanner.nextInt() == 0) {
                System.out.println("录入用户信息失败");
                new Menu();
                break;
            }
            ID = scanner.nextInt();
        }

        UserManagement.Delete(ID);
        System.out.println("删除用户成功");
    }
}
