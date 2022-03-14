package main;

import model.AuthenticatedUser;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class Main {

    public static AuthenticatedUser auth = null;

    public static void main(String[] args) {
        System.out.println("Welcome to Bootcamp Library");
        try (Scanner sc = new Scanner(System.in)) {
            char exit;
            do {
                System.out.println("Login");
                System.out.println("E-mail address");
                String email = sc.nextLine();
                System.out.println("Password");
                String password = sc.nextLine();
                if (!email.isEmpty() && !password.isEmpty()) {
                    UserService userService = new UserServiceImpl();
                    userService.loginUser(email, password);
                    if (auth != null) {
                        System.out.println("Welcome " + auth.getName());
                        switch (auth.getRole()) {
                            case "ADMIN":
                                AdminMenu.menu();
                                break;
                            case "SHOP":
                                BusinessMenu.menu();
                                break;
                            case "USER":
                                IndividualMenu.menu();
                                break;
                            default:
                                System.out.println("You don't have permission to access our app");
                                break;
                        }
                        auth = null;
                    } else {
                        System.out.println("Wrong credentials! Try again!");
                    }
                } else {
                    System.out.println("Email and password are required");
                }
                System.out.println("Press Q to exit or any other key to login again");
                exit = sc.nextLine().charAt(0);
            } while (exit != 'Q');
            System.out.println("Thank you for using our library");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
