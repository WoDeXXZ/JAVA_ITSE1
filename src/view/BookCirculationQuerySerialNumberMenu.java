package view;

import controller.BookCirculationManagement;

import java.util.Scanner;

public class BookCirculationQuerySerialNumberMenu {
    public BookCirculationQuerySerialNumberMenu() {
        Scanner scanner;
        System.out.println("请输入流水号");
        scanner = new Scanner(System.in);
        int serialNumber = scanner.nextInt();

        if (BookCirculationManagement.QuerySerialNumber(serialNumber) != null) {
            System.out.println(BookCirculationManagement.QuerySerialNumber(serialNumber));
        } else {
            System.out.println("没有找到流水号");
        }
    }
}
