package com.example.demo.controllers;

import com.example.demo.models.Lager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Madspildcontroller {
    Lager displayLager = new Lager("");

    @GetMapping("/")
    public String index(Model lagerModel) {
        lagerModel.addAttribute("ingrediens", displayLager);
        return "index";
    }

    @PostMapping("/opskrifter")
    public String postIngredient(WebRequest formData) {
        Lager lager = new Lager(formData.getParameter("ingrediens"));
        displayLager = lager;
        return "redirect:/";
    }
}
