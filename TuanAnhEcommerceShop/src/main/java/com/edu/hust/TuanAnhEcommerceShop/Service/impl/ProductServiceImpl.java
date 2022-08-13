package com.edu.hust.TuanAnhEcommerceShop.Service.impl;

import com.edu.hust.TuanAnhEcommerceShop.Model.Product;
import com.edu.hust.TuanAnhEcommerceShop.Repository.ProductRepository;
import com.edu.hust.TuanAnhEcommerceShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }//findAll

    public void updateProduct(Product product) {
        productRepository.save(product);
    }//add or update (tuy vao pri-key)

    public void removeProductById(long id) {
        productRepository.deleteById(id);
    }//delete dua vao pri-key

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }//search theo id

    public List<Product> getAllProductByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

    @Override
    public List<Product> getAllProductByContainingName(String name) {
        return productRepository.findByNameContaining(name);
    }
    //findList theo ProductDTO.categoryId

}
