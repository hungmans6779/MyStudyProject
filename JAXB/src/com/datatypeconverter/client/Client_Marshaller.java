package com.datatypeconverter.client;

import java.io.File;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import com.datatypeconverter.primer.myPo.Items;
import com.datatypeconverter.primer.myPo.POType;
import com.datatypeconverter.primer.myPo.USAddress;
import com.datatypeconverter.primer.myPo.USState;


/*
 *  datatypeconverter（前身為SampleApp7）
 *  此示例應用程序非常相似，內嵌自定義示例應用程序（原 SampleApp6），但說明了一個更容易，但沒有強大的， <jaxb:javaType> 定制的。
 */
public class Client_Marshaller {

  /**
   * @param args
   */
  public static void main(String[] args) {

    try {
      // 建立父元素的物件
      POType poType = new POType();

      // 設定父元素：purchaseOrder 的屬性:orderDate
      poType.setOrderDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));

      // 設定子元素 shipTo 的 USAddress 相關資訊
      USAddress shipTo = createUSAddress("kevin-1", "民生東路一段267巷5號", "台北市", "台灣渻", "104");
      poType.setShipTo(shipTo);

      // 設定子元素 billTo 的 USAddress 相關資訊
      USAddress billTo =createUSAddress("hungmans6779-1", "8 Oak Avenue", "Cambridge", "MA", "7788578");
      poType.setBillTo(billTo);


      // create an empty Items object
      Items items = new Items();

      // get a reference to the ItemType list
      List<Items.Item> itemList = items.getItem();

      // start adding ItemType objects into it
      itemList.add(createItem("Nosferatu - Special Edition (1929)", 5, new BigDecimal("19.99"),null, null, "111-NO"));
      itemList.add(createItem("The Mummy (1959)", 3, new BigDecimal("19.98"), null,null,"222-MU"));
      itemList.add(createItem("Godzilla and Mothra: Battle for Earth/Godzilla vs. King Ghidora",3,new BigDecimal("27.95"), null, null, "333-GZ"));

      // 設定子元素 items 的 item 相關資訊
      poType.setItems(items);

      
      
      
      
      
      JAXBContext jaxbContext = JAXBContext.newInstance(POType.class);
      
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
      
      File file = new File("datatypeconverter_out_1.xml");
      
      jaxbMarshaller.marshal(poType,System.out);
      jaxbMarshaller.marshal(poType,file);
     
    } catch (Exception e) {
      e.printStackTrace();
    }

  } // end main



  // 建立 USAddress 的物件
  public static USAddress createUSAddress(String name, String street, String city, String state, String zip) {

    // create an empty USAddress objects
    USAddress address = new USAddress();

    // set properties on it
    address.setToName(name);
    address.setStreet(street);
    address.setCity(city);
    address.setState(USState.CA);
    address.setZipCode(new Integer(zip));

    address.setCountry("TW");

    // return it
    return address;
  }



  // 建立 Item 的物件(靜態內部類別物件)
  public static Items.Item createItem(String productName, int quantity, BigDecimal price,String comment, XMLGregorianCalendar shipDate, String partNum) {

    // create an empty ItemType object
    Items.Item item = new Items.Item();

    // set properties on it
    item.setProductName(productName);
    item.setQuantity(new Short(String.valueOf(quantity)));
    item.setPrice(price);
    item.setComment(comment);
    item.setShipDate(shipDate);
    item.setPartNumber(partNum);

    // return it
    return item;
  }



}
