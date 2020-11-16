package view;

import controller.UserManagement;

import java.util.Scanner;

public class LoginMenu {
    public LoginMenu() {
        System.out.println("************************");
        System.out.println("1.登录账号");
        System.out.println("2.注册账号");
        Scanner scanner;
        scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        switch (nextInt) {
            case 1:
                for (int i = 0; true; i++) {
                    System.out.println("输入账号");
                    scanner = new Scanner(System.in);
                    int ID = scanner.nextInt();
                    System.out.println("输入密码");
                    scanner = new Scanner(System.in);
                    String password = scanner.next();
                    if (UserManagement.Login(ID, password)) {
                        new Menu();
                        break;
                    } else {
                        if (i == 0) {
                            System.out.println("输入错误，第一次机会");
                        }
                        if (i == 1) {
                            System.out.println("输入错误，第二次机会");
                        }
                        if (i == 2) {
                            System.out.println("三次机会已过，返回登录界面");
                            new LoginMenu();
                        }
                    }
                }
            case 2:
                new UserInputMenu();
        }
    }
}
