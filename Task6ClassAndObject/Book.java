package Task6ClassAndObject;

public class Book {
	private String id;
    private String title;
    private String author;
    private double price;
    private String isbn;
    
    

	private static int totalBooks = 0;
    
    public Book() {
        totalBooks++;
    }
	public Book(String id, String title, String author, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		totalBooks++;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public double getPrice() {
		return price;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public static int getTotalBooks() {
        return totalBooks;
    }
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", isbn=" + isbn
				+ "]";
	}
}
