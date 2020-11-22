package view;

import controller.UserManagement;

import java.util.Scanner;

public class Menu {
    public Menu() {
        System.out.println("1.用户管理");
        System.out.println("2.图书管理");
        System.out.println("3.图书流通管理");
        System.out.println("4.切换用户");
        System.out.println("0.退出系统");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                System.exit(0);
            case 1:
                new UserManagementMenu();
            case 2:
                new BookManagementMenu();
            case 3:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 2) {
                    new BookCirculationManagementMenu();
                } else {
                    System.out.println("没有权限");
                    new Menu();
                }
            case 4:
                new LoginMenu();
            default:
                new Menu();
        }
    }
}