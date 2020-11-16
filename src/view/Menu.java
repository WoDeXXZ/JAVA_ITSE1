package view;

import controller.UserManagement;

import java.util.Scanner;

public class Menu {
    public Menu() {
        System.out.println("1.用户管理");
        System.out.println("2.图书管理");
        System.out.println("3.图书流通管理");
        System.out.println("0.退出系统");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 0:
                return;
            case 1:
                new UserManagementMenu();
            case 2:
                new BookManagementMenu();
            case 3:
                if (UserManagement.user_logged_into_this_system.getType() == 2) {
                    new BookCirculationMenu();
                } else {
                    System.out.println("没有权限");
                    new Menu();
                }
            default:
                new Menu();
        }
    }
}