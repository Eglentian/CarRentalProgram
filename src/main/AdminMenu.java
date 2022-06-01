package main;

import model.Shop;
import model.User;
import service.ShopService;
import service.ShopServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public final class AdminMenu {

    private AdminMenu() {
    }
    public static final String GREEN_TEXT = "\u001B[32;1m";
    public static final String DEFAULT_TEXT = "\u001B[0m";
    public static void menu() {
        System.out.println("Admin menu");
        char exit;
        do {
            System.out.println("1) Register a new shop"); //ok
            System.out.println("2) Register a new user"); //ok
            System.out.println("3) List of all users"); //ok
            System.out.println("4) List of all shops"); //ok
            System.out.println("5) See any user details"); //ok
            System.out.println("6) See any shop details"); //ok
            System.out.println("7) Update an existing user");// ok
            System.out.println("8) Update an existing shop");//TO BE IMPLEMENTED
            System.out.println("9) Delete an existing user"); //ok
            System.out.println("10) Delete an existing shop"); //ok

            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            UserService userService = new UserServiceImpl();
            ShopService shopService = new ShopServiceImpl();
            switch (menuItem) {
                case 1:
                    System.out.println("Register new shop");
                    sc = new Scanner(System.in);
                    ShopService shopService1 = new ShopServiceImpl();
                    Shop newShop = new Shop();
                    System.out.println("Set name of the shop:");
                    newShop.setName(sc.nextLine());
                    newShop.setRole("shop");
                    System.out.println("Set email:");
                    newShop.setEmail(sc.nextLine());
                    System.out.println("Set Password:");
                    newShop.setPassword(sc.nextLine());
                    System.out.println(newShop);
                    shopService1.addShop(newShop);
                    System.out.println(GREEN_TEXT + "New shop with name (" + newShop.getName() + ") is added successfully in category 'shops' !" + DEFAULT_TEXT);
                    break;

                    case 2:
                    System.out.println("Register new user");
                    sc = new Scanner(System.in);
                    UserService userService2 = new UserServiceImpl();
                    User newUser = new User();
                    System.out.println("Set name:");
                    newUser.setName(sc.nextLine());
                    newUser.setRole("user");
                    System.out.println("Set email:");
                    newUser.setEmail(sc.nextLine());
                    System.out.println("Set Password:");
                    newUser.setPassword(sc.nextLine());
                    System.out.println(newUser);
                    userService2.addUser(newUser);
                    System.out.println(GREEN_TEXT + "New user with name (" + newUser.getName() + ") is added successfully in category 'users' !" + DEFAULT_TEXT);
                    break;
                case 3:
                    System.out.println("List all users");
                    List<User> resultUser = userService.getAllUsers();
                    for (User user : resultUser){
                        System.out.println(user);
                    }
                    break;
                case 4:
                    System.out.println("List all shops");
                    List<Shop> resultShop = shopService.getAllShops();
                    for (Shop shop : resultShop){
                        System.out.println(shop);
                    }
                    break;
                case 5:
                    System.out.println("Details of a user");
                    System.out.println("Here is a List of all users with ID");
                    List<User> result1 = userService.getAllUsers();
                    for (User user : result1){
                        System.out.println(user);
                    }
                    System.out.println("Enter ID of the user you are interested in :");
                    int userID = sc.nextInt();
                    User user = userService.getUserById(userID);
                    System.out.println(GREEN_TEXT + "Selected user is : " + user + " (Password is : " + user.getPassword() + ")" + DEFAULT_TEXT);
                    break;
                case 6:
                    System.out.println("Details of a shop");
                    System.out.println("Here is a List of all shops with ID");
                    List<Shop> resultList = shopService.getAllShops();
                    for (Shop shop : resultList){
                        System.out.println(shop);
                    }
                    System.out.println("Enter ID of the shop you are interested in :");
                    int shopID = sc.nextInt();
                    Shop shop = shopService.getShopById(shopID);
                    System.out.println(GREEN_TEXT + "Selected shop is : " + shop + " (Password is : " + shop.getPassword() + ")" + DEFAULT_TEXT);
                    break;
                case 7:
                    sc = new Scanner(System.in);
                    System.out.println("Update an existing user");
                    System.out.println("Here is a List of all users with ID");
                    List<User> usersList1 = userService.getAllUsers();
                    for (User updateUser : usersList1){
                        System.out.println(updateUser);
                    }
                    System.out.println("Set an ID of the user you want to update: ");
                    int userToUpdate = sc.nextInt();
                    UserService userService3 = new UserServiceImpl();
                    User user1 = userService.getUserById(userToUpdate);
                    sc = new Scanner(System.in);
                    System.out.println("Set new name:");
                    user1.setName(sc.nextLine());
                    System.out.println("Set new email:");
                    user1.setEmail(sc.nextLine());
                    System.out.println("Set new password:");
                    user1.setPassword(sc.nextLine());
                    System.out.println(user1);
                    userService3.updateUser(userToUpdate);
                    System.out.println("User updated successfully !");
                    break;
                case 8:
                    sc = new Scanner(System.in);
                    System.out.println("Update an existing shop");
                    System.out.println("Here is a List of all shops with ID");
                    List<Shop> shopsList1 = shopService.getAllShops();
                    for (Shop updateShop : shopsList1){
                        System.out.println(updateShop);
                    }
                    System.out.println("Set an ID of the shop you want to update: ");
                    int shopToUpdate = sc.nextInt();
                    ShopService shopService3 = new ShopServiceImpl();
                    Shop shop1 = shopService.getShopById(shopToUpdate);
                    sc = new Scanner(System.in);
                    System.out.println("Set new name:");
                    shop1.setName(sc.nextLine());
                    System.out.println("Set new email:");
                    shop1.setEmail(sc.nextLine());
                    System.out.println("Set new password:");
                    shop1.setPassword(sc.nextLine());
                    System.out.println(shop1);
                    shopService3.updateShop(shopToUpdate);
                    System.out.println("Shop updated successfully !");
                    break;



                case 9:
                    System.out.println("Delete an existing user");
                    System.out.println("Here is a List of all users with ID");
                    List<User> usersList = userService.getAllUsers();
                    for (User deleteUser : usersList){
                        System.out.println(deleteUser);
                    }
                    System.out.println("Enter ID of the user you want to delete :");
                    int userToDelete = sc.nextInt();
                    userService.deleteUser(userToDelete);
                    System.out.println("User deleted successfully !");
                    break;
                case 10:
                    System.out.println("Delete an existing shop");
                    System.out.println("Here is a List of all shops with ID");
                    List<Shop> shopsList = shopService.getAllShops();
                    for (Shop deleteShop : shopsList){
                        System.out.println(deleteShop);
                    }
                    System.out.println("Enter ID of the shop you want to delete :");
                    int shopToDelete = sc.nextInt();
                    shopService.deleteShop(shopToDelete);
                    System.out.println("Shop deleted successfully !");
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
