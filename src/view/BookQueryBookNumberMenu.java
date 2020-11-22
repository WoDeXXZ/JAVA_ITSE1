package view;

import controller.BookManagement;

import java.util.Scanner;

public class BookQueryBookNumberMenu {
    public BookQueryBookNumberMenu() {
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int bookNumber = scanner.nextInt();

        if (BookManagement.QueryBookNumber(bookNumber) != null) {
            System.out.println(BookManagement.QueryBookNumber(bookNumber));
            System.out.println("查询图书信息成功");
        } else {
            System.out.println("查询图书信息失败");
            new BookQueryMenu();
        }
    }
}
