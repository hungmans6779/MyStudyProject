package com.cycle_recovery.client;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.cycle_recovery.bean.Person;

/**
 * 應用驅動循環處理的範例 JAXB RI供應商擴展 CycleRecoverable的應用對象圖中的一個鉤子處理週期。高級。
 */
public class Client_Marshaller {


  public static void main(String[] args) {

    Person person = new Person();
    person.id = 5;
    person.name = "kevin";
    person.parent = person;

    try {

      JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


      // 輸出檔案
      File file = new File("cycle_recovery.xml");

      jaxbMarshaller.marshal(person, System.out);

      jaxbMarshaller.marshal(person, file);

    } catch (JAXBException e) {
      e.printStackTrace();
    }
  } // end main

}
