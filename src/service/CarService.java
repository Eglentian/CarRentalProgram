package service;

import model.Car;

import java.util.List;

public interface CarService {

    void addCar(Car car);

    Car updateCar(Car car);

    boolean deleteCar(Integer id);

    Car getCarById(Integer id);

    List<Car> getAllCars();

}
