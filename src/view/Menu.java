package view;

import java.util.Scanner;

public class Menu {

    public Menu() {
        System.out.println("************************");
        System.out.println("请登录");
        new LoginMenu();
        go();
    }

    public static void go() {
        System.out.println("1.用户管理");
        System.out.println("2.图书管理");
        System.out.println("3.图书流通管理");
        System.out.println("0.退出系统");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                break;
            case 1:
                new UserManagementMenu();
            case 2:
                new LibraryManagementMenu();
            case 3:
                new BookCirculationMenu();
        }
    }
}