package com.nearsoft.exercise.pinstore.controller;

import com.nearsoft.exercise.pinstore.PinStoreApplication;
import com.nearsoft.exercise.pinstore.service.ItemService;
import com.nearsoft.exercise.pinstorecommons.entities.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemService service;

    @Autowired
    PinStoreApplication application;

    @GetMapping("/createitem")
    public String createItem(Model model){
        logger.info("showing creatingItem form");
        model.addAttribute("item", new Item());
        return "createitem";
    }

    @PostMapping("/createitem")
    public String submitNewItem(@ModelAttribute("item") Item item){
        if(service.createSingleItem(item)){
            logger.info("submiting newItem");
            return "createitem";
        }
        logger.error("could not send new Item to queue");
        return "error";
    }

    @GetMapping("/listallitems")
    public String listAllItems(ModelMap model){
        logger.info("Listing all items");
        service.findaAll();
        model.addAttribute("list", application.persistedItems);
        return "listallitems";
    }
}
