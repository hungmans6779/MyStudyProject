package com.framework.spring.destoryBean.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.framework.spring.destoryBean.DestroyBean01;

public class SpringDestroyBeanTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_DestroyBean.xml"));

    DestroyBean01 destroyBean01 = (DestroyBean01)factory.getBean("destoryBean01");
    destroyBean01.showInfo();
   
  } // end main
  
  
  

}
