package main;

import model.AuthenticatedUser;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class Main {

    public static AuthenticatedUser authUser = null;
    public static final String GREEN_TEXT = "\u001B[32;1m";
    public static final String DEFAULT_TEXT = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("Welcome to Car Rental Platform");
        try (Scanner sc = new Scanner(System.in)) {
            char exit;
            do {
                System.out.println("Please login");
                System.out.println("Enter your E-mail address");
                String email = sc.nextLine();
                System.out.println("Enter your Password");
                String password = sc.nextLine();
                if (!email.isEmpty() && !password.isEmpty()) {
                    UserService userService = new UserServiceImpl();
                    userService.loginUser(email, password);
                    if (authUser != null) {
                        System.out.println(GREEN_TEXT + "Login Successful !" + DEFAULT_TEXT);
                        System.out.println("----------- \n Welcome " + authUser.getName());
                        switch (authUser.getRole()) {
                            case "admin":
                                AdminMenu.menu();
                                break;
                            case "shop":
                                ShopMenu.menu();
                                break;
                            case "user":
                                UserMenu.menu();
                                break;
                            default:
                                System.out.println("You don't have permission to access our app");
                                break;
                        }
                        authUser = null;
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
