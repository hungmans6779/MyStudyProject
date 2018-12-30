package com.webservice.authentication;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.fault.XFireFault;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;


/*
 * �iSOAP Header ���i�樭�����ҡj
 * 
 * �p�G�b SOAP Header �����������Ҫ��覡����S��A�O�ۤv�q���@�ؤ覡�A�i�H�z�L Handler �ӳB�z�A �ƹ�W Handler ���ȶȯ�B�z SOAP Header �A���]�i�H�B�z
 * SOAP Body�C
 * 
 * ����h�ݭn�b�Τ�ݩM���A���ݼW�[�o�e�{�Ҹ�T�M�B�z�{�Ҹ�T��Handler�C
 * 
 * �Τ�ݵo�e SOAP �T���ɡA�z�L�W�[ outHandler �� SOAP �����Y��T���W�[��������T�F ���A���ݭn�b�I�s�A�ȫe�z�L�W�[ inHandler
 * �ӭt�d�{�Τ�ݪ��ШD�A�ѻ{�ҬO�_�z�L�ӨM�w�O�_���ѪA�ȡC �L�׬O���A���ݪ� Handler �άO�Τ�ݪ�Handler �A���n�~��
 * org.codehaus.xfire.handler.AbstractHandler ���O�A��{�䤤�� invoke ��k�C
 * 
 * ���d�Ҭ����A���ݡG (1) �b���A���ݼW�[���Ҩ����� AuthenticationHandler ���O�A�����O�t�d�q soap �T�����Y��Ū���X������T�û{�ҡI�I�I �䤤�A�����Ҥ��q�L�ɡA�n�ߥX
 * XFireFault �ҥ~�A�o�˶Ǧ^�Τ�ݪ� soap �T�����h�|�����~��T�C (2) �N�� Handler ���U����A���A�b server.xml ���]�w�{���X�C
 */
public class AuthenticationHandler extends AbstractHandler {

  
  // soap �T�����R�W�Ŷ�
  private final static Namespace ns = Namespace.getNamespace("http://xfire.webservice.com");
  
  
 
  // ��������
  public void invoke(MessageContext context) throws Exception {
     
    
    // �P�_�O�_�a�� soap ���Y
    if(context.getInMessage().getHeader() == null){
      throw new XFireFault("�L������Y��T",XFireFault.SENDER);  
    }
    
    
    Element token = context.getInMessage().getHeader().getChild("AuthenticationToken",ns);
    if(token == null){
      throw new XFireFault("�ШD�����]�t���������Ҹ�T",XFireFault.SENDER);
    }
    
    // �q soap ���Y����o �ϥΪ̦W�� �M �K�X
    String username = token.getChild("username",ns).getValue();
    String password = token.getChild("password",ns).getValue();
    
    System.out.println("************************************************************************************************************************");
    System.out.println(AuthenticationHandler.class.getName());
    System.out.println("01. context header                     = " + context.getInMessage().getHeader());
    System.out.println("02. context header AuthenticationToken = " + context.getInMessage().getHeader().getChild("AuthenticationToken",ns));
    System.out.println("03. context header username            = " + token.getChild("username",ns));
    System.out.println("04. context header password            = " + token.getChild("password",ns));
    System.out.println("05. username                           = " + username);
    System.out.println("06. password                           = " + password);
    System.out.println("************************************************************************************************************************");
    
    
    // ���ҨϥΪ̦W�٩M�K�X
    if(!"admin".equals(username) || !"1234".equals(password)){
      throw new XFireFault("�D�k���ϥΪ̦W�� �� �K�X",XFireFault.SENDER);
    }
   
    // ���ҳq�L�A�i�]�w���e�ݩ� 
    context.setProperty("username",username);
     
  } // end invoke

 

}
