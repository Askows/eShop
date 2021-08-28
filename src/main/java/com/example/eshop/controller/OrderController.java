package com.example.eshop.controller;

import com.example.eshop.entity.ProductType;
import com.example.eshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class OrderController {

    @Autowired
    OrderRepository orderRepository;


//    @PostMapping("productTypeList/add")
//    public String productAddToOrder(@ModelAttribute ProductType productType, Model model){
//        orderRepository.save();
//        model.addAttribute("types", productTypeRepository.findAll());
//        return "productTypeList";
//    }
}
