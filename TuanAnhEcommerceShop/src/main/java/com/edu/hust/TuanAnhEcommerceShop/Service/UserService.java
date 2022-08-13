package com.edu.hust.TuanAnhEcommerceShop.Service;

import com.edu.hust.TuanAnhEcommerceShop.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUser();
    void updateUser(User user);
    void removeUserById(int id);
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);

    Optional<User> getCurrentUserLogin();
}
