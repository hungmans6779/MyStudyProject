package com.datatypeconverter.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ListIterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.datatypeconverter.primer.myPo.Items;
import com.datatypeconverter.primer.myPo.POType;
import com.datatypeconverter.primer.myPo.USAddress;
import com.datatypeconverter.primer.myPo.USState;

public class Main {


  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // create a JAXBContext capable of handling classes generated into
      // the primer.po package
      JAXBContext jaxbContext = JAXBContext.newInstance("com.datatypeconverter.primer.myPo");

      // create an Unmarshaller
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

      
      // unmarshal a po instance document into a tree of Java content
      // objects composed of classes from the primer.myPo package.
      JAXBElement poe = (JAXBElement)jaxbUnmarshaller.unmarshal(new FileInputStream("datatypeconverter_out.xml"));
      POType po = (POType) poe.getValue();

      
      // change the billto address
      USAddress address = po.getBillTo();
      address.setToName("John Bob(更新的資訊)");
      address.setStreet("242 Main Street(更新的資訊)");
      address.setCity("Beverly Hills(更新的資訊)");
      address.setState(USState.CA);
      address.setZipCode(90210);

      
      
      USState purchaseState = address.getState();
      ListIterator iter = po.getItems().getItem().listIterator();
      while (iter.hasNext()) {

        Items.Item item = (Items.Item) iter.next();
        
        // 設定價格以 * 0.8 處理
        item.setPrice(item.getPrice().multiply(new BigDecimal("0.80")));

        // Calculate sales tax for specific states
        if (purchaseState == USState.MA) {          // 依其 billTo 的 state=USState.MA 改變其 items 內的 USPrice 的價格 * 1.05 處理
          item.setPrice(item.getPrice().multiply(new BigDecimal("1.05")));
        } else if (purchaseState == USState.CA) {  // 依其 billTo 的 state=USState.CA 改變其 items 內的 USPrice 的價格 * 1.06 處理
          item.setPrice(item.getPrice().multiply(new BigDecimal("1.70")));
        }
        
        // 設定只取小數點後2位
        item.setPrice(item.getPrice().setScale(2,BigDecimal.ROUND_DOWN));
      } // end while (iter.hasNext()) {


      // create a Marshaller and marshal to a file
      Marshaller m = jaxbContext.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
      m.marshal(poe,System.out);
 
    } catch (JAXBException je) {
      je.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    
  } // end main


}
