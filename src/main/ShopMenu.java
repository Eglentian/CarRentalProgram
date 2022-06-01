package main;

import model.Car;
import model.User;
import service.CarService;
import service.CarServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

import static main.AdminMenu.DEFAULT_TEXT;
import static main.AdminMenu.GREEN_TEXT;

public final class ShopMenu {

    private ShopMenu() {
    }

    public static void menu() {
        System.out.println("Shop menu");
        char exit;
        do {
            System.out.println("1) My shop details");
            System.out.println("2) My  list of cars");
            System.out.println("3) Add a new car"); //ok
            System.out.println("4) Set daily price of a listed car");
            System.out.println("5) Car Details");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            CarService carService = new CarServiceImpl();
            switch (menuItem) {
                case 1:
                    System.out.println("Shop Details");
                    break;
                case 2:
                    System.out.println("List of cars");
                    break;
                case 3:
                    System.out.println("Register new car");
                    sc = new Scanner(System.in);
                    CarService carService2 = new CarServiceImpl();
                    Car newCar = new Car();
                    System.out.println("Set model:");
                    newCar.setModel(sc.nextLine());
                    System.out.println("Set power:");
                    newCar.setPower(sc.nextInt());
                    System.out.println("Set Owner:");
                    newCar.setOwner(sc.nextLine());
                    System.out.println("Set Price:");
                    newCar.setPrice(sc.nextInt());
                    System.out.println(newCar);
                    carService2.addCar(newCar);
                    System.out.println(GREEN_TEXT + "New car with model as name (" + newCar.getModel() + ") is added successfully in category 'cars' !" + DEFAULT_TEXT);
                    break;
                case 4:
                    System.out.println("Price of car for a day");
                    break;
                case 5:
                    System.out.println("Details of a car");
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
