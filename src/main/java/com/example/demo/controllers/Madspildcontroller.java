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
        listOfOpskrifter.clear();
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
            if (listLager.contains("Hakkekød") && listLager.contains("Pasta") && listLager.contains("Tomater")) {
                Opskrifter pastakoedsovs = new Opskrifter("Pasta med Kødsovs","Koedsovs","Lækker pastaret til næsten ingen penge. Kræver kun hakkekød, pasta og tomater");
                listOfOpskrifter.add(pastakoedsovs);
            }
            if (listLager.contains("Hakkekød") && listLager.contains("Ost") && listLager.contains("Grøntsager") && listLager.contains("Brød")) {
                Opskrifter Burger = new Opskrifter("Burger","Burger","Dejlig saftig burger som hele familien kan lide. Kræver kun burgerboller, hakkekød, ost, og overskydende grøntsager i køleskabet");
                listOfOpskrifter.add(Burger);
            }
            if (listLager.contains("Ost") && listLager.contains("brød") && listLager.contains("Smør")) {
                Opskrifter Ostemad = new Opskrifter("Ostemad","Ostemad","Behøver vi virkelig at fortælle dig hvad den her ret består af?");
                listOfOpskrifter.add(Ostemad);
            }
            if (listLager.contains("Ost") && listLager.contains("Hakkekød")) {
                Opskrifter Lasagne = new Opskrifter("Lasagne","Lasagne","Nem og danmarks favoritret, lasagnen kan altid spises!");
                listOfOpskrifter.add(Lasagne);
            }
            if (listLager.contains("Ris") && listLager.contains("Soya")) {
                Opskrifter SoyaRis = new Opskrifter("Ris med Soya", "SoyaRis", "Når pengene er helt i bund, så svigter en skål ris med soya aldrig");
                listOfOpskrifter.add(SoyaRis);
            }
            if (listLager.contains("Ris") && listLager.contains("Kylling") && listLager.contains("Grøntsager")) {
                Opskrifter KyllingRis = new Opskrifter("Kylling med ris", "KyllingRis", "Lækker asiatisk ret med ris, kylling og dine yndlings grøntsager, mums!");
                listOfOpskrifter.add(KyllingRis);
            }
            if (listLager.contains("Kylling") && listLager.contains("Kartofler") && listLager.contains("Grøntsager")) {
                Opskrifter KyllingKartofler = new Opskrifter("Kylling med kartofler", "KyllingKartofler", "En klassiker som alle kan lide, tilføj din favorit grøntsager samt krydderier til kyllingen!");
                listOfOpskrifter.add(KyllingKartofler);
            }
            if (listLager.contains("Hakkekød") && listLager.contains("Kartofler")) {
                Opskrifter Hakkedreng = new Opskrifter("Dansk Hakkebøf", "Hakkedreng", "En solid Hakkebøf med kartofler fejler sku aldrig, det må man godt ;)");
                listOfOpskrifter.add(Hakkedreng);
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
