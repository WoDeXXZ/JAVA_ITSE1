package view;

import controller.UserManagement;

import java.util.Scanner;

public class UserQueryMenu {
    public UserQueryMenu() {
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        while (!UserManagement.FindAccount(ID)) {
            System.out.println("此账号不存在，请输入新的账号");
            scanner = new Scanner(System.in);
            ID = scanner.nextInt();
        }
        System.out.println(UserManagement.Query(ID));
        System.out.println("查询账号成功");
    }
}
