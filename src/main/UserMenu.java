package main;

import java.util.Scanner;

import static main.Main.authUser;

public final class UserMenu {

    private UserMenu() {
    }

    public static void menu() {
        System.out.println("User menu");
        char exit;
        do {
            System.out.println("1) My details");
            System.out.println("2) Rent a car");
            System.out.println("3) List all cars");
            System.out.println("4) See specific car parameters");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("User details");
                    System.out.println(authUser);
                    break;
                case 2:
                    System.out.println("Rent a car");
                    break;
                case 3:
                    System.out.println("List all cars");
                    break;
                case 4:
                    System.out.println("See specific car parameters");
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
