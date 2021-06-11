package test;

public class Customer extends Person {

	private String address = null;
	private Book borrowedBook;
	private static int numberOfCustomers;

	public Customer(String name, int birthDate, int idNumber) {
		super(name, birthDate, idNumber);
		numberOfCustomers++;
	}

	public Customer(String name, int birthDate, int idNumber, String address) {
		super(name, birthDate, idNumber);
		this.address = address;
		numberOfCustomers++;
	}

	public Book getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(Book borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public static void setNumberOfCustomers(int numberOfCustomers) {
		Customer.numberOfCustomers = numberOfCustomers;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(this.address == null) {
			return "Customer [ "+ super.toString()+" ]";
		}
		else {
			return "Customer [ " + super.toString() + ", Address= " + this.address+" ]";
		}
		
	}

}
