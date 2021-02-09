package com.model;

public class Item 
{
	private int pid,qty;
	private String pName,image;
	private double price;
	public Item(int pid, int qty, String pName, double price,String image) {
		super();
		this.image=image;
		this.pid = pid;
		this.qty = qty;
		this.pName = pName;
		this.price = price;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
