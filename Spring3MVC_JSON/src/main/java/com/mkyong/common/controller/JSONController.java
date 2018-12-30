package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mkyong.common.model.Shop;

@Controller
@RequestMapping("/kfc/brands")
public class JSONController {


  @RequestMapping(value = "{name}", method = RequestMethod.GET)
  public @ResponseBody Shop getShopInJson(@PathVariable String name) {
    System.out.println(JSONController.class.getName() + ", getShopInJson Method ...");

    Shop shop = new Shop();
    shop.setName(name);
    shop.setStaffName(new String[] {"kevin-1", "kevin-22"});


    return shop;
  } // end  getShopInJson



}
