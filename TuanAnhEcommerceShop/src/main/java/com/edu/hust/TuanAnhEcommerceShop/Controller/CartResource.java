package com.edu.hust.TuanAnhEcommerceShop.Controller;

import com.edu.hust.TuanAnhEcommerceShop.GlobalVariable.GlobalVariable;
import com.edu.hust.TuanAnhEcommerceShop.Model.Product;
import com.edu.hust.TuanAnhEcommerceShop.Service.ProductService;
import com.edu.hust.TuanAnhEcommerceShop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartResource {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;
    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalVariable.cart.size());
        model.addAttribute("total", GlobalVariable.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("vat", GlobalVariable.cart.stream().mapToDouble(Product::getPrice).sum() * 1.1);
        model.addAttribute("cart", GlobalVariable.cart);
        return "cart";
    }//page cart

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        GlobalVariable.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }//click add from page viewProduct

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalVariable.cart.remove(index);
        return "redirect:/cart";
    } // delete 1 product

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("cartCount", GlobalVariable.cart.size());
        model.addAttribute("total", GlobalVariable.cart.stream().mapToDouble(Product::getPrice).sum());
        //model.addAttribute("cart", GlobalData.cart);
        model.addAttribute("vat", GlobalVariable.cart.stream().mapToDouble(Product::getPrice).sum() * 1.1);
        model.addAttribute("user",userService.getCurrentUserLogin().get());
        return "checkout";
    } // checkout totalPrice
}
