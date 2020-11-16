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
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 0:
                new Menu();
            case 1:
                if (UserManagement.user_logged_into_this_system.getType() == 1) {
                    new UserInputMenu();
                    new UserManagementMenu();
                } else {
                    System.out.println("没有权限");
                    new UserManagementMenu();
                }
            case 2:
                if (UserManagement.user_logged_into_this_system.getType() == 1) {
                    new UserUpdateMenu();
                    new UserManagementMenu();
                } else {
                    System.out.println("没有权限");
                    new UserManagementMenu();
                }
            case 3:
                if (UserManagement.user_logged_into_this_system.getType() == 1) {
                    new UserDeleteMenu();
                    new UserManagementMenu();
                } else {
                    System.out.println("没有权限");
                    new UserManagementMenu();
                }
            case 4:
                if (UserManagement.user_logged_into_this_system.getType() == 1) {
                    new UserQueryMenu();
                    new UserManagementMenu();
                } else {
                    System.out.println("没有权限");
                    new UserManagementMenu();
                }
            case 5:
                new UserChangePasswordMenu();
                new UserManagementMenu();
            default:
                new UserManagementMenu();
        }
    }
}
