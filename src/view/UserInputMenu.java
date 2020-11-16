package view;

import controller.UserManagement;

import java.util.Scanner;

public class UserInputMenu {
    public UserInputMenu() {
        Scanner scanner;
        System.out.println("请输入账号类型");
        scanner = new Scanner(System.in);
        int type = scanner.nextInt();

        System.out.println("请输入账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        while (UserManagement.FindAccount(ID)) {
            System.out.println("此账号已存在，请输入新的账号");
            System.out.println("或输入0返回主界面");
            scanner = new Scanner(System.in);
            if (scanner.nextInt() == 0) {
                System.out.println("录入用户信息失败");
                new Menu();
                break;
            }
            ID = scanner.nextInt();
        }

        System.out.println("请输入密码");
        scanner = new Scanner(System.in);
        String password = scanner.next();

        System.out.println("请输入姓名");
        scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println("请输入单位");
        scanner = new Scanner(System.in);
        String unit = scanner.next();

        System.out.println("请输入电话");
        scanner = new Scanner(System.in);
        int telephone = scanner.nextInt();

        System.out.println("请输入可借书数");
        scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        UserManagement.Input(type, ID, password, name, unit, telephone, count);
        System.out.println("录入用户信息成功");
        new UserManagementMenu();
    }
}
