package com.simple.client;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.simple.bean.Customer;

public class Client_ObjectToXML {

  public static void main(String[] args) {
   
	Customer customer = new Customer();
	customer.setId(1);
	customer.setName("kevin");
	customer.setAge(35);
	
	try{
	  File file = new File("simple.xml");
	  
	  JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
	  
	  Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	  
	  // out pretty printed
	  jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
	  
	  jaxbMarshaller.marshal(customer,file);
	  jaxbMarshaller.marshal(customer,System.out);
	  
	}catch(Exception e){
	  e.printStackTrace();	
	}
	
  } // end main
  

}
