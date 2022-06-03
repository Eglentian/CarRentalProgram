package service;

import main.Main;
import model.User;
import repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepository();

    @Override
    public void addUser(User user) {
        userRepository.createUser(user);

    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void loginUser(String email, String password) {
        Main.authUser = userRepository.loginUser(email, password);
    }
}
