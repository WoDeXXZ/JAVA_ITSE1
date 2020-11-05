package view;

import controller.UserManagement;

public class LoginMenu {
    public LoginMenu() {
        System.out.println("************************");
        System.out.println("请登录");
        if (UserManagement.Login()) {
            new Menu();
        } else {
            new LoginMenu();
        }
    }
}
