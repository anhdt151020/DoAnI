package com.edu.hust.TuanAnhEcommerceShop.Service;

import com.edu.hust.TuanAnhEcommerceShop.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
     List<Product> getAllProduct();
     void updateProduct(Product product);
     void removeProductById(long id);
     Optional<Product> getProductById(long id);
     List<Product> getAllProductByCategoryId(int id);

     List<Product> getAllProductByContainingName(String name);
}
