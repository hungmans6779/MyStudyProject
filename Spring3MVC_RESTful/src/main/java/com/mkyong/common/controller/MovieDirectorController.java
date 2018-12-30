package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 
 * Restful 參閱文件
 * http://www.mkyong.com/spring-mvc/spring-3-rest-hello-world-example/
 * 
 * http://jackyrong.iteye.com/blog/1806326
 * 
 */

@Controller
@RequestMapping("/movie02")
public class MovieDirectorController {

  
 /*
  @RequestMapping(method = RequestMethod.GET)
  public String getMovieDirector(@RequestParam String movieName,@RequestParam String director,ModelMap model){
  
    System.out.println("movieName = " + movieName);
    System.out.println("director  = " + director);
     
    model.addAttribute("movieName",movieName);
    model.addAttribute("director",director);
    
    return "listMovieDirector";
  } // end getMovieDirector
  */
  

  
  @RequestMapping(method = RequestMethod.GET)
  public String getMovieDirector(@RequestParam String movieName,
                                  @RequestParam(defaultValue="自由人") String director,
                                  ModelMap model){
  
    
    System.out.println(MovieDirectorController.class.getName()+", getMovieDirector Method ");
    System.out.println("movieName = " + movieName);
    System.out.println("director  = " + director);
     
    model.addAttribute("movieName",movieName);
    model.addAttribute("director",director);
    
    return "listMovieDirector";
  } // end getMovieDirector
  
  
  
  
  
}
