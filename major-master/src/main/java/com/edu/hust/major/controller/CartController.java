package com.edu.hust.major.controller;

import com.edu.hust.major.global.GlobalData;
import com.edu.hust.major.model.Product;
import com.edu.hust.major.service.ProductService;
import com.edu.hust.major.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;
    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("vat",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum() * 1.1);
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }//page cart

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }//click add from page viewProduct

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    } // delete 1 product

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        //model.addAttribute("cart", GlobalData.cart);
        model.addAttribute("vat",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum() * 1.1);
        model.addAttribute("user",userService.getCurrentUserLogin().get());
        return "checkout";
    } // checkout totalPrice
}
