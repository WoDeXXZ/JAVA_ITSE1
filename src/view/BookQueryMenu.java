package view;

import java.util.Scanner;

public class BookQueryMenu {
    public BookQueryMenu() {
        System.out.println("1. 按书号查询 ");
        System.out.println("2. 按书名查询 ");
        System.out.println("3. 按作者查询 ");
        System.out.println("0. 返回主菜单 ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                new Menu();
            case 1:
                new BookQueryBookNumberMenu();
                new BookQueryMenu();
            case 2:
                new BookQueryTitleMenu();
                new BookQueryMenu();
            case 3:
                new BookQueryAuthorMenu();
                new BookQueryMenu();
            default:
                new BookQueryMenu();
        }
    }
}
