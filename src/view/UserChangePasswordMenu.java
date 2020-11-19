package view;

import controller.UserManagement;

import java.util.Scanner;

public class UserChangePasswordMenu {
    public UserChangePasswordMenu() {
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        while (!UserManagement.JudgmentAccount(ID)) {
            System.out.println("此账号不存在，请输入新的账号");
            scanner = new Scanner(System.in);
            ID = scanner.nextInt();
        }

        System.out.println("请输入密码");
        scanner = new Scanner(System.in);
        String password = scanner.next();

        UserManagement.ChangePassword(ID, password);
        System.out.println("修改用户密码成功");
    }
}
