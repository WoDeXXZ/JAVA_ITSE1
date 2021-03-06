package view;

import controller.BookManagement;

import java.util.Scanner;

public class BookDeleteMenu {
    public BookDeleteMenu() {
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int bookNumber = scanner.nextInt();

        while (!BookManagement.JudgmentAccount(bookNumber)) {
            System.out.println("此书号不存在，请输入新的书号");
            System.out.println("或输入0返回主界面");
            scanner = new Scanner(System.in);
            if (scanner.nextInt() == 0) {
                System.out.println("删除图书信息失败");
                new Menu();
                break;
            }
            bookNumber = scanner.nextInt();
        }
        BookManagement.Delete(bookNumber);
        System.out.println("删除图书信息成功");
    }
}
