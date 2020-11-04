package MENU;

import java.security.Key;
import java.util.Scanner;

public class Menu {

    public void Menu() {
        new LoginMenu();
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            System.out.println("1.用户管理");
            System.out.println("2.图书管理");
            System.out.println("2.图书流通管理");
            System.out.println("0.退出系统");
            int i = sc.nextInt();
            if (i == 1) {

            } else if (i == 2) {

            } else if (i == 3) {

            } else {
                break;
            }
        }
    }
}