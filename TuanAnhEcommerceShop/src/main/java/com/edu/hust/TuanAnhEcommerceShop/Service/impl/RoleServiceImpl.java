package com.edu.hust.TuanAnhEcommerceShop.Service.impl;

import com.edu.hust.TuanAnhEcommerceShop.Model.Role;
import com.edu.hust.TuanAnhEcommerceShop.Repository.RoleRepository;
import com.edu.hust.TuanAnhEcommerceShop.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Optional<Role> findRoleById(int id){
        return roleRepository.findById(id);
    }

}
