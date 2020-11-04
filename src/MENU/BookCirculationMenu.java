package MENU;

import java.util.Scanner;

public class BookCirculationMenu {

    public BookCirculationMenu() {
        System.out.println("1. 借书处理 ");
        System.out.println("2. 还书处理 ");
        System.out.println("3. 借阅信息查询 ");
        System.out.println("0. 返回主菜单 ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                Menu.go();
            case 1:
                new BookCirculationMenu();
            case 2:
                new BookCirculationMenu();
            case 3:
                new BookCirculationMenu();
        }
    }
}