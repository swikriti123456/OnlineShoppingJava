package com.model;

public class Product 
{
	private int pid,qty,cid;
	private String pName,image,brandName,subCategory,description,weight;
	private double price;
	public Product(int pid,  String pName, double price, int qty,String image,int cid) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.cid = cid;
		this.pName = pName;
		this.price = price;
		this.image=image;
	}
	
	public Product(int pid, String pName, double price,  int qty,String image,  int cid,String brandName, String subCategory,
			String description, String weight) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.cid = cid;
		this.pName = pName;
		this.image = image;
		this.brandName = brandName;
		this.subCategory = subCategory;
		this.description = description;
		this.weight = weight;
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
