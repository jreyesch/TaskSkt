package com.nearsoft.exercise.pinstore.controller;

import com.nearsoft.exercise.pinstore.model.Item;
import com.nearsoft.exercise.pinstore.service.CreateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateItemController {

    @Autowired
    CreateItemService service;

    @GetMapping("/createitem")
    public String createItem(Model model){
        model.addAttribute("item", new Item());
        return "createitem";
    }

    @PostMapping(value="/createitem")
    public String submitNewItem(@ModelAttribute("item") Item item){
        if(service.createItem(item)){
            return "createitem";
        }
        return "error";
    }
}
