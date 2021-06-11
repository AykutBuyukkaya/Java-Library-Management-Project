package test;

public class Book implements Borrowable, Comparable<Book> {

	private int id;
	private String author;
	private String title;

	private boolean isBorrowed = false;
	private Customer borrowedBy = null;
	private static int totalNumOfBooks = 0;

	public Book(int id, String author, String title) {

		this.id = id;
		this.author = author;
		this.title = title;
		totalNumOfBooks++;
	}

	public Book(int id, String title) {

		this.id = id;
		this.title = title;
		author = "unknown";
		totalNumOfBooks++;
	}

	@Override
	public int compareTo(Book b1) {
		return this.title.compareTo(b1.title);
	}

	@Override
	public void borrowThisBook(Customer customer) {
		this.isBorrowed = true;
		this.borrowedBy = customer;

	}

	@Override
	public void returnThisBook() {
		this.borrowedBy = null;
		this.isBorrowed = false;

	}

	public static int getTotalNumOfBooks() {
		return totalNumOfBooks;
	}

	public static void setTotalNumOfBooks(int totalNumOfBooks) {
		Book.totalNumOfBooks = totalNumOfBooks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public Customer getBorrowedBy() {
		return borrowedBy;
	}

	public void setBorrowedBy(Customer borrowedBy) {
		this.borrowedBy = borrowedBy;
	}

	
	@Override
	public String toString() {
		if (borrowedBy == null) {
			return "Book [ ID= " + id + ", Author= " + author + ", Title= " + title +" ]";
		} else {

			return "Book [ ID= " + id + ", Author= " + author + ", Title= " + title + ", Borrowed by= " + borrowedBy.getName()
					+ " ]";

		}

	}

}
