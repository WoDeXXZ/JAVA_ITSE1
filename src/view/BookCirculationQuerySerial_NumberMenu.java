package view;

import controller.BookCirculationManagement;

import java.util.Scanner;

public class BookCirculationQuerySerial_NumberMenu {
    public BookCirculationQuerySerial_NumberMenu() {
        Scanner scanner;
        System.out.println("请输入流水号");
        scanner = new Scanner(System.in);
        int serial_number = scanner.nextInt();

        if (BookCirculationManagement.QuerySerial_Number(serial_number) != null) {
            System.out.println(BookCirculationManagement.QuerySerial_Number(serial_number));
        } else {
            System.out.println("没有找到流水号");
        }
    }
}
