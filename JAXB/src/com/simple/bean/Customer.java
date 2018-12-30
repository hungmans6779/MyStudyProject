package com.simple.bean;

import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 *  JAXB Annotation
 *  For object that need to convert to / from XML file, it have to annotate with JAXB annotation. 
 *  The annotation are pretty self-explanatory, you can refer to this JAXB guide for detail explanation
 *  
 *  注意事項
 *  For JDK < 1.6, download JAXB from here, and puts “jaxb-api.jar” and “jaxb-impl.jar” on your project classpath. 
 *  
 *  參閱範例：http://www.mkyong.com/java/jaxb-hello-world-example/
 *  
 */
@XmlRootElement
public class Customer {

	String name;
	int age;
	int id;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

}
