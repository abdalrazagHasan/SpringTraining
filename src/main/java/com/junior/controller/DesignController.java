package com.junior.controller;

import com.junior.helper.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Controller
@RequestMapping("/design")
public class DesignController {

    @GetMapping
    public String index(Model model){

        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO","Flour Tortille", Ingredient.Type.WRAP),
                new Ingredient("COTO","Corn Tortille", Ingredient.Type.PROTEIN),
                new Ingredient("GRBF","Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN","Flour Tortille", Ingredient.Type.VEGGIES),
                new Ingredient("TMTO","Flour Tortille", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(), ingredients.stream().filter(s -> s.getType().toString()
                    .equalsIgnoreCase(type.toString())).collect(Collectors.toList()));
        }




        return "designPage";
    }

}
