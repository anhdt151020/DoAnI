package com.edu.hust.TuanAnhEcommerceShop.Repository;

import com.edu.hust.TuanAnhEcommerceShop.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);

}
