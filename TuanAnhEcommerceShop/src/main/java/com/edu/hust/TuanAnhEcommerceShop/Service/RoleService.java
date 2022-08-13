package com.edu.hust.TuanAnhEcommerceShop.Service;

import com.edu.hust.TuanAnhEcommerceShop.Model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService  {
    List<Role> getAllRole();
    Optional<Role> findRoleById(int id);

}
