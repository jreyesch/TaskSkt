package com.nearsoft.exercise.pinstore.controller;

import com.nearsoft.exercise.pinstore.model.Item;
import com.nearsoft.exercise.pinstore.service.ListAllItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ListAllItemsController {

    @Autowired
    private ListAllItemsService listService;

    @Autowired
    private List<Item> returnList;

    @GetMapping("/listallitems")
    public String listAllItems(ModelMap model){
        returnList = listService.findaAll();
        model.addAttribute("list", returnList);
        return "listallitems";
    }
}
