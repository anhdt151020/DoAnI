package com.edu.hust.TuanAnhEcommerceShop.Repository;

import com.edu.hust.TuanAnhEcommerceShop.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
