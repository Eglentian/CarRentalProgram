package main;

import java.util.Scanner;

public final class IndividualMenu {

    private IndividualMenu() {
    }

    public static void menu() {
        System.out.println("User menu");
        char exit;
        do {
            System.out.println("1) My details");
            System.out.println("2) Borrow a book");
            System.out.println("3) Return a book");
            System.out.println("4) List of borrowed books");
            System.out.println("5) Book details");
            System.out.println("6) All books");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("User details");
                    break;
                case 2:
                    System.out.println("Borrow book");
                    break;
                case 3:
                    System.out.println("Return book");
                    break;
                case 4:
                    System.out.println("My borrowed books");
                    break;
                case 5:
                    System.out.println("Details");
                    break;
                case 6:
                    System.out.println("List");
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
