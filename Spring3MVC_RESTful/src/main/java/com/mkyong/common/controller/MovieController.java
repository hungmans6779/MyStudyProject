package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Restful �Ѿ\���
 * http://www.mkyong.com/spring-mvc/spring-3-rest-hello-world-example/
 * 
 * http://jackyrong.iteye.com/blog/1806326
 * 
 */

@Controller
@RequestMapping("/movie01")
public class MovieController {

  
  // @PathVariable �@��Ϊk
  /*
  @RequestMapping(value="/{movieName}",method = RequestMethod.GET)
  public String getMovie(@PathVariable String movieName,ModelMap model){       
    model.addAttribute("movieName",movieName);  // �q�v�W��

    return "list";
  } // end getMovie
  */
  
  
  
  // @PathVariable ��ΧO�W���覡
  @RequestMapping(value="/{movieName}",method = RequestMethod.GET)
  public String getMovie(@PathVariable("movieName") String aliasesMovieName,ModelMap model){
    
    System.out.println(MovieController.class.getName()+",  getMovie Method ...");
    System.out.println("aliasesMovieName = " + aliasesMovieName);
    
    
    model.addAttribute("movieName",aliasesMovieName); // �q�v�W��
    
    
    return "list";
  } // end getMovie
  
  
  
}
