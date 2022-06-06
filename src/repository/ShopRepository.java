package repository;

import model.AuthenticatedUser;
import model.*;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.UserQueries.*;

public class ShopRepository {

    public Shop findShopById(Integer id) {
        Shop shop = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_SHOP_BY_ID);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                shop = new Shop();
                shop.setId(result.getInt(1));
                shop.setName(result.getString(2));
                shop.setRole(result.getString(3));
                shop.setEmail(result.getString(4));
                shop.setPassword(result.getString(5));
                statement.executeQuery();

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return shop;
    }


    public void createShop(Shop shop) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_SHOP)) {
            statement.setString(1, shop.getName());
            statement.setString(2, shop.getRole());
            statement.setString(3, shop.getEmail());
            statement.setString(4, shop.getPassword());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AuthenticatedUser loginUser(String email, String password) {
        AuthenticatedUser authUser = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(LOGIN_USER);) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                authUser = new AuthenticatedUser();
                authUser.setName(result.getString(1));
                authUser.setEmail(result.getString(2));
                authUser.setRole(result.getString(3));
                authUser.setId(result.getInt(4));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return authUser;
    }
    public List<Shop> getAllShops () {
        List<Shop> allShops = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_SHOPS);) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Shop newShop = new Shop();
                newShop.setId(result.getInt("id"));
                newShop.setName(result.getString("name"));
                newShop.setRole(result.getString("role"));
                newShop.setEmail(result.getString("email"));
                newShop.setPassword(result.getString("password"));
                allShops.add(newShop);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return allShops;
    }

    public boolean deleteShop (Integer id) {
        Shop shop = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SHOP)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } return true;
    }

    public boolean updateShop(Shop shop) {

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SHOP)) {
            statement.setString(1, shop.getName());
            statement.setString(2 , shop.getEmail());
            statement.setString(3, shop.getPassword());
            statement.setInt(4, shop.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
