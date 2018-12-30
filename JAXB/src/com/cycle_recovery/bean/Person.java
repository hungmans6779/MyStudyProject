package com.cycle_recovery.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.bind.CycleRecoverable;


/**
 * 應用驅動循環處理的範例
 * JAXB RI供應商擴展 CycleRecoverable的應用對象圖中的一個鉤子處理週期。高級。
 */

@XmlRootElement
public class Person implements CycleRecoverable{
  
  public int id;
  public String name;
  public Person parent;
  
  
  /*
   * this method is called by JAXB when a cycle is detected
   * 
   * (non-Javadoc)
   * @see com.sun.xml.bind.CycleRecoverable#onCycleDetected(com.sun.xml.bind.CycleRecoverable.Context)
   */
  @Override
  public Object onCycleDetected(Context context) {
    Person replacement = new Person();
    replacement.id = this.id;
    replacement.name = this.name;
    
    return replacement;
  } // end onCycleDetected


  
  
  
  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + ", parent=" + parent + "]";
  }
    
  
}
