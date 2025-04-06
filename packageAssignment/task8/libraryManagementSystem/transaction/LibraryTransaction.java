package task8.libraryManagementSystem.transaction;


public interface LibraryTransaction 
{
	void borrowBook(String user, int book);
	void returnBook(String user, int book);
	void viewTransactions(String user);
}
