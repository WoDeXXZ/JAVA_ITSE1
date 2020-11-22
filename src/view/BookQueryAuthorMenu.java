package view;

import controller.BookManagement;

import java.util.Scanner;

public class BookQueryAuthorMenu {
    public BookQueryAuthorMenu() {
        Scanner scanner;
        System.out.println("请输入作者");
        scanner = new Scanner(System.in);
        String author = scanner.next();

        if (BookManagement.QueryAuthor(author) != null) {
            System.out.println(BookManagement.QueryAuthor(author));
            System.out.println("查询图书信息成功");
        } else {
            System.out.println("查询图书信息失败");
            new BookQueryMenu();
        }
    }
}
