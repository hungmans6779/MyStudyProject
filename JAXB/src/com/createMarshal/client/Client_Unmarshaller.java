package com.createMarshal.client;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.createMarshal.primer.po.Items;
import com.createMarshal.primer.po.PurchaseOrderType;
import com.createMarshal.primer.po.USAddress;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Client_Unmarshaller {


  public static void main(String[] args) {
    
    try{
      JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrderType.class);
      
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      
      File file = new File("XSD_OUT_XML/create-marshal_out.xml");
      
      PurchaseOrderType purchaseOrderType = (PurchaseOrderType)jaxbUnmarshaller.unmarshal(file);
      
      
      System.out.println("purchaseOrderType           = "+purchaseOrderType);
      System.out.println("purchaseOrderType.orderDate = "+purchaseOrderType.getOrderDate());
      System.out.println("\n");
      
     
      USAddress shipTo = purchaseOrderType.getShipTo();
      System.out.println("shipTo.name = "+shipTo.getName());
      System.out.println("\n");
      
      USAddress billTo = purchaseOrderType.getBillTo();
      System.out.println("billTo.name = "+billTo.getName());
      System.out.println("\n");
      
      
      
      Items items = purchaseOrderType.getItems();
      System.out.println("items = "+items);
      System.out.println("\n");
      List<Items.Item> item = items.getItem();
      Iterator itItem = item.iterator();
      Items.Item itemObject = null;
      while(itItem.hasNext()){
         itemObject = (Items.Item)itItem.next();
         System.out.println("item.partNum = "+itemObject.getPartNum());
         System.out.println("item.productName = "+itemObject.getProductName());
         System.out.println("\n");
      } // end while(itItem.hasNext()){
      
    }catch(JAXBException e){
      e.printStackTrace();
    }

  }

}
