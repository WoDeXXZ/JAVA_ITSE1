package view;

import controller.BookCirculationManagement;
import controller.BookManagement;
import controller.UserManagement;

import java.util.Objects;
import java.util.Scanner;

public class BookCirculationBorrowBookMenu {
    public BookCirculationBorrowBookMenu() {
        //检测借书账号
        Scanner scanner;
        System.out.println("请输入借书账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        while (!UserManagement.JudgmentAccount(ID) && Objects.requireNonNull(
                UserManagement.Query(ID)).getCount() != 0) {
            System.out.println("此账号不存在或此账号借书达到最大，请重新输入账号");
            System.out.println("或输入0返回主界面");
            scanner = new Scanner(System.in);
            if (scanner.nextInt() == 0) {
                System.out.println("借书失败");
                new Menu();
                break;
            }
            ID = scanner.nextInt();
        }

        //检测书号是否存在及该书是否被借完
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();

        while (!BookManagement.JudgmentAccount(book_number) &&
                BookManagement.FindAccountReturnCount(book_number) != 0) {
            System.out.println("此书号不存在或此书号的书已借完，请输入新的书号");
            System.out.println("或输入0返回主界面");
            scanner = new Scanner(System.in);
            if (scanner.nextInt() == 0) {
                System.out.println("借书失败");
                new Menu();
                break;
            }
            book_number = scanner.nextInt();
        }

        BookCirculationManagement.BorrowBook(ID, book_number);
    }
}
