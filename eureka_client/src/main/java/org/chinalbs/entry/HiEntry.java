package org.chinalbs.entry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HiEntry {
	
	@XmlElement
	private String name;
	
	@XmlElement
	private BaseEntry base;
	
	public HiEntry(){
	}
	
	public HiEntry(String name, BaseEntry base){
		this.name = name;
		this.base = base;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseEntry getBase() {
		return base;
	}

	public void setBase(BaseEntry base) {
		this.base = base;
	}
}
