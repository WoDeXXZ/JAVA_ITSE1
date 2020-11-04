package MENU;

import USER.UserManagement;

import java.util.Scanner;

public class UserManagementMenu {
    public UserManagementMenu() {
        System.out.println("1. 用户信息录入 ");
        System.out.println("2. 用户信息修改 ");
        System.out.println("3. 用户信息删除 ");
        System.out.println("4. 用户信息查询 ");
        System.out.println("5. 用户密码修改 ");
        System.out.println("0. 返回主菜单 ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                Menu.go();
            case 1:
                UserManagement.input();
                new UserManagementMenu();
            case 2:
                UserManagement.update();
                new UserManagementMenu();
            case 3:
                UserManagement.delete();
                new UserManagementMenu();
            case 4:
                UserManagement.query();
                new UserManagementMenu();
            case 5:
                UserManagement.changePassword();
                new UserManagementMenu();
        }
    }
}
