package repository;

import model.Car;
import model.User;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static util.UserQueries.*;

public class CarRepository {

    public Car findCarById(Integer id) {
        Car car = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_CAR_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                car = new Car();
                car.setId(result.getInt(1));
                car.setModel(result.getString(2));
                car.setPower(result.getInt(3));
                car.setOwner(result.getString(4));
                car.setPrice(result.getInt(5));

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return car;
    }


    public void addCar (Car car) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_CAR)) {
            statement.setString(1, car.getModel());
            statement.setInt(2, car.getPower());
            statement.setString(3, car.getOwner());
            statement.setInt(4, car.getPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
