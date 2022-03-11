package main;

import java.util.Scanner;

public final class LibrarianMenu {

    private LibrarianMenu() {
    }

    public static void menu() {
        System.out.println("Librarian menu");
        char exit;
        do {
            System.out.println("1) Register new user");
            System.out.println("2) Add a new book");
            System.out.println("3) List all books");
            System.out.println("4) List of borrowed books");
            System.out.println("5) Book details");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
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
