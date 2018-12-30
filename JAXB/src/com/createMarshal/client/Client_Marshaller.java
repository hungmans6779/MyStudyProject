package com.createMarshal.client;

import java.io.File;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.createMarshal.primer.po.Items;
import com.createMarshal.primer.po.PurchaseOrderType;
import com.createMarshal.primer.po.USAddress;

public class Client_Marshaller {


  public static void main(String[] args) {
   
    try{
      
      // 建立父元素的物件
      PurchaseOrderType po = new PurchaseOrderType();
      
     
      // 設定父元素：purchaseOrder 的屬性:orderDate
      po.setOrderDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));  
        
      // 設定子元素 shipTo 的 USAddress 相關資訊
      USAddress shipTo = createUSAddress("kevin-1","民生東路一段267巷5號","台北市","台灣渻","104"); 
      po.setShipTo(shipTo);       
        
      // 設定子元素 billTo 的 USAddress 相關資訊
      USAddress billTo = createUSAddress("hungmans6779-1","8 Oak Avenue","Cambridge","MA","7788578");
      po.setBillTo(billTo);       
      
      
      // create an empty Items object
      Items items = new Items();
      
      // get a reference to the ItemType list
      List<Items.Item> itemList = items.getItem();
        
      // start adding ItemType objects into it
      itemList.add(createItem("Nosferatu - Special Edition (1929)",5,new BigDecimal("19.99"),null,null,"111-NO"));
      itemList.add(createItem("The Mummy (1959)",3,new BigDecimal("19.98"),null,null,"222-MU"));
      itemList.add(createItem("Godzilla and Mothra: Battle for Earth/Godzilla vs. King Ghidora",3,new BigDecimal("27.95"),null,null,"333-GZ"));
        
      // 設定子元素 items 的 item 相關資訊
      po.setItems(items);
      
      
      
      
      JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrderType.class);
      
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
      
      File file = new File("XSD_OUT_XML/create-marshal_out.xml");
      
      jaxbMarshaller.marshal(po,System.out);
      jaxbMarshaller.marshal(po,file);
        
    }catch(JAXBException e){
      e.printStackTrace();
    }catch(Exception e1){
      e1.printStackTrace();
    }
    
  } // end main

  
  
  
  
  // 建立 USAddress 的物件
  public static USAddress createUSAddress(String name,String street,String city,String state,String zip) {
  
    // create an empty USAddress objects                                             
    USAddress address = new USAddress();
     
    // set properties on it
    address.setName(name);
    address.setStreet(street);
    address.setCity(city);
    address.setState(state);
    address.setZip(new BigDecimal(zip));
      
    address.setCountry("TW");
    
    // return it
    return address;
  }
  
  
  
  
  
  // 建立 Item 的物件(靜態內部類別物件)
  public static Items.Item createItem(String productName,int quantity,BigDecimal price,String comment,XMLGregorianCalendar shipDate,String partNum ) {
 
    // create an empty ItemType object
    Items.Item item = new Items.Item();
      
    // set properties on it
    item.setProductName(productName);
    item.setQuantity(quantity);
    item.setUSPrice(price);
    item.setComment(comment);
    item.setShipDate(shipDate);
    item.setPartNum(partNum);
      
    // return it
    return item;
  }
                                         
    
  
  
  
}
