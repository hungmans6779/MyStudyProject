package com.webservice.authentication;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.fault.XFireFault;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;


/*
 * 【SOAP Header 中進行身份驗證】
 * 
 * 如果在 SOAP Header 中身份證驗證的方式比較特殊，是自己義的一種方式，可以透過 Handler 來處理， 事實上 Handler 不僅僅能處理 SOAP Header ，它也可以處理
 * SOAP Body。
 * 
 * 那麼則需要在用戶端和伺服器端增加發送認證資訊和處理認證資訊的Handler。
 * 
 * 用戶端發送 SOAP 訊息時，透過增加 outHandler 使 SOAP 的標頭資訊中增加身份的資訊； 伺服器端要在呼叫服務前透過增加 inHandler
 * 來負責認用戶端的請求，由認證是否透過來決定是否提供服務。 無論是伺服器端的 Handler 或是用戶端的Handler ，都要繼承
 * org.codehaus.xfire.handler.AbstractHandler 類別，實現其中的 invoke 方法。
 * 
 * 此範例為伺服器端： (1) 在伺服器端增加驗證身份的 AuthenticationHandler 類別，該類別負責從 soap 訊息表頭中讀取出身份資訊並認證！！！ 其中，當驗證不通過時，要拋出
 * XFireFault 例外，這樣傳回用戶端的 soap 訊息中則會有此外資訊。 (2) 將此 Handler 註冊到伺服器，在 server.xml 中設定程式碼。
 */
public class AuthenticationHandler extends AbstractHandler {

  
  // soap 訊息的命名空間
  private final static Namespace ns = Namespace.getNamespace("http://xfire.webservice.com");
  
  
 
  // 身份驗證
  public void invoke(MessageContext context) throws Exception {
     
    
    // 判斷是否帶有 soap 標頭
    if(context.getInMessage().getHeader() == null){
      throw new XFireFault("無任何標頭資訊",XFireFault.SENDER);  
    }
    
    
    Element token = context.getInMessage().getHeader().getChild("AuthenticationToken",ns);
    if(token == null){
      throw new XFireFault("請求必須包含身份證驗證資訊",XFireFault.SENDER);
    }
    
    // 從 soap 表頭中獲得 使用者名稱 和 密碼
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
    
    
    // 驗證使用者名稱和密碼
    if(!"admin".equals(username) || !"1234".equals(password)){
      throw new XFireFault("非法的使用者名稱 或 密碼",XFireFault.SENDER);
    }
   
    // 驗證通過，可設定內容屬性 
    context.setProperty("username",username);
     
  } // end invoke

 

}
