package com.model;

public class category 
{
	private int cId;
	private String cName;
	private String image;
	
	public category( String cName,String image) {
		super();
		
		this.cName = cName;
		this.image=image;
		
	}
	
	public category(int cId, String cName, String image) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	
}
