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

    //Opskrifter
    //String[] burger = new String[] {"Hakkekød","Ost","Tomater"};
    // String[] koedsovs = new String[] {"Hakkekød","Pasta","Tomater"};

    ArrayList<Opskrifter> listOfOpskrifter = new ArrayList<>();


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


    @GetMapping("/opskrifter")
    public String opskrifter(Model opskriftModel) {
        opskriftModel.addAttribute("opskrift",listOfOpskrifter);
        return "opskrifter";
    }

    @PostMapping("/addOpskrifter")
    public String postOpskrifter() {

        for (Object i : listLager) {
            if (listLager.contains("Hakkekød") || listLager.contains("Pasta") || listLager.contains("Tomater")) {
                Opskrifter pastakoedsovs = new Opskrifter("Pasta med Kødsovs","Koedsovs","dette er en pastaret");
                listOfOpskrifter.add(pastakoedsovs);
            }
            if (listLager.contains("Hakkekød") || listLager.contains("Ost") || listLager.contains("Tomater")) {
                Opskrifter Burger = new Opskrifter("Burger","Burger","burg");
                listOfOpskrifter.add(Burger);
            }
            return "redirect:/opskrifter";
        }
        return "redirect:/";
    }

    @PostMapping("/removeOpskrifter")
    public String removeOpskrifter() {
        listOfOpskrifter.clear();
        return "redirect:/";
    }
}
