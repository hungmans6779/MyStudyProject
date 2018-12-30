
package com.webservice.xfire.wsdl.helloWebServiceDTHP.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "HelloWebServiceDTHPPortType", targetNamespace = "http://xfire.webservice.com")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface HelloWebServiceDTHPPortType {


  @WebMethod(operationName = "sayHello", action = "")
  @WebResult(name = "out", targetNamespace = "http://xfire.webservice.com")
  public String sayHello(
      @WebParam(name = "in0", targetNamespace = "http://xfire.webservice.com") String in0);

}
