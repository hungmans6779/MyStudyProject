package com.cycle_recovery.client;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.cycle_recovery.bean.Person;

public class Client_UnMarshaller {

  

  public static void main(String[] args) {
   
    try{
      JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
    
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      
      File file = new File("cycle_recovery.xml");
      
      Person person = (Person) jaxbUnmarshaller.unmarshal(file);
      
      System.out.println("person = "+person);
      
      System.out.println("\n");
      System.out.println("id     = "+person.id);
      System.out.println("name   = "+person.name);
      System.out.println("parent = "+person.parent);
      
    }catch(JAXBException  e){
      e.printStackTrace();
    } 
  } // end main
  
  

}
