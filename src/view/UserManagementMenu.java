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
        switch (scanner.nextInt()) {
            case 0:
                new Menu();
            case 1:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 1) {
                    new UserInputMenu();
                } else {
                    System.out.println("没有权限");
                }
                new UserManagementMenu();
            case 2:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 1) {
                    new UserUpdateMenu();
                } else {
                    System.out.println("没有权限");
                }
                new UserManagementMenu();
            case 3:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 1) {
                    new UserDeleteMenu();
                } else {
                    System.out.println("没有权限");
                }
                new UserManagementMenu();
            case 4:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 1) {
                    new UserQueryMenu();
                } else {
                    System.out.println("没有权限");
                }
                new UserManagementMenu();
            case 5:
                new UserChangePasswordMenu();
                new UserManagementMenu();
            default:
                new UserManagementMenu();
        }
    }
}
