package com.webservice.sdk;



import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.Signature.PasswordHandler;
import com.webservice.xfire.IHelloWebServiceSignature;




/*
 * �iSDK �覡���Τ�ݡj
 * 
 * ���m�Ʀ�ñ��(Signature)�n�i�樭�������Ҫ��d��
 * 
 * ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|����SDK�A �o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C�Ҧp yahoo ��Web �A�Ȥ��ȴ��ѤF�A�ȡA
 * �ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 */
public class HelloWebServiceSignatureClient {

  
  private static IHelloWebServiceSignature service; // Service ����

  
  // �p���غc�l
  private HelloWebServiceSignatureClient() {}

  
  
  
  

  public static IHelloWebServiceSignature getService(String serviceURL) throws MalformedURLException{

    if (service == null) {

      // �إ� IHelloWebServiceDTHP ���A��
      Service srvcModel = new ObjectServiceFactory().create(IHelloWebServiceSignature.class);

      // �إ� XFire ��H
      XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());

      // �I�s Web �A��
      service = (IHelloWebServiceSignature) factory.create(srvcModel, serviceURL);


      
      

        
      // �]�w�Ȥ�ݩI�s���ݩ�
      Client client = Client.getInstance(service);

        
      client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "300");
      client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE, "true");
      client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");

      // �p�G�ݭn�]�w�N�z
      client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST, "localhost");
      client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT, "8080");
        
        
      
   
      // ***********************************************************************************************
      // �m�Ʀ�ñ��(Signature)�n�i�樭��������

      // �t�d�ѪR DOM ��Ƭ�StAX
      client.addOutHandler(new DOMOutHandler());

        
      Properties properties = new Properties();

      // �]�w�Ʀ�{���������Ʀ���Ҥ覡
      properties.setProperty(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);

      // �W�[�ϥΪ̦W��
      properties.setProperty(WSHandlerConstants.USER, "admin");

      // �ھڨϥΪ̦W�٬d�ߥX�������K�X
      properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS,PasswordHandler.class.getName());

      properties.setProperty(WSHandlerConstants.SIG_PROP_FILE,"META-INF/xfire/outsecurity.properties");

      properties.setProperty(WSHandlerConstants.SIG_KEY_ID, "IssuerSerial");

      // �t�d�ո� WS-Security �W�d����T
      client.addOutHandler(new WSS4JOutHandler(properties));
        
      // ***********************************************************************************************
    
    } // end if(service==null){

    
    
    return service;
  } // end getService


  
  
  
  
  
  
  
  
  
  

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    try {
      
      IHelloWebServiceSignature service = HelloWebServiceSignatureClient.getService("http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebServiceSignature");

      System.out.println("*******************************************************************");
      System.out.println(HelloWebServiceSignatureClient.class.getName());
      String result = service.sayHello("Demo HelloWebServiceSignature SDK �I�s�覡�I�I�I");
      System.out.println("result = " + result);
      System.out.println("*******************************************************************");

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

  }



  
  
  
}
