package view;

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
                new Menu();
            case 1:
                new LibraryManagementMenu();
            case 2:
                new LibraryManagementMenu();
            case 3:
                new LibraryManagementMenu();
            case 4:
                new LibraryManagementMenu();
            default:
                new LibraryManagementMenu();
        }
    }
}