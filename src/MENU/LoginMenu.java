package MENU;

import java.util.Scanner;

public class LoginMenu {
    public LoginMenu() {
        for (int i = 0; i < 3; i++) {
            System.out.println("输入账号");
            Scanner sc1 = new Scanner(System.in);
            int ID = sc1.nextInt();
            System.out.println("输入密码");
            Scanner sc2 = new Scanner(System.in);
            String password = sc2.next();
            i++;
        }
    }
}
