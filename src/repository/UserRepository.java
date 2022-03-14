package repository;

import model.AuthenticatedUser;
import model.User;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static util.UserQueries.FIND_USER_BY_ID;
import static util.UserQueries.LOGIN_USER;

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

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
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
}
