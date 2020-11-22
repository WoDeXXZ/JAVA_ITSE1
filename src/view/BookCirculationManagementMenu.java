package view;

import java.util.Scanner;

public class BookCirculationManagementMenu {
    public BookCirculationManagementMenu() {
        System.out.println("1. 借书处理 ");
        System.out.println("2. 还书处理 ");
        System.out.println("3. 借阅信息查询 ");
        System.out.println("0. 返回主菜单 ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                new Menu();
            case 1:
                new BookCirculationBorrowBookMenu();
                new BookCirculationManagementMenu();
            case 2:
                new BookCirculationReturnBookMenu();
                new BookCirculationManagementMenu();
            case 3:
                new BookCirculationQueryMenu();
                new BookCirculationManagementMenu();
            default:
                new BookCirculationManagementMenu();
        }
    }
}