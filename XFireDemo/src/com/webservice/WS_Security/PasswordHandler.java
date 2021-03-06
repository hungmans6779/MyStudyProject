package com.webservice.WS_Security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

import com.sun.istack.internal.logging.Logger;


/*
 * 一般情況下，使用者的密碼存在檔案中或資料庫中，這就需要PasswordHandler 回檔類來根據使用者名稱獲得對應密碼的類別， 它需要實現
 * org.apache.ws.security.WSPasswordCallback 介面，並透過 WSHandlerConstants.PW_CALLBACK_CALSS 來設定。
 */
public class PasswordHandler implements CallbackHandler {
  
  private Map <String,String> passwords = new HashMap<String,String>();

  public PasswordHandler(){
    passwords.put("admin","1234");
    passwords.put("kevin","168");
  }
  

  
  // 回檔該方法
  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

    // 獲得密碼回檔方法
    WSPasswordCallback pc = (WSPasswordCallback)callbacks[0];
   
    // 獲得使用者名稱
    String id = pc.getIdentifer();
    
    // 根據使用者名稱在雜源湊表中取出密碼，並設定到密碼回檔方法中
    pc.setPassword(passwords.get(id));
  
    System.out.println("***************************************************************************");
    System.out.println(PasswordHandler.class.getName());
    System.out.println("01. callbacks[0] = " + callbacks[0]);
    System.out.println("02. id           = " + id);
    System.out.println("***************************************************************************");
    
  } // end handle


  
}