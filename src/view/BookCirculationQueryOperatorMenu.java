package view;

import controller.BookCirculationManagement;
import model.BookCirculation;

import java.util.Scanner;

public class BookCirculationQueryOperatorMenu {
    public BookCirculationQueryOperatorMenu() {
        Scanner scanner;
        System.out.println("请输入借还书类型");
        scanner = new Scanner(System.in);
        int operator = scanner.nextInt();

        if (BookCirculationManagement.QueryOperator(operator).size() != 0) {
            for (BookCirculation bookCirculation :
                    BookCirculationManagement.QueryOperator(operator)) {
                System.out.println(bookCirculation.toString());
            }
        } else {
            System.out.println("没有找到该借还书类型");
        }
    }
}
