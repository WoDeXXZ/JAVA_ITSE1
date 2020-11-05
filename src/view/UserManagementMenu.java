package view;

import controller.UserManagement;

import java.util.Scanner;

public class UserManagementMenu {
    public UserManagementMenu() {
        System.out.println("1. 用户信息录入 ");
        System.out.println("2. 用户信息修改 ");
        System.out.println("3. 用户信息删除 ");
        System.out.println("4. 用户信息查询 ");
        System.out.println("5. 用户密码修改 ");
        System.out.println("0. 返回主菜单 ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                Menu.go();
            case 1:
                UserManagement.Input();
                new UserManagementMenu();
            case 2:
                UserManagement.Update();
                new UserManagementMenu();
            case 3:
                UserManagement.Delete();
                new UserManagementMenu();
            case 4:
                UserManagement.Query();
                new UserManagementMenu();
            case 5:
                UserManagement.ChangePassword();
                new UserManagementMenu();
        }
    }
}
