package com.webservice.xfire.dynamicClient;

import java.net.URL;

import org.codehaus.xfire.client.Client;

import com.webservice.xfire.authentication.ClientAuthenticationHandler;



/*
 *  【DynamicClient 方式的用戶端】
 *  
 *  
 *   ※《Web 服務安全》SOAP Header 中進行身份驗證的範例
 *   
 *  對於服務提供者，可以只提供服務和對應的 WSDL，是有些情況下，服務提供者會提供SDK，
 *  這樣開發者就可以使用服務提供者的一些類別。例如 yahoo 的 Web 服務不僅提供了服務，
 *  還提供了開發套件 SDK，下面就看一下這種方式的用戶端如何使用。
 * 
 */
public class HelloWebServiceAuthClient {

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    try{
      Client client = new Client(new URL("http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebServiceAuth?wsdl"));
      
      // 用戶端將認證身份加到header 中
      client.addOutHandler(new ClientAuthenticationHandler("admin","1234"));

      
      Object [] results = client.invoke("sayHello", new Object[]{"Demo HelloWebServiceAuth DynamicClient 呼叫方式！！！"});
      System.out.println("====================================================================================================");
      System.out.println(HelloWebServiceAuthClient.class.getName());
      System.out.println("results[0] = " + results[0]);
      System.out.println("====================================================================================================");
     
    }catch(Exception e){
      e.printStackTrace();
    }
  
  } // end main

  
  
}
