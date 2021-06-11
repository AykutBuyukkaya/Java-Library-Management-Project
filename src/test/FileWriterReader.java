package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterReader {

	private String path;

	public void writeData(Library library) throws IOException {

		FileWriter writeFile = new FileWriter(path + ".txt");

		String buffer = "";

		for (Book i : library.getBooks()) {

			if (i.getBorrowedBy() == null) {

				buffer = "Book\n" + i.getTitle() + "\n" + i.getAuthor() + "\n" + i.getId() + "\n\n";

			}

			else {

				buffer = "Book\n" + i.getTitle() + "\n" + i.getAuthor() + "\n" + i.getId() + "\n\n";

			}

			writeFile.write(buffer);

		}

		for (Customer i : library.getCustomers()) {

			if (i instanceof Student) {

				if (i.getBorrowedBook() == null) {

					buffer = "Student\n" + i.getName() + "\n" + i.getIdNumber() + "\n" + i.getDateOfBirth() + "\n"
							+ i.getAddress() + "\n" + ((Student) i).getSchool() + "\n\n";

				}

				else {

					buffer = "Student\n" + i.getName() + "\n" + i.getIdNumber() + "\n" + i.getDateOfBirth() + "\n"
							+ i.getAddress() + "\n" + ((Student) i).getSchool() + "\n\n";

				}

			}

			else {

				if (i.getBorrowedBook() == null) {

					buffer = "Customer\n" + i.getName() + "\n" + i.getIdNumber() + "\n" + i.getDateOfBirth() + "\n"
							+ i.getAddress() + "\n\n";

				}

				else {

					buffer = "Customer\n" + i.getName() + "\n" + i.getIdNumber() + "\n" + i.getDateOfBirth() + "\n"
							+ i.getAddress() + "\n\n";

				}

			}

			writeFile.write(buffer);

		}

		writeFile.close();
	}

	public void readData(Library library) throws FileNotFoundException {

		File reader = new File(path);
		Scanner scan = new Scanner(reader);

		String temp = "";

		while (scan.hasNextLine()) {

			temp = scan.nextLine();

			if (temp.equals("Book")) {

				String title = scan.nextLine();
				String author = scan.nextLine();
				int id = Integer.parseInt(scan.nextLine());

				library.addBook(new Book(id, author, title));

			}

			else if (temp.equals("Customer")) {

				String name = scan.nextLine();
				int id = Integer.parseInt(scan.nextLine());
				int birthDate = Integer.parseInt(scan.nextLine());
				String address = scan.nextLine();

				library.addCustomer(new Customer(name, birthDate, id, address));

			}

			else if (temp.equals("Student")) {

				String name = scan.nextLine();
				int id = Integer.parseInt(scan.nextLine());
				int birthDate = Integer.parseInt(scan.nextLine());
				String address = scan.nextLine();
				String school = scan.nextLine();

				library.addCustomer(new Student(name, birthDate, id, address, school));

			}

		}

	}

	public void exportDataList(Library library) throws IOException {

		FileWriter writeFile = new FileWriter(path + ".txt");

		String buffer = "";

		for (Book i : library.getBooks()) {

			buffer = i.toString() + "\n";
			writeFile.write(buffer);

		}

		for (Customer i : library.getCustomers()) {

			buffer = i.toString() + "\n";
			writeFile.write(buffer);

		}

		writeFile.close();

	}

	public void selectPath(String path) {

		this.path = path;

	}
}
