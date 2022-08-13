package com.edu.hust.TuanAnhEcommerceShop.GlobalVariable;

import com.edu.hust.TuanAnhEcommerceShop.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariable {
    public static List<Product> cart;
    static {
        cart = new ArrayList<>();
    }

}
