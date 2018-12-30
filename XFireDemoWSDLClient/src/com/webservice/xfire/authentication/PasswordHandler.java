package com.webservice.xfire.authentication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;


/*
 *   �@�뱡�p�U�A�ϥΪ̪��K�X�s�b�ɮפ��θ�Ʈw���A�o�N�ݭnPasswordHandler �^�����ӮھڨϥΪ̦W����o�����K�X�����O�A
 * ���ݭn��{ org.apache.ws.security.WSPasswordCallback �����A�óz�L WSHandlerConstants.PW_CALLBACK_CALSS �ӳ]�w�C
 * 
 */
public class PasswordHandler implements CallbackHandler {


  // �x�s�ϥΪ̦W�٩M�K�X�������
  private Map <String,String> passwords = new HashMap<String,String>();
  
  
  // �غc�l
  public PasswordHandler(){
    passwords.put("admin","1234");
    passwords.put("kevin","168");
  } 
    
  
  
  
  
  // �^�ɸӤ�k
  public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {
    
    // ��o�K�X�^�ɤ�k
    WSPasswordCallback pc = (WSPasswordCallback)callbacks[0];
   
    // ��o�ϥΪ̦W��
    String id = pc.getIdentifer();
    
    // �ھڨϥΪ̦W�٦b����������X�K�X�A�ó]�w��K�X�^�ɤ�k��
    pc.setPassword(passwords.get(id));
  
    System.out.println("***************************************************************************");
    System.out.println(PasswordHandler.class.getName());
    System.out.println("01. callbacks[0] = " + callbacks[0]);
    System.out.println("02. id           = " + id);
    System.out.println("***************************************************************************");
    
  } // end handle
  
  
  
}