package view;

import controller.BookCirculationManagement;

import java.util.Scanner;

public class BookCirculationReturnBookMenu {
    public BookCirculationReturnBookMenu() {
        //检测流水号
        Scanner scanner;
        System.out.println("请输入流水号");
        scanner = new Scanner(System.in);
        int serialNumber = scanner.nextInt();

        while (BookCirculationManagement.JudgmentSerialNumber(serialNumber)) {
            System.out.println("此流水号不存在，请重新输入流水号");
            System.out.println("或输入0返回主界面");
            scanner = new Scanner(System.in);
            if (scanner.nextInt() == 0) {
                System.out.println("还书失败");
                new Menu();
                break;
            }
            serialNumber = scanner.nextInt();
        }

        BookCirculationManagement.ReturnBook(serialNumber);
    }
}
