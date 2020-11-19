package view;

import controller.BookManagement;

import java.util.Scanner;

public class BookInputMenu {
    public BookInputMenu() {
        //图书信息录入
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();

        while (BookManagement.JudgmentAccount(book_number)) {
            System.out.println("此书号已存在，请输入新的书号");
            System.out.println("或输入0返回主界面");
            scanner = new Scanner(System.in);
            if (scanner.nextInt() == 0) {
                System.out.println("录入图书信息失败");
                new Menu();
                break;
            }
            book_number = scanner.nextInt();
        }

        System.out.println("请输入书名");
        scanner = new Scanner(System.in);
        String title = scanner.next();

        System.out.println("请输入作者");
        scanner = new Scanner(System.in);
        String author = scanner.next();

        System.out.println("请输入出版社");
        scanner = new Scanner(System.in);
        String press = scanner.next();

        System.out.println("请输入藏书量");
        scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        BookManagement.Input(book_number,title,author,press,count);
        System.out.println("录入图书信息成功");
    }
}
