package project;

public class Shoes {
	private String company;  
	private String model;	
	private String color;
	private int size;	 //사이즈
	private int price;   //가격
	private int amount;  //수량
	public Shoes(String company, String model, String color, int size, int price, int amount) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.size = size;
		this.price = price;
		this.amount = amount;
	}
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}
	public String getModel() {return model;}
	public void setModel(String model) {this.model = model;}
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}
	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}
}
