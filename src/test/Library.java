package test;

import java.awt.Color;
import java.util.*;

import javax.swing.JLabel;

public class Library {

	// Initializing variables
	static private String address;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Employee> staff = new ArrayList<Employee>();
	private ArrayList<Book> books = new ArrayList<Book>();

	// Single constructor
	Library(String address) {

		this.address = address;

	}

	// Printing Library details
	public void printLibraryDetails() {

		System.out.println("Library Address =" + address + "\nThis library is open between 07.00 AM to 11.00 PM\n"
				+ "There are currently " + Book.getTotalNumOfBooks() + " books," + Customer.getNumberOfCustomers()
				+ " customers and " + Employee.totalNumberOfEmployees + " employees at this library.");

	}

	// Adding a customer to the customers arraylist
	public void addCustomer(Customer customer) {

		customers.add(customer);

	}

	// Adding a Employee to the staff arraylist
	public void addStaff(Employee employee) {

		staff.add(employee);

	}

	// Printing the data of employees at staff ArrayList
	public void printStaff() {

		for (Employee i : staff) {
			System.out.println(i.toString());
		}

	}

	// Printing the data of Customers at customers ArrayList
	public void printCustomers() {

		for (Customer i : customers) {

			System.out.println(i.toString());

		}

	}

	// Adding a book to the books ArrayList
	public void addBook(Book b1) {

		books.add(b1);
		Collections.sort(books);

	}

	// Printing books that exist in Books ArrayList
	public void printBooks() {

		for (Book b1 : books) {

			System.out.println(b1.toString());
		}

	}

	// Book borrowing process
	public void borrowBook(String customerName, String bookName, JLabel label) {
		boolean bookFound = false;
		boolean customerFound = false;
		Customer c1 = null;
		Book b1 = null;

		for (Customer i : customers) {

			if (i.getName().equals(customerName)) {

				customerFound = true;
				c1 = i;

			}

		}

		for (Book i : books) {

			if (i.getTitle().equals(bookName)) {

				bookFound = true;
				b1 = i;
			}

		}

		if (bookFound == true && customerFound == true) {

			if (b1.isBorrowed() == true) {
				label.setForeground(Color.RED);
				label.setText("This book is borrowed by " + b1.getBorrowedBy().getName() + "!");
			}

			else if (c1.getBorrowedBook() != null) {
				label.setForeground(Color.RED);
				label.setText("Customer already borrowed a book!");

			}

			else {

				b1.borrowThisBook(c1);
				c1.setBorrowedBook(b1);
				label.setForeground(Color.GREEN);
				label.setText("Customer " + c1.getName() + " has successfully borrowed " + b1.getTitle() + ".");
			}

		} else if (bookFound == false && customerFound == false) {

			label.setForeground(Color.RED);
			label.setText("Customer and Book cannot be found!");

		} else if (bookFound == false) {

			label.setForeground(Color.RED);
			label.setText("Customer found but Book cannot be found!");

		}

		else if (customerFound == false) {

			label.setForeground(Color.RED);
			label.setText("Book found but Customer cannot be found");

		}

	}

	// Book returning process
	public void returnBook(String customerName, String bookName, JLabel label) {
		boolean bookFound = false;
		boolean customerFound = false;
		Customer c1 = null;
		Book b1 = null;

		for (Customer i : customers) {

			if (i.getName().equals(customerName)) {

				customerFound = true;
				c1 = i;

			}

		}

		for (Book i : books) {

			if (i.getTitle().equals(bookName)) {

				bookFound = true;
				b1 = i;
			}

		}

		if (bookFound == true && customerFound == true) {

			if (b1.isBorrowed() == false) {
				label.setForeground(Color.RED);
				label.setText("This book is not borrowed. ");
			}

			else if (c1.getBorrowedBook() == null) {
				label.setForeground(Color.RED);
				label.setText("Customer hasn't borrowed a book.");

			}

			else {

				b1.returnThisBook();
				c1.setBorrowedBook(null);
				label.setForeground(Color.RED);
				label.setText("Customer " + c1.getName() + " has successfully returned " + b1.getTitle() + ".");
			}

		} else if (bookFound == false && customerFound == false) {

			label.setForeground(Color.RED);
			label.setText("Customer and Book cannot be found!");

		} else if (bookFound == false) {

			label.setForeground(Color.RED);
			label.setText("Customer found but Book cannot be found!");

		}

		else if (customerFound == false) {

			label.setForeground(Color.RED);
			label.setText("Book found but Customer cannot be found");

		}

	}

	public String[][] returnCustomerString() {

		String[][] result = new String[customers.size()][6];

		for (int i = 0; i < customers.size(); i++) {

			result[i][0] = customers.get(i).getName();
			result[i][1] = String.valueOf(customers.get(i).getDateOfBirth());
			result[i][2] = String.valueOf(customers.get(i).getIdNumber());

			if (customers.get(i).getAddress() == null) {

				result[i][3] = "Address Unkown";

			}

			else {

				result[i][3] = customers.get(i).getAddress();

			}

			if (customers.get(i).getBorrowedBook() == null) {

				result[i][4] = "Not Borrowed A Book";

			}

			else {

				result[i][4] = customers.get(i).getBorrowedBook().getTitle();

			}

			if (customers.get(i) instanceof Student) {

				result[i][5] = ((Student) customers.get(i)).getSchool();

			}

			else {

				result[i][5] = "Not a Student.";
			}
		}

		return result;

	}

	public String[][] returnEmployeeString() {

		String[][] result = new String[staff.size()][4];

		for (int i = 0; i < staff.size(); i++) {

			result[i][0] = staff.get(i).getName();
			result[i][1] = String.valueOf(staff.get(i).getDateOfBirth());
			result[i][2] = String.valueOf(staff.get(i).getIdNumber());
			result[i][3] = staff.get(i).getPosition();

		}

		return result;

	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Employee> getStaff() {
		return staff;
	}

	public void setStaff(ArrayList<Employee> staff) {
		this.staff = staff;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public String[][] returnBookString() {

		String[][] result = new String[books.size()][5];
		for (int i = 0; i < books.size(); i++) {

			result[i][0] = books.get(i).getTitle();
			result[i][1] = books.get(i).getAuthor();
			result[i][2] = String.valueOf(books.get(i).getId());
			if (books.get(i).isBorrowed() == true) {
				result[i][3] = "Borrowed by " + books.get(i).getBorrowedBy().getName();
			}

			else {

				result[i][3] = "Not borrowed";

			}
		}
		return result;
	}

}
