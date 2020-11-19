package view;

import controller.BookCirculationManagement;
import model.BookCirculation;

public class BookCirculationQueryTotalMenu {
    public BookCirculationQueryTotalMenu() {
        if (BookCirculationManagement.QueryTotal() != null) {
            for (BookCirculation bookCirculation :
                    BookCirculationManagement.QueryTotal()) {
                System.out.println(bookCirculation.toString());
            }
        } else {
            System.out.println("没有找到借阅信息");
        }
    }
}
