package view;

import java.util.Scanner;

public class BookCirculationQueryMenu {
    public BookCirculationQueryMenu() {
        System.out.println("1. 总借阅信息查询 ");
        System.out.println("2. 流水号借阅信息查询 ");
        System.out.println("3. 用户名借阅信息查询 ");
        System.out.println("4. 书号借阅信息查询 ");
        System.out.println("5. 借还书类型借阅信息查询 ");
        System.out.println("6. 操作人借阅信息查询");
        System.out.println("0. 返回主菜单 ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                new Menu();
            case 1:
                new BookCirculationQueryTotalMenu();
                new BookCirculationQueryMenu();
            case 2:
                new BookCirculationQuerySerialNumberMenu();
                new BookCirculationQueryMenu();
            case 3:
                new BookCirculationQueryIDMenu();
                new BookCirculationQueryMenu();
            case 4:
                new BookCirculationQueryBookNumberMenu();
                new BookCirculationQueryMenu();
            case 5:
                new BookCirculationQueryTypeMenu();
                new BookCirculationQueryMenu();
            case 6:
                new BookCirculationQueryOperatorMenu();
                new BookCirculationQueryMenu();
            default:
                new BookCirculationQueryMenu();
        }
    }
}
