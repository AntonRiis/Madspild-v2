package com.example.demo.controllers;

import com.example.demo.models.Opskrifter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class Madspildcontroller {

    ArrayList<String> listLager = new ArrayList<>();
    ArrayList<String> koedsovs = new ArrayList<>();
    ArrayList<String> burger = new ArrayList<>();

    @GetMapping("/")
    public String index(Model lagerModel) {
        lagerModel.addAttribute("ingrediens", listLager);
        return "index";
    }

    @PostMapping("/lager")
    public String postIngredient(WebRequest formData) {
        String lager = formData.getParameter("ingrediens");
        listLager.add(lager);
        return "redirect:/";
    }

    @PostMapping("/removeLastFromLager")
    public String removeLast(WebRequest formData) {
        listLager.remove(listLager.size()-1);
        return "redirect:/";
    }

    @PostMapping("/opskrifter")
    public String postOpskrifter(Model opskriftModel) {
        koedsovs.add("Hakkekød");
        koedsovs.add("Pasta");
        koedsovs.add("Tomater");
        burger.add("Hakkekød");
        burger.add("Ost");
        burger.add("Tomater");

        for (Object i : listLager) {
            if (listLager.contains("Hakkekød") || listLager.contains("Pasta") || listLager.contains("Tomater")) {
                opskriftModel.addAttribute("kødsovs", koedsovs);
                return "opskrifter";
            }
            if (listLager.contains("Hakkekød") || listLager.contains("Ost") || listLager.contains("Tomater")) {
                return "opskrifter";
            }
            return "redirect:/";
        }
        return "redirect:/";
    }
}
