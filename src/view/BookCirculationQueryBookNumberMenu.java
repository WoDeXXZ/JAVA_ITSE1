package view;

import controller.BookCirculationManagement;
import model.BookCirculation;

import java.util.Scanner;

public class BookCirculationQueryBookNumberMenu {
    public BookCirculationQueryBookNumberMenu() {
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int bookNumber = scanner.nextInt();

        if (BookCirculationManagement.QueryBookNumber(bookNumber).size() != 0) {
            for (BookCirculation bookCirculation :
                    BookCirculationManagement.QueryBookNumber(bookNumber)) {
                System.out.println(bookCirculation.toString());
            }
        } else {
            System.out.println("没有找到该书号");
        }
    }
}
