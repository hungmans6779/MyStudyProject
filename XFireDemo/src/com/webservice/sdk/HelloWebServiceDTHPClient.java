package com.webservice.sdk;

import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.sun.istack.internal.logging.Logger;
import com.webservice.WS_Security.PasswordHandler;
import com.webservice.xfire.IHelloWebServiceDTHP;


/*
 * �iSDK �覡���Τ�ݡj
 * 
 * ���mWS-Security�n�i�樭�������Ҫ��d��
 * 
 * ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������ WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|���� SDK�A �o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C�Ҧp yahoo �� Web �A�Ȥ��ȴ��ѤF�A�ȡA
 * �ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 */
public class HelloWebServiceDTHPClient {

  
  private static Logger logger = Logger.getLogger(HelloWebServiceDTHPClient.class);
  
  
  private static IHelloWebServiceDTHP service; // Service ����
  
  
  // �p���غc�l
  private HelloWebServiceDTHPClient(){}
  
  
    
  
  // �z�L WSDL ���o  IHelloWebServiceDTHP �����A�H�ϥά۹�������k
  public static IHelloWebServiceDTHP getService(String serviceURL){
    try{
      
      if(service == null){
        
        // �إ� IHelloWebServiceDTHP ���A��
        Service srvcModel = new ObjectServiceFactory().create(IHelloWebServiceDTHP.class);
        
        // �إ� XFire ��H
        XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
        
        // �I�s Web �A��
        service = (IHelloWebServiceDTHP)factory.create(srvcModel,serviceURL);
        
        
         
        // �]�w�Ȥ�ݩI�s���ݩ�
        Client client = Client.getInstance(service);
        
        client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "300");
        client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
        client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,"true");
        
        // �p�G�ݭn�]�w�N�z
        client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST,"localhost");
        client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT,"8080");
        
        
        
       
              
        // ********************************************************************************************
        // WS-Security  (WSS4J) �i�樭��������(�}�l)
        // ********************************************************************************************
     
        // �t�d�ո� DOM ��Ƭ� StAX
        client.addOutHandler(new DOMOutHandler());
        
        
        
        Properties properties = new Properties();
        
        // �]�w�{���������ϥΪ̦W�ٱK�X�覡
        properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.USERNAME_TOKEN);
        
        // �]�w�ϥΪ̦W��
        properties.setProperty(WSHandlerConstants.USER,"kevin");
        
        // �ھڨϥΪ̦W�٬d�X�������K�X
        properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS,PasswordHandler.class.getName());
        
        // �]�w�K�X��Base64 �g�{���� SHA-1 ���C�Ȥ覡�A�i�H�]�w�K�X���ǿ�w��
        // �p�G�]�w������A�Ȭ� WSConstants.PW_TEXT
        // properties.setProperty(WSHandlerConstants.PASSWORD_TYPE,WSConstants.PW_TEXT);
        properties.setProperty(WSHandlerConstants.PASSWORD_TYPE,WSConstants.PW_DIGEST);
        
        
    
        // �t�d�ո� WS-Security �W�d����T
        client.addOutHandler(new WSS4JOutHandler(properties));
        
        // ********************************************************************************************
        // WS-Security  (WSS4J) �i�樭��������(����)
        // ********************************************************************************************
               
      } // end if(service == null){
      
    }catch(MalformedURLException e){
      e.printStackTrace();
    }
    
    
    return service;
  } // end getService
  
  
  
  
  
  
  
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    try{
      IHelloWebServiceDTHP service = HelloWebServiceDTHPClient.getService("http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebServiceDTHP");
      
      String result = service.sayHello("Demo HelloWebServiceDTHP SDK �I�s�覡�I�I�I");  
      
      System.out.println("***************************************************************************");
      System.out.println(HelloWebServiceDTHPClient.class.getName());
      System.out.println("result = "+result);
      System.out.println("***************************************************************************");
        
    }catch(Exception e){
      e.printStackTrace();
    }
    
  } // end main

  
}
