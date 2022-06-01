package util;

public final class UserQueries {
    private UserQueries() {
    }


    //login
    public static final String LOGIN_USER = "SELECT name, email, role, id FROM users WHERE email = ? AND password = ?";

    //find
    public static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String FIND_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
    public static final String FIND_SHOP_BY_ID = "SELECT * FROM shops WHERE id = ?";

    //insert
    public static final String INSERT_NEW_USER = "INSERT INTO `rental`.`users` ( `name`, `role`, `email`, `password`) VALUES (?,?,?,?)";
    public static final String INSERT_NEW_CAR = "INSERT INTO `rental`.`cars` ( `model`, `power`, `owner`, `price`) VALUES (?,?,?,?)";
    public static final String INSERT_NEW_SHOP = "INSERT INTO `rental`.`shops` ( `name`, `role`, `email`, `password`) VALUES (?,?,?,?)";

    //get List
    public static final String GET_ALL_USERS = "SELECT * FROM users";
    public static final String GET_ALL_SHOPS = "SELECT * FROM shops";
    public static final String GET_ALL_CARS = "SELECT * FROM cars";

    //delete
    public static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    public static final String DELETE_SHOP = "DELETE FROM shops WHERE id = ?";
    public static final String DELETE_CAR = "DELETE FROM cars WHERE id = ?";

    //update
    public static final String UPDATE_USER = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
    public static final String UPDATE_SHOP = "UPDATE shops SET name = ?, email = ?, password = ? WHERE id = ?";


}
