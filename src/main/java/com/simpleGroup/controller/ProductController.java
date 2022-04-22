package com.simpleGroup.controller;

import com.simpleGroup.dao.ProductDAO;
import com.simpleGroup.entity.Product;
import com.simpleGroup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String showAllProducts(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        return "view";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping("/saveOrUpdateProduct")
    public String saveOrUpdateProduct(@ModelAttribute("product") Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestParam("productId") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
