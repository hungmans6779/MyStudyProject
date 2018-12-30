package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Restful 參閱文件
 * http://www.mkyong.com/spring-mvc/spring-3-rest-hello-world-example/
 * 
 * http://jackyrong.iteye.com/blog/1806326
 * 
 */

@Controller
@RequestMapping("/movie01")
public class MovieController {

  
  // @PathVariable 一般用法
  /*
  @RequestMapping(value="/{movieName}",method = RequestMethod.GET)
  public String getMovie(@PathVariable String movieName,ModelMap model){       
    model.addAttribute("movieName",movieName);  // 電影名稱

    return "list";
  } // end getMovie
  */
  
  
  
  // @PathVariable 改用別名的方式
  @RequestMapping(value="/{movieName}",method = RequestMethod.GET)
  public String getMovie(@PathVariable("movieName") String aliasesMovieName,ModelMap model){
    
    System.out.println(MovieController.class.getName()+",  getMovie Method ...");
    System.out.println("aliasesMovieName = " + aliasesMovieName);
    
    
    model.addAttribute("movieName",aliasesMovieName); // 電影名稱
    
    
    return "list";
  } // end getMovie
  
  
  
}
