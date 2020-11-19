package view;

import controller.BookCirculationManagement;
import model.BookCirculation;

import java.util.Scanner;

public class BookCirculationQueryTypeMenu {
    public BookCirculationQueryTypeMenu() {
        Scanner scanner;
        System.out.println("请输入借还书类型");
        scanner = new Scanner(System.in);
        int type = scanner.nextInt();

        if (BookCirculationManagement.QueryType(type).size() != 0) {
            for (BookCirculation bookCirculation :
                    BookCirculationManagement.QueryType(type)) {
                System.out.println(bookCirculation.toString());
            }
        } else {
            System.out.println("没有找到该借还书类型");
        }
    }
}
