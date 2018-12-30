package com.datatypeconverter.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.datatypeconverter.primer.myPo.Items;
import com.datatypeconverter.primer.myPo.POType;
import com.datatypeconverter.primer.myPo.USAddress;


/*
 *  datatypeconverter（前身為SampleApp7）
 *  此示例應用程序非常相似，內嵌自定義示例應用程序（原 SampleApp6），但說明了一個更容易，但沒有強大的， <jaxb:javaType> 定制的。
 */
public class Client_UnMarshaller {

  public static void main(String[] args) {

    try {
  
      /*
        此段不能執行
        
      JAXBContext jaxbContext = JAXBContext.newInstance(POType.class);
     
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      
      File file = new File("datatypeconverter_out.xml");
      
      POType poType = (POType)jaxbUnmarshaller.unmarshal(file); 
      
      */
      
      
      
      
      JAXBContext jaxbContext = JAXBContext.newInstance("com.datatypeconverter.primer.myPo");
      
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
     
      FileInputStream ios = new FileInputStream("datatypeconverter_out.xml");
      
      JAXBElement jaxbE = (JAXBElement)jaxbUnmarshaller.unmarshal(ios);
      System.out.println("jaxbE = "+jaxbE);
      
      
      POType poType = (POType) jaxbE.getValue();
      System.out.println("poType = "+poType);
      System.out.println("\n");

      USAddress shipTo = poType.getShipTo();
      System.out.println("shipTo.name = "+shipTo.getToName());
      System.out.println("\n");
      
      USAddress billTo = poType.getBillTo();
      System.out.println("billTo.name = "+billTo.getToName());
      System.out.println("\n");

      
      Items items = poType.getItems();
      List<Items.Item> item = items.getItem();
      Iterator itItem = item.iterator();
      Items.Item itemObject = null;
      while(itItem.hasNext()){
        itemObject = (Items.Item)itItem.next();
        System.out.println("item.partNumber  = "+itemObject.getPartNumber());
        System.out.println("item.productName = "+itemObject.getProductName());
        System.out.println("item.price       = "+itemObject.getPrice());
        System.out.println("\n");
      } // end while(itItem.hasNext()){
      
    } catch (JAXBException je) {
      je.printStackTrace();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }

  } // end main



}
