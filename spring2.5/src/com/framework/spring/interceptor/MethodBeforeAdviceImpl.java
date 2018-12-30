package com.framework.spring.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;


/*
 *  �b�Y�Ǥ�k�e���檺�d�I��
 */
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

  private static Logger logger = Logger.getLogger("MethodBeforeAdviceImpl");
  
  public void before(Method method, Object[] args, Object obj) throws Throwable {
   
    logger.info("*****************************************************************");
    logger.info(MethodBeforeAdviceImpl.class.getName()+",before()...");
    logger.info("����e�ˬd .....");
    logger.info("Method �G " + method.getName());       // ��X��k�W
    logger.info("Args   �G " + Arrays.toString(args));  // ��X��k���ѼƦW
    logger.info("Obj    �G " + obj);                    // ��X����
    logger.info("*****************************************************************");
    
  } // end before
  
  

}
