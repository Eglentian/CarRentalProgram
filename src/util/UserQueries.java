package util;

public final class UserQueries {
    private UserQueries() {
    }

    public static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String LOGIN_USER = "SELECT name, email, role, id FROM users WHERE email = ? AND password = ?";
    public static final String FIND_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
    public static final String FIND_SHOP_BY_ID = "SELECT * FROM shops WHERE id = ?";
    public static final String INSERT_NEW_USER = "INSERT INTO `library`.`users` ( `name`, `role`, `email`, `password`) VALUES (?,?,?,?)";
    public static final String INSERT_NEW_CAR = "INSERT INTO `library`.`cars` ( `model`, `power`, `owner`, `price`) VALUES (?,?,?,?)";
    public static final String INSERT_NEW_SHOP = "INSERT INTO `library`.`shops` ( `name`, `role`, `email`, `password`) VALUES (?,?,?,?)";
    public static final String GET_ALL_USERS = "SELECT * FROM users";
    public static final String GET_ALL_SHOPS = "SELECT * FROM shops";
    public static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    public static final String DELETE_SHOP = "DELETE FROM shops WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE `library`.`users` SET `name` = '?', `email` = '?', `password` = '?' WHERE (`id` = '?') VALUES(?,?,?,?)";


}
