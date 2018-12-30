package com.webservice.xfire.wsdl.helloWebServiceDTHP.client;

import java.net.MalformedURLException;


import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.xfire.authentication.PasswordHandler;



/*
 *  �ھ� WSDL ���ͪ��Τ��
 *  ���Ҫ�WSDL�Ghttp://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebServiceDTHP?wsdl
 *  
 *  
 *  ���mWS-Security�n�i�樭�������Ҫ��d��
 *    
 *  �p�G�Y�S��SDK�A�S�ݭn�b�{�����I�sWeb �A�ȡA����p��ӹ�{�O�H
 *  MyEclipse �� Web �A�ȥΤ�ݲ��ͤu�����ھ�WSDL �۰ʲ��ͩI�s���{���X�C
 *  
 *  
 */
public class HelloWebServiceDTHPClient {

  private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
  private HashMap endpoints = new HashMap();
  private Service service0;

  public HelloWebServiceDTHPClient() {
    create0();
    Endpoint HelloWebServiceDTHPHttpPortEP =
        service0.addEndpoint(
            new QName("http://xfire.webservice.com", "HelloWebServiceDTHPHttpPort"), new QName(
                "http://xfire.webservice.com", "HelloWebServiceDTHPHttpBinding"),
            "http://3w.eztravel.com.tw:8080/XFireDemo/services/HelloWebServiceDTHP");
    endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceDTHPHttpPort"),
        HelloWebServiceDTHPHttpPortEP);
    Endpoint HelloWebServiceDTHPPortTypeLocalEndpointEP =
        service0.addEndpoint(new QName("http://xfire.webservice.com",
            "HelloWebServiceDTHPPortTypeLocalEndpoint"), new QName("http://xfire.webservice.com",
            "HelloWebServiceDTHPPortTypeLocalBinding"), "xfire.local://HelloWebServiceDTHP");
    endpoints.put(new QName("http://xfire.webservice.com",
        "HelloWebServiceDTHPPortTypeLocalEndpoint"), HelloWebServiceDTHPPortTypeLocalEndpointEP);
  }

  public Object getEndpoint(Endpoint endpoint) {
    try {
      return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
    } catch (MalformedURLException e) {
      throw new XFireRuntimeException("Invalid URL", e);
    }
  }

  public Object getEndpoint(QName name) {
    Endpoint endpoint = ((Endpoint) endpoints.get((name)));
    if ((endpoint) == null) {
      throw new IllegalStateException("No such endpoint!");
    }
    return getEndpoint((endpoint));
  }

  public Collection getEndpoints() {
    return endpoints.values();
  }

  private void create0() {
    TransportManager tm =
        (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
    HashMap props = new HashMap();
    props.put("annotations.allow.interface", true);
    AnnotationServiceFactory asf =
        new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(
            new JaxbTypeRegistry()));
    asf.setBindingCreationEnabled(false);
    service0 =
        asf.create(
            (com.webservice.xfire.wsdl.helloWebServiceDTHP.client.HelloWebServiceDTHPPortType.class),
            props);
    {
      AbstractSoapBinding soapBinding =
          asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com",
              "HelloWebServiceDTHPPortTypeLocalBinding"), "urn:xfire:transport:local");
    }
    {
      AbstractSoapBinding soapBinding =
          asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com",
              "HelloWebServiceDTHPHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
    }
  }

  public HelloWebServiceDTHPPortType getHelloWebServiceDTHPHttpPort() {
    return ((HelloWebServiceDTHPPortType) (this).getEndpoint(new QName(
        "http://xfire.webservice.com", "HelloWebServiceDTHPHttpPort")));
  }

  public HelloWebServiceDTHPPortType getHelloWebServiceDTHPHttpPort(String url) {
    HelloWebServiceDTHPPortType var = getHelloWebServiceDTHPHttpPort();
    org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
    return var;
  }

  public HelloWebServiceDTHPPortType getHelloWebServiceDTHPPortTypeLocalEndpoint() {
    return ((HelloWebServiceDTHPPortType) (this).getEndpoint(new QName(
        "http://xfire.webservice.com", "HelloWebServiceDTHPPortTypeLocalEndpoint")));
  }

  public HelloWebServiceDTHPPortType getHelloWebServiceDTHPPortTypeLocalEndpoint(String url) {
    HelloWebServiceDTHPPortType var = getHelloWebServiceDTHPPortTypeLocalEndpoint();
    org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
    return var;
  }

  
  
  
  public static void main(String[] args) {

    // �Τ��
    HelloWebServiceDTHPClient client = new HelloWebServiceDTHPClient();

    // �إߪA��
    HelloWebServiceDTHPPortType service = client.getHelloWebServiceDTHPHttpPort();

    // �]�w�Ȥ�ݩI�s���ݩ�
    Client clientService = Client.getInstance(service); 
    

    /*
    clientService.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "300");
    clientService.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE, "true");
    clientService.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");

    // �p�G�ݭn�]�w�N�z
    clientService.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST, "localhost");
    clientService.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT, "8080");
    */
   
    

    // ********************************************************************************************
    // WS-Security (WSS4J) �i�樭��������(�}�l)
    // ********************************************************************************************
    // �t�d�ѪRDOM��Ƭ�StAX
    clientService.addOutHandler(new DOMOutHandler());


    Properties properties = new Properties();

    // �]�w�{���������ϥΪ̦W�ٱK�X�覡
    properties.setProperty(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);

    // �]�w�ϥΪ̦W��
    properties.setProperty(WSHandlerConstants.USER, "admin");

    // �ھڨϥΪ̦W�٬d�X�������K�X
    properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordHandler.class.getName());

    // �]�w�K�X��Base64 �g�{���� SHA-1 ���C�Ȥ覡�A�i�H�]�w�K�X���ǿ�w��
    // �p�G�]�w������A�Ȭ� WSConstants.PW_TEXT
    // properties.setProperty(WSHandlerConstants.PASSWORD_TYPE,WSConstants.PW_TEXT);
    properties.setProperty(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);

    // �t�d�ո� WS-Security �W�d����T
    clientService.addOutHandler(new WSS4JOutHandler(properties));

    // WS-Security (WSS4J) �i�樭��������(����)
    // ********************************************************************************************

    
   
    String result = service.sayHello("Demo HelloWebServiceDTHP WSDL �I�s�覡�I�I�I");

    System.out.println("******************************************************************");
    System.out.println(HelloWebServiceDTHPClient.class.getName());
    System.out.println("01. result = " + result);
    System.out.println("******************************************************************");
   
    
    
    System.exit(0);
  } // end main
  
  

}
