package view;

import controller.BookCirculationManagement;
import model.BookCirculation;

import java.util.Scanner;

public class BookCirculationQueryIDMenu {
    public BookCirculationQueryIDMenu() {
        Scanner scanner;
        System.out.println("请输入用户名");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        if (BookCirculationManagement.QueryID(ID).size() != 0) {
            for (BookCirculation bookCirculation :
                    BookCirculationManagement.QueryID(ID)) {
                System.out.println(bookCirculation.toString());
            }
        } else {
            System.out.println("没有找到该用户名");
        }
    }
}
