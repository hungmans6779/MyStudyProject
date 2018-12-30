package com.webservice.xfire.wsdl.helloWebService.client;

import com.webservice.xfire.wsdl.helloWebService.HelloWebService;
import com.webservice.xfire.wsdl.helloWebService.HelloWebServicePortType;



/*
 *  根據 WSDL 產生的用戶端
 *  本例的WSDL： http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebService?wsdl 
 *  
 *  
 *  ※ 《一般呼叫》的範例
 *  
 *  如果即沒有SDK，又需要在程式中呼叫Web 服務，那麼如何來實現呢？
 *  MyEclipse 的 Web 服務用戶端產生工具能夠根據WSDL 自動產生呼叫的程式碼。
 *  
 */
public class HelloWebServiceClient {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    // 用戶端
    HelloWebService client = new HelloWebService();
    
    // 建立服務
    HelloWebServicePortType service = client.getHelloWebServiceHttpPort();
    
    
    // 呼叫服務
    String result = service.sayHello("Demo HelloWebService WSDL 呼叫方式！！！");
    System.out.println("=========================================================================");
    System.out.println(HelloWebServiceClient.class.getName());
    System.out.println("rsult = " + result);
    System.out.println("=========================================================================");

  } // end main
  
  

}
