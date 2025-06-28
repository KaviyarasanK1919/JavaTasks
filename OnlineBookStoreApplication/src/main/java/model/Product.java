package model;

public class Product {
	private int id, price;
	private String bookName, authorName, imageLink,category;
	private int quantity;
	public Product()
	{
		
	}
	public Product(int id, int price, String bookName, String authorName, String imageLink, String category) {
		super();
		this.id = id;
		this.price = price;
		this.bookName = bookName;
		this.authorName = authorName;
		this.imageLink = imageLink;
		this.category = category;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int salary) {
		this.price = salary;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setQuantity(int q)
	{
		this.quantity = q;;
	}
	public int getQuantity()
	{
		return quantity;
	}
}
