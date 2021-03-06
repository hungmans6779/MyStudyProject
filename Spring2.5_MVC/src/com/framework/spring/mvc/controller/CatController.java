package com.framework.spring.mvc.controller;

import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;



import com.framework.spring.orm.entity.Cat;
import com.framework.spring.orm.service.ICatService;



/**
 *  Spring 控制層
 *  
 *  
 *  Spring MVC 裡使用 Controller 處理使用的請求。 
 *  Controller 相當於 Struts1.x 裡的 Action ，它們實現機制、執行原理都類似。
 *  
 *  
 *  Spring MVC 的控制層是 Contoller 。Controller 是個介面，一般直接繼承 org.springframework.web.servlet.mvc.AbstractController，
 *  並實現 handleRequestInternal 方法。 handleRequestInternal 方法相當於 Struts1.x  Action 的 execute() 方法。
 *  
 *  
 *  Spring MVC 的優缺點
 *   
 *  作為 Spring 的一部份，Controller 具有天然的優勢，不需像 Struts1 & 2 的 Action 那樣特意整合就能融入 Spring 程式 Framework 中。
 *  catService 使用 IoC 植入到 Controller 中。 
 *   
 *  handleRequestInternal 方法參數為 request、response ，這樣可以從 request 中獲得資料，跟 Servlet 一樣操作。 
 *  
 *  
 *
 *  
 *  
 *  Spring MVC 獨特的地方在於 View 層的處理上。 handleRequestInternal 傳回 ModelAndView 物件，相當於 Struts1.x 裡的 ActionForward。
 * 
 *  ● ModelAndView：
 *     其可以看做是對JSP 物件的封裝。ModelAndView 直接接受JSP 頁面的路徑，例如 new ModelAndView("cat/list")。
 *     參數 "cat/list" 只是 JSP 路徑的一部份，完整的路徑為 "/WEB-INF/jsp/cat/listCat.jsp" ，路徑的前後部份是設定在設定檔中。 
 *     
 *  ● 傳遞參數：
 *     除了指定 JSP 路徑， ModelAndView 還可以直接傳遞 Model 物件到 View 層，而不用先放到 request 中。
 *     例如 new ModelAndView("cat/listCat","cat",cat) ，
 *     等於 
 *     request.setAttribute("cat",cat);
 *     return new ModelAndView("cat/listCat");
 *  
 *  ● 傳遞多個參數
 *     Map map = new HashMap(); 
 *     map.put("cat",cat);
 *     map.put("catList",catList);
 *     return new ModelAndView("cat/listCat",map);   // 放回 ModelAndView
 *
 */
public class CatController extends AbstractController {

  
  // service 物件 
  private ICatService catService;

  public ICatService getCatService() {
    return catService;
  }

  public void setCatService(ICatService catService) {
    this.catService = catService;
  }

  
  
  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
    System.out.println(CatController.class.getName()+" , handleRequestInternal Method execute ...");
    
    String action = request.getParameter("action");
    if("add".equals(action)){   
      return add(request,response);
    }else{
      return list(request,response);   
    }
    
  } // end handleRequestInternal

  
  
  
  
  
  protected ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {

    System.out.println(CatController.class.getName()+" , add Method execute ...");
    
    Cat cat = new Cat();
    cat.setName(request.getParameter("name"));
    cat.setCreateDate(new Date());
 
    // 儲存 Cat 物件
    catService.createCat(cat);
    
    // 列出所有 Cat
    List<Cat> catList = catService.listCats();

    
    return new ModelAndView("cat/listCat","catList",catList);
  }  // end add
  
  
  
  
  
  protected ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
    System.out.println(CatController.class.getName()+" , list Method execute ...");
    
    // 列出所有 Cat
    List<Cat> catList = catService.listCats();
    request.setAttribute("catList", catList);
    
    return new ModelAndView("cat/listCat");
  } // list
  
  
  


}
