package com.classResolver.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

public class Foo {

	public int a;
	public String b;

	@XmlIDREF
	public Object c;

	@Override
	public String toString() {
		return "Foo [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

	
}
