package view;

import controller.UserManagement;

import java.util.Scanner;

public class BookManagementMenu {
    public BookManagementMenu() {
        System.out.println("1. 图书信息录入");
        System.out.println("2. 图书信息修改");
        System.out.println("3. 图书信息删除");
        System.out.println("4. 图书信息查询");
        System.out.println("0. 返回主菜单 ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                new Menu();
            case 1:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 2) {
                    new BookInputMenu();
                } else {
                    System.out.println("没有权限");
                    new Menu();
                }
                new BookManagementMenu();
            case 2:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 2) {
                    new BookUpdateMenu();
                } else {
                    System.out.println("没有权限");
                    new Menu();
                }
                new BookManagementMenu();
            case 3:
                if (UserManagement.userLoggedIntoThisSystem.getType() == 2) {
                    new BookDeleteMenu();
                } else {
                    System.out.println("没有权限");
                    new Menu();
                }
                new BookManagementMenu();
            case 4:
                new BookQueryMenu();
                new BookManagementMenu();
            default:
                new BookManagementMenu();
        }
    }
}