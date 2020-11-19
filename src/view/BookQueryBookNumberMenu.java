package view;

import controller.BookManagement;

import java.util.Scanner;

public class BookQueryBookNumberMenu {

    public BookQueryBookNumberMenu() {
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();

        if (BookManagement.QueryBookNumber(book_number) != null) {
            System.out.println(BookManagement.QueryBookNumber(book_number));
            System.out.println("查询图书信息成功");
        } else {
            System.out.println("查询图书信息失败");
            new BookQueryMenu();
        }
    }
}
