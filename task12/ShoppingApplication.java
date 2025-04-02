package task12;

import java.util.ArrayList;
import java.util.List;

abstract class Product
{
	private String productID;
	private String name;
	private double price;
	
	public Product(String productID, String name, double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
	}
	
	public String getProductID() {
		return productID;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public abstract void showDescription();
	public abstract void showPrice();
	
}

class ElectronicsProduct extends Product
{
	private String brand;
	private int yearOfManufacture;
	
	public ElectronicsProduct(String id, String name, double price, String brand, int yearOfManufacture) 
	{
        super(id ,name, price);
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
    }
	@Override
    public void showPrice() {
        System.out.println(this.getPrice());
    }

    @Override
    public void showDescription() {
        System.out.println("=> Electronics: " + this.getName() + "=> Brand: " + brand + " - $" + this.getPrice() + " => Year Of manufacture : "+ this.yearOfManufacture);
    }
}

class ClothingProduct extends Product
{
	private String size;
	private String typeOfCloth;
	
	public ClothingProduct(String id, String name, double price, String size, String typeOfCloth) {
        super(id, name, price);
        this.size = size;
        this.typeOfCloth = typeOfCloth;
    }
	
	@Override
    public void showPrice() {
        System.out.println(this.getPrice());
    }

    @Override
    public void showDescription() {
        System.out.println("=> Clothing : " + this.getName() + " => Size : " + this.size + " - $" + this.getPrice() + " => Type Of Cloth : "+ this.typeOfCloth);
    }
}


class BookProduct extends Product
{
	private String author;
	private int yearOfPublish;
	
	public BookProduct(String id, String name, double price, String author, int yearOfPublish) {
        super(id, name, price);
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }
	
	@Override
    public void showPrice() {
        System.out.println(this.getPrice());
    }

    @Override
    public void showDescription() {
        System.out.println("=> Book : " + this.getName() + " => author : " + this.author + " - $" + this.getPrice() + " => Year Of Publish : "+ this.yearOfPublish);
    }
}

class ShoppingCart 
{
	private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) 
    {
        products.add(product);
    }
    
    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Product product : products) {
            product.showDescription();
        }
    }
    
    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

public class ShoppingApplication 
{

	public static void main(String[] args) 
	{
		ShoppingCart cart = new ShoppingCart();
		
		cart.addProduct(new ElectronicsProduct("Mob123", "RealMe", 10000, "realme 3", 2020));
		cart.addProduct(new ClothingProduct("Clo234", "T-Shirt", 340,"32(L)", "Cotton"));
		cart.addProduct(new BookProduct("Book332", "Demon Slayer", 100, "kavi", 2024));
		
		cart.displayCart();
		System.out.println("Total Price in a Cart : "  + cart.calculateTotalPrice());
		
	}

}
