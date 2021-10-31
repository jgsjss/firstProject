package project;

public interface Products {
	public int MIN_SHOES = 0;
	public int MAX_SHOES = 100;
	public void createShoes();
	public void addShoes();
	public void sellShoes(String model, int size, String color);
	public void ShoesList();
}
