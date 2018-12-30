package com.classResolver.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Bar {

	private int x, y;

	public int getX() {
		return x;
	}

	@XmlElement
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	@XmlElement
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Bar [x=" + x + ", y=" + y + "]";
	}

	
	
}
