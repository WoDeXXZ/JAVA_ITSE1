package view;

import controller.BookManagement;

import java.util.Scanner;

public class BookQueryTitleMenu {
    public BookQueryTitleMenu() {
        Scanner scanner;
        System.out.println("请输入书名");
        scanner = new Scanner(System.in);
        String title = scanner.next();

        if (BookManagement.QueryTitle(title) != null) {
            System.out.println(BookManagement.QueryTitle(title));
            System.out.println("查询图书信息成功");
        } else {
            System.out.println("查询图书信息失败");
            new BookQueryMenu();
        }
    }
}
