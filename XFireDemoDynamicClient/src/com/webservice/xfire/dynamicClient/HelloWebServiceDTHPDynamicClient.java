package com.webservice.xfire.dynamicClient;

import java.net.URL;
import java.util.Properties;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.xfire.authentication.PasswordHandler;


/*
 *  �iDynamicClient �覡���Τ�ݡj
 *  
 *  ���mWS-Security�n�i�樭�������Ҫ��d��
 *   
 *  ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|����SDK�A
 *  �o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C�Ҧp yahoo ��Web �A�Ȥ��ȴ��ѤF�A�ȡA
 *  �ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 * 
 */
public class HelloWebServiceDTHPDynamicClient {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    try{
      Client client = new Client(new URL("http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebServiceDTHP?wsdl"));
      
      
      // ********************************************************************************************
      // WS-Security  (WSS4J) �i�樭��������(�}�l)
      // ********************************************************************************************
      // �t�d�ѪRDOM��Ƭ�StAX
      client.addOutHandler(new DOMOutHandler());
      
      Properties properties = new Properties();
      
      // �]�w�{���������ϥΪ̦W�ٱK�X�覡
      properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.USERNAME_TOKEN);
      
      // �]�w�ϥΪ̦W��
      properties.setProperty(WSHandlerConstants.USER,"admin");
      
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
      
      
      
      
      Object [] results = client.invoke("sayHello",new Object[]{"Demo HelloWebServiceDTHP dynamicClient �I�s�覡�I�I�I"});
      System.out.println("====================================================================================================");
      System.out.println(HelloWebServiceDTHPDynamicClient.class.getName());
      System.out.println("results[0] = " + results[0]);
      System.out.println("====================================================================================================");
    }catch(Exception e){
      e.printStackTrace();
    }

  } // end main
  
  

}
