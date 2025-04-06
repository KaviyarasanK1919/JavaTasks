package task8.libraryManagementSystem.model;

public class Transaction {
	private int transactionID;
	private int bookID;
	private boolean bookStatus; // true = book borrowed , false = return (or) not buy
	
	public Transaction(int transactionID, int bookID, boolean bookStatus) {
		this.transactionID = transactionID;
		this.bookID = bookID;
		this.bookStatus = bookStatus;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public int getBookID() {
		return bookID;
	}

	public boolean isBookStatus() {
		return bookStatus;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	
}
