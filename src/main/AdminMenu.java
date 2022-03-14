package main;

import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public final class AdminMenu {

    private AdminMenu() {
    }

    public static void menu() {
        System.out.println("Admin menu");
        char exit;
        do {
            System.out.println("1) Register new shop");
            System.out.println("2) Register a new individual");
            System.out.println("3) List all users");
            System.out.println("4) List of all cars");
            System.out.println("5) Car Details");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    UserService userService = new UserServiceImpl();
                    System.out.println("User details");
                    break;
                case 2:
                    System.out.println("New book");
                    break;
                case 3:
                    System.out.println("All books");
                    break;
                case 4:
                    System.out.println("Borrowed books");
                    break;
                case 5:
                    System.out.println("Details");
                    break;
                default:
                    System.out.println("Didn't understand that");
                    break;
            }
            System.out.println("Press Q to logout or any other key to continue");
            sc.nextLine();
            exit = sc.nextLine().charAt(0);
        } while (exit != 'Q');
    }
}
