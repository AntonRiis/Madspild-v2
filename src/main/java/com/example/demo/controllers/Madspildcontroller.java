package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class Madspildcontroller {

    ArrayList<String> listLager = new ArrayList<>();

    //Opskrifter
    String[] burger = new String[] {"Hakkekød","Ost","Tomater"};
    String[] koedsovs = new String[] {"Hakkekød","Pasta","Tomater"};


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
    public String removeLast() {
        listLager.remove(listLager.size()-1);
        return "redirect:/";
    }

    @PostMapping("/opskrifter")
    public String postOpskrifter() {

        for (Object i : listLager) {
            if (listLager.contains("Hakkekød") || listLager.contains("Pasta") || listLager.contains("Tomater")) {
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
