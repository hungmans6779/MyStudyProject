package com.classResolver.container;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.xml.sax.SAXException;

import com.sun.xml.bind.IDResolver;
import com.sun.xml.bind.api.ClassResolver;



@XmlRootElement
public class Container {

  /*
   *  Note that this {@link JAXBContext} only knows about
   *  {@link Container}.
   */
  private static final JAXBContext jaxbContxt;
  static{
	try{
	  jaxbContxt = JAXBContext.newInstance(Container.class);	
	}catch(Exception e){
	  throw new Error(e);	
	}
  } // end static{
	  
	  	
  
  @XmlElement(name="value")
  private List<Value> values = new ArrayList<Value>();
	
  
  /*
   * 靜態內部類別 Value
   */
  private static class Value{
	 
   /**
    * ID to identify {@link #value}.
    */
	@XmlAttribute(required=true)
	@XmlID
	private String id;
	
	
	/**
     * This annotation causes JAXB to trigger {@link ClassResolver}
     * on this field.
     */
	@XmlAnyElement(lax=true)
    private Object value;
	
  }
  
  
  
  

  
  
  
  /*
   * 
   *  靜態內部類別 IDResolverImpl
   *  
   *  Notice that this example places the ID attribute on {@link Value},
   *  not on the bean object ({@link Value#value}.) So we use
   *  a custom {@link IDResolver} so that {@link XmlIDREF} resolves
   *  into the {@link Value#value}.
   *  
   */
  static final class IDResolverImpl extends IDResolver {
	  
	private final Map<String,Object> table = new HashMap<String,Object>();

	
	
	public void bind(String id,Object obj){
	  System.out.println(IDResolverImpl.class.getName()+",bind() execute");
	  System.out.println("k0_id  = "+id);
	  System.out.println("k0_obj = "+obj);
	  System.out.println("\n");
	  
	  table.put(id,obj);	
	} // end bind 
	
	
	
	@Override
	public Callable<?> resolve(final String id,Class targetType) {
	  System.out.println(IDResolverImpl.class.getName()+",resolve() execute");
	  System.out.println("k1_id         = "+id);
	  System.out.println("k1_targetType = "+targetType);
	  
	  
	  System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
	  System.out.println("\n");
		  
	  return new Callable<Object>(){
		public Object call() throws Exception{
		  Object o = table.get(id);
		  if(o instanceof Value){
			return ((Value)o).value;  
		  }
		  return o;
		}
	  };  
	} // end resolve 
	
	
  } // end class IDResolverImpl 
  

  
  
  
  

  
  
  

  /*
   *  靜態內部類別 ClassResolverImpl 
   *  
   *  Informs JAXB lazily to use such and such class for unmarshalling.
   */
  static final class ClassResolverImpl extends ClassResolver{

   /*
	*  nsUri     => java:com.classResolver.bean
	*  localName => Foo	
	*  className => com.classResolver.bean.Foo
	*/
	public Class<?> resolveElementName(String nsUri,String localName) throws Exception {
      if(nsUri.startsWith("java:")){
    	String className = nsUri.substring(5)+"."+localName;   // 取得 Bean 的路徑
    	
    	System.out.println(ClassResolverImpl.class.getName()+",resolveElementName() execute");
    	System.out.println("nsUri     = "+nsUri);
    	System.out.println("localName = "+localName);
    	System.out.println("className = "+className);
    	System.out.println("\n");
    	
    	return Class.forName(className);
      }
	  return null;
	} 
  } // end class ClassResolverImpl
  
  
  
  
  
  
  
  
  
  
  
  
  
  // 讀取檔案
  public static Container load(File file) throws JAXBException {

	Unmarshaller jaxbUnmarshaller = jaxbContxt.createUnmarshaller();

	jaxbUnmarshaller.setProperty(ClassResolver.class.getName(),new ClassResolverImpl());
	jaxbUnmarshaller.setProperty(IDResolver.class.getName(),new IDResolverImpl());

	return (Container) jaxbUnmarshaller.unmarshal(file);
  } // end load
  
  

  
  
  /*
   *  Gets the object for the ID.
   */
  public Object get(String id){
	for(Value v:values){  
	  if(v.id.equals(id)){
		System.out.println("k2_id      = "+id);
		System.out.println("k2_v.id    = "+v.id);
		System.out.println("k2_v.value = "+v.value);
		return v.value;
	  } // end if(v.id.equals(id)){
	} // end for(Value v:values){  
    return null;
  } // end Object get
  
  
  
}
