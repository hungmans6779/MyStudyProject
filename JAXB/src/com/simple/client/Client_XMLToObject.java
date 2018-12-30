package com.simple.client;

import java.io.File;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.simple.bean.Customer;


/*
 *  Convert XML to Object ½d¨Ò
 *  JAXB unmarshalling example, convert a XML file content into a customer object. The jaxbMarshaller.unmarshal() contains a lot of overloaded methods, find one that suit yours.
 *  
 *  °Ñ¾\½d¨Ò¡Ghttp://www.mkyong.com/java/jaxb-hello-world-example/
 */
public class Client_XMLToObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  try{
		  
		File file = new File("simple.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		
		System.out.println("customer = "+customer);
		  
		System.out.println("id   = "+customer.getId());
		System.out.println("name = "+customer.getName());
		System.out.println("age  = "+customer.getAge());
	
	  }catch(Exception e){
		e.printStackTrace();  
	  }
	}

}
