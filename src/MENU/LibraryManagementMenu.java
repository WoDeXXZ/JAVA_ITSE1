package MENU;

import java.util.Scanner;

public class LibraryManagementMenu {

    public LibraryManagementMenu() {
        System.out.println("1. 图书信息录入");
        System.out.println("2. 图书信息修改");
        System.out.println("3. 图书信息删除");
        System.out.println("4. 图书信息查询");
        System.out.println("0. 返回主菜单 ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                Menu.go();
            case 1:
                new LibraryManagementMenu();
            case 2:
                new LibraryManagementMenu();
            case 3:
                new LibraryManagementMenu();
            case 4:
                LibraryManagementMenu.go();
        }
    }

    public static void go() {
        System.out.println("1. 按书号查询 ");
        System.out.println("2. 按书名查询 ");
        System.out.println("3. 按作者查询 ");
        System.out.println("0. 返回主菜单 ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                Menu.go();
            case 1:
                LibraryManagementMenu.go();
            case 2:
                LibraryManagementMenu.go();
            case 3:
                LibraryManagementMenu.go();
        }
    }
}