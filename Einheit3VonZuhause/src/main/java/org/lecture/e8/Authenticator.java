package org.lecture.e8;

import java.util.Scanner;

public class Authenticator {
    static Scanner scan = new Scanner(System.in);

    static void main() {

        String username, password;

        System.out.print("Enter your username: ");
        username = scan.nextLine();
        System.out.print("Enter your password: ");
        password = scan.nextLine();

        boolean authenticated = isAuthenticated(username, password);
        System.out.printf("Is valid login: %b", authenticated);

    }

    private static boolean isAuthenticated(String username, String password) {
        if (username.equals("admin") && password.equals("PassWord123!")) { // das wäre entweder oder: (username.equals("admin") ^ password.equals("PassWord123!")
            return true;
        }
        return false;

    }
}
