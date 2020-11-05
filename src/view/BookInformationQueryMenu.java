package view;

import java.util.Scanner;

public class BookInformationQueryMenu {
    public BookInformationQueryMenu() {
        System.out.println("1. 按书号查询 ");
        System.out.println("2. 按书名查询 ");
        System.out.println("3. 按作者查询 ");
        System.out.println("0. 返回主菜单 ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                new Menu();
            case 1:
                new BookInformationQueryMenu();
            case 2:
                new BookInformationQueryMenu();
            case 3:
                new BookInformationQueryMenu();
            default:
                new BookInformationQueryMenu();
        }
    }
}
