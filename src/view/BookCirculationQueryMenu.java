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
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                new Menu();
            case 1:
                new BookCirculationQueryTotalMenu();
            case 2:
                new BookCirculationQuerySerial_NumberMenu();
            case 3:
                new BookCirculationQueryIDMenu();
            case 4:
                new BookCirculationQueryBook_NumberMenu();
            case 5:
                new BookCirculationQueryTypeMenu();
            case 6:
                new BookCirculationQueryOperatorMenu();
            default:
                new BookCirculationQueryMenu();
        }
    }
}
