package view;

import controller.UserManagement;

import java.util.Scanner;

public class UserQueryMenu {

    public UserQueryMenu() {
        Scanner scanner;
        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        if (UserManagement.Query(ID) != null) {
            System.out.println(UserManagement.Query(ID));
            System.out.println("查询账号信息成功");
        } else {
            System.out.println("查询账号信息失败");
            new UserManagementMenu();
        }
    }
}
