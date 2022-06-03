package repository;

import model.AuthenticatedUser;
import model.User;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.UserQueries.*;

public class UserRepository {

    public User findUserById(Integer id) {
        User user = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(result.getInt(1));
                user.setName(result.getString(2));
                user.setRole(result.getString(3));
                user.setEmail(result.getString(4));
                user.setPassword(result.getString(5));
                statement.executeQuery();

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }


    public void createUser(User user) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getRole());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AuthenticatedUser loginUser(String email, String password) {
        AuthenticatedUser auth = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(LOGIN_USER);) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                auth = new AuthenticatedUser();
                auth.setName(result.getString(1));
                auth.setEmail(result.getString(2));
                auth.setRole(result.getString(3));
                auth.setId(result.getInt(4));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return auth;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS);) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User newUser = new User();
                newUser.setId(result.getInt("id"));
                newUser.setName(result.getString("name"));
                newUser.setRole(result.getString("role"));
                newUser.setEmail(result.getString("email"));
                newUser.setPassword(result.getString("password"));
                allUsers.add(newUser);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return allUsers;
    }

    public boolean deleteUser(Integer id) {
        User user = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setInt(1, id);
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user) {

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2 , user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}




