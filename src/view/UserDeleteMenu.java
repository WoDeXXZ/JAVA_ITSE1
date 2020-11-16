package view;

import controller.UserManagement;

import java.util.Scanner;

public class UserDeleteMenu {
    public UserDeleteMenu() {
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        UserManagement.Delete(ID);
        System.out.println("删除用户成功");
    }
}
