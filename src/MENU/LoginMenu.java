package MENU;

import USER.UserManagement;

import java.util.Scanner;

public class LoginMenu {
    public LoginMenu() {
        for (int i = 0; i < 3; i++) {
            Scanner scanner;
            System.out.println("请输入账号类型");
            scanner = new Scanner(System.in);
            int type = scanner.nextInt();

            System.out.println("输入账号");
            scanner = new Scanner(System.in);
            int ID = scanner.nextInt();

            System.out.println("输入密码");
            scanner = new Scanner(System.in);
            String password = scanner.next();
            if (UserManagement.FindAccountPassword(type, ID, password)) {
                break;
            }
            if (i == 0) {
                System.out.println("第一次机会");
            }
            if (i == 1) {
                System.out.println("第二次机会");
            }
            if (i == 2) {
                System.out.println("三次机会已过，返回主界面");
                new Menu();
            }
        }
    }
}
