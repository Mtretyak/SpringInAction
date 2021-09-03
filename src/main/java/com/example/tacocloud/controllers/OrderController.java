package com.example.tacocloud.controllers;

import com.example.tacocloud.data.TacoOrder;
import com.example.tacocloud.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    @Autowired
    OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/current")
    private String orderForm(Model model) {
        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        repository.save(order);
        sessionStatus.setComplete(); // TODO: is it really necessary?

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
