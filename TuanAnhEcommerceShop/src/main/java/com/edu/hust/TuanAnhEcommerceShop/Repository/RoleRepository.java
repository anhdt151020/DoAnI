package com.edu.hust.TuanAnhEcommerceShop.Repository;

import com.edu.hust.TuanAnhEcommerceShop.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
