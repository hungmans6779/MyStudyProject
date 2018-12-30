package com.webservice.xfire.dynamicClient;

import java.net.URL;


import org.codehaus.xfire.client.Client;


/*
 *  �iDynamicClient �覡���Τ�ݡj
 *  
 *  �� �m�@��I�s�n���d��
 *  
 *  ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������ WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|����SDK�A
 *  �o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C�Ҧp yahoo ��Web �A�Ȥ��ȴ��ѤF�A�ȡA
 *  �ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 * 
 */
public class HelloWebServiceClient {

  /**
   * @param args
   */
  public static void main(String[] args) {

    try{
      
      Client client = new Client(new URL("http://localhost:8080/XFireDemo/services/HelloWebService?wsdl"));  
      
      Object [] results = client.invoke("sayHello",new Object[]{"Demo HelloWebService dynamicClient �I�s�覡�I�I�I"});
      
      System.out.println("====================================================================================================");
      System.out.println(HelloWebServiceClient.class.getName());
      System.out.println("results[0] = " + results[0]);
      System.out.println("====================================================================================================");
    
    }catch(Exception e){
      e.printStackTrace();
    }
    
  } // end main

  
}
