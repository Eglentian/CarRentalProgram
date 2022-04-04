package service;

import model.AuthenticatedUser;
import model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    boolean updateUser(Integer id);

    boolean deleteUser(Integer id);

    User getUserById(Integer id);

    List<User> getAllUsers();

    void loginUser(String email, String password);

}
