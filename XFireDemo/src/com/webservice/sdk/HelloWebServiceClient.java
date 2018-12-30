package com.webservice.sdk;

import java.net.MalformedURLException;


import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import com.webservice.xfire.IHelloWebService;


/*
 *  �iSDK �覡���Τ�ݡj
 *  
 *  �� �m�@��I�s�n���d��
 *  
 *  ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|���� SDK�A�o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C
 *  �Ҧp yahoo ��Web �A�Ȥ��ȴ��ѤF�A�ȡA�ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 *  
 */
public class HelloWebServiceClient {

  
  private static IHelloWebService service;  // Service ����
  
  
  // �p���ƫغc�l
  private HelloWebServiceClient(){}
  
  
  // �z�L WSDL ���o IHelloWebService �����A�H�ϥά۹�������k
  public static IHelloWebService getService(String serviceURL) throws MalformedURLException{
  
    if(service == null){
      
      // �إ� IHelloWebService ���A��
      Service srvcModel = new ObjectServiceFactory().create(IHelloWebService.class);
      
      
      // �إ� XFire ��H
      XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
       
      // �I�s Web �A��
      service = (IHelloWebService)factory.create(srvcModel,serviceURL);
      
      
      
      
      
      // �]�w�Ȥ�ݩI�s���ݩ�
      Client client = Client.getInstance(service);
      
      client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT,"300");
      client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
      client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,"true");
      
      // �p�G�ݭn�]�w�N�z
      client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST,"localhost");
      client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT,"8080");
      
    } // end if(service == null){
    
    
    
    return service;
  } // end getService
  
  
  
  
  
  
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    try{
      IHelloWebService service = HelloWebServiceClient.getService("http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebService");
      
      String result = service.sayHello("Demo HelloWebService SDK �I�s�覡");
    
      System.out.println("result = "+result);
    }catch(MalformedURLException e){
      e.printStackTrace();
    }
    
  } // end main
  
  

}
