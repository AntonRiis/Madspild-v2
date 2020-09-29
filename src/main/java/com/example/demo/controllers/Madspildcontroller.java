package com.example.demo.controllers;

import com.example.demo.models.Lager;
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

    @PostMapping("/opskrifter")
    public String postOpskrifter(ArrayList listLager) {
        Opskrifter koedsovs = new Opskrifter("hakkekød","pasta","tomat","","");

        for(Object i: listLager) {
            if (i.equals(koedsovs.getIngrediens1())) {
                return "pasta med kødsovs, mums";
            }
            return "ups";
        }
        return "ups";

    }
}
