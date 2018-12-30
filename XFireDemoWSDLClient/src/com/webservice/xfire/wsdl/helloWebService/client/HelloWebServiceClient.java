package com.webservice.xfire.wsdl.helloWebService.client;

import com.webservice.xfire.wsdl.helloWebService.HelloWebService;
import com.webservice.xfire.wsdl.helloWebService.HelloWebServicePortType;



/*
 *  �ھ� WSDL ���ͪ��Τ��
 *  ���Ҫ�WSDL�G http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebService?wsdl 
 *  
 *  
 *  �� �m�@��I�s�n���d��
 *  
 *  �p�G�Y�S��SDK�A�S�ݭn�b�{�����I�sWeb �A�ȡA����p��ӹ�{�O�H
 *  MyEclipse �� Web �A�ȥΤ�ݲ��ͤu�����ھ�WSDL �۰ʲ��ͩI�s���{���X�C
 *  
 */
public class HelloWebServiceClient {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    // �Τ��
    HelloWebService client = new HelloWebService();
    
    // �إߪA��
    HelloWebServicePortType service = client.getHelloWebServiceHttpPort();
    
    
    // �I�s�A��
    String result = service.sayHello("Demo HelloWebService WSDL �I�s�覡�I�I�I");
    System.out.println("=========================================================================");
    System.out.println(HelloWebServiceClient.class.getName());
    System.out.println("rsult = " + result);
    System.out.println("=========================================================================");

  } // end main
  
  

}
