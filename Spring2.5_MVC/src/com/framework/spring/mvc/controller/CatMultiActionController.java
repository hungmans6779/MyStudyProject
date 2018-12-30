package com.framework.spring.mvc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.framework.spring.orm.entity.Cat;
import com.framework.spring.orm.service.ICatService;



/**
 * �h�~�Ȥ��o��
 * 
 * �p�G�n�Τ@�� Controller �B�z�h�ӷ~���޿�A�i�H�ϥ�
 * org.springframework.web.servlet.mvc.multiaction.MultiActionController �C MultiActionController
 * �O�Ӥ��o���A�۷�� Struts1.x �� DispatcherAction �A��ھڬY�Ѽƭ�(�Ҧp action �Ѽ�) �N���P���ШD���o�줣�P����k�W�C
 * 
 * 
 * 
 * Spring ����h
 * 
 * 
 * Spring MVC �̨ϥ� Controller �B�z�ϥΪ��ШD�C Controller �۷�� Struts1.x �̪� Action �A���̹�{����B�����z�������C
 * 
 * 
 * Spring MVC ������h�O Contoller �CController �O�Ӥ����A�@�몽���~��
 * org.springframework.web.servlet.mvc.AbstractController�A �ù�{ handleRequestInternal ��k�C
 * handleRequestInternal ��k�۷�� Struts1.x Action �� execute() ��k�C
 * 
 * 
 * Spring MVC ���u���I
 * 
 * �@�� Spring ���@�����AController �㦳�ѵM���u�աA���ݹ� Struts1 & 2 �� Action ���˯S�N��X�N��ĤJ Spring �{�� Framework ���C
 * catService �ϥ� IoC �ӤJ�� Controller ���C
 * 
 * handleRequestInternal ��k�ѼƬ� request�Bresponse �A�o�˥i�H�q request ����o��ơA�� Servlet �@�˾ާ@�C
 * 
 * 
 * 
 * 
 * 
 * Spring MVC �W�S���a��b�� View �h���B�z�W�C handleRequestInternal �Ǧ^ ModelAndView ����A�۷�� Struts1.x �̪�
 * ActionForward�C
 * 
 * �� ModelAndView�G ��i�H�ݰ��O��JSP ���󪺫ʸˡCModelAndView ��������JSP ���������|�A�Ҧp new ModelAndView("cat/list")�C �Ѽ�
 * "cat/list" �u�O JSP ���|���@�����A���㪺���|�� "/WEB-INF/jsp/cat/listCat.jsp" �A���|���e�᳡���O�]�w�b�]�w�ɤ��C
 * 
 * �� �ǻ��ѼơG ���F���w JSP ���|�A ModelAndView �٥i�H�����ǻ� Model ����� View �h�A�Ӥ��Υ���� request ���C �Ҧp new
 * ModelAndView("cat/listCat","cat",cat) �A ���� request.setAttribute("cat",cat); return new
 * ModelAndView("cat/listCat");
 * 
 * �� �ǻ��h�ӰѼ� Map map = new HashMap(); map.put("cat",cat); map.put("catList",catList); return new
 * ModelAndView("cat/listCat",map); // ��^ ModelAndView
 * 
 */
public class CatMultiActionController extends MultiActionController {

  // service ����
  private ICatService catService;

  public ICatService getCatService() {
    return catService;
  }

  public void setCatService(ICatService catService) {
    this.catService = catService;
  }


  

  // �x�s Cat
  @SuppressWarnings("unchecked")
  public ModelAndView addCatMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println(CatMultiActionController.class.getName() + " , add Method execute ...");

    String name = ServletRequestUtils.getStringParameter(request,"name");
    
    
    Cat cat = new Cat();
    cat.setName(name);
    cat.setCreateDate(new Date());

    // �x�s Cat ����
    catService.createCat(cat);

    return listCatMulti(request, response);
  } // end add

  
  
  
  

  // �C�X�Ҧ�Cat
  @SuppressWarnings("unchecked")
  public ModelAndView listCatMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println(CatMultiActionController.class.getName() + " , list Method execute ...");

    
    // �C�X�Ҧ� Cat
    List<Cat> catList = catService.listCats();
   
    return new ModelAndView("cat/listCat","catList", catList);
  } // end list


  
  
  
  
}
