package com.framework.spring.initializingBean;

import org.springframework.beans.factory.InitializingBean;


/*
 *  ��{�F InitializingBean ������Java Bean�|�b���͹����B�Ҧ��ݩʳQ�]�w��I�s��l�Ƥ�k�C
 *  ���ϥθӤ����|�P Spring �{���X�o�ͽ��X�A�]������ĳ�ϥΡC
 */
public class InitializingBean01 implements InitializingBean {

  
  public void afterPropertiesSet() throws Exception {
    System.out.println(InitializingBean01.class.getName()+" ,afterPropertiesSet()  execute ...");
  }

  
  
  
  public void showInfo(String name){
    System.out.println(InitializingBean01.class.getName()+" ,showInfo() execute ..."); 
    System.out.println("name = "+name);
  }
  
  
  
}
