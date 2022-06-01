package service;

import model.Car;
import repository.CarRepository;

import java.util.Collections;
import java.util.List;

public class CarServiceImpl implements CarService {

    CarRepository carRepository = new CarRepository();

    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public boolean deleteCar(Integer id) {
        return false;
    }

    @Override
    public Car getCarById(Integer id) {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return Collections.emptyList();
    }

}
