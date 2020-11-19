package view;

import controller.BookCirculationManagement;
import model.BookCirculation;

import java.util.Scanner;

public class BookCirculationQueryBook_NumberMenu {
    public BookCirculationQueryBook_NumberMenu() {
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();

        if (BookCirculationManagement.QueryBook_Number(book_number).size() != 0) {
            for (BookCirculation bookCirculation :
                    BookCirculationManagement.QueryBook_Number(book_number)) {
                System.out.println(bookCirculation.toString());
            }
        } else {
            System.out.println("没有找到该书号");
        }
    }
}
