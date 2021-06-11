package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

/*
 * CSE2062 Object Oriented Programming Project #2
 * 
 * Aykut Büyükkaya 150719040
 * Omer Ulu 150718852
 * 
 * */
public class main {

	static JFrame mainScreenFrame = new JFrame();
	static JPanel centerPanel = new JPanel();
	static JPanel east = new JPanel();
	static JPanel west = new JPanel();
	static JPanel north = new JPanel();
	static JPanel south = new JPanel();

	static Library library = new Library("Istanbul Maltepe Kütüphanesi");

	public static void main(String args[]) {

		initializeMainScreenComponents();
		addSampleData();

		mainScreenFrame.setVisible(true);

	}

	static void initializeMainScreenComponents() {

		mainScreenFrame.setTitle("CSE2062 Object-Oriented Programming Project");
		mainScreenFrame.setLayout(new BorderLayout(20, 10));
		mainScreenFrame.setSize(new Dimension(600, 800));

		south.setPreferredSize(new Dimension(400, 100));
		north.setPreferredSize(new Dimension(400, 75));
		east.setPreferredSize(new Dimension(50, 600));
		west.setPreferredSize(new Dimension(50, 600));

		centerPanel.setLayout(new GridLayout(3, 2, 50, 50));

		south.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainScreenButtons();

		mainScreenFrame.add(north, BorderLayout.NORTH);
		mainScreenFrame.add(south, BorderLayout.SOUTH);
		mainScreenFrame.add(centerPanel, BorderLayout.CENTER);
		mainScreenFrame.add(west, BorderLayout.WEST);
		mainScreenFrame.add(east, BorderLayout.EAST);

	}

	static void mainScreenButtons() {

		JButton bookList = new JButton("See Book List");
		JButton libraryStaff = new JButton("See Library Staff");
		JButton seeCustomers = new JButton("See Customers");
		JButton addNewBook = new JButton("Add New Book");
		JButton addNewCustomer = new JButton("Add New Customer");
		JButton fileReadingOps = new JButton("File Reading Operations");
		JButton borrowReturnButton = new JButton("Book Borrowing and Returning");

		borrowReturnButton.setPreferredSize(new Dimension(400, 75));

		borrowReturnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showBorrowReturnFrame();
			}
		});

		bookList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showBookListFrame();

			}
		});

		libraryStaff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showStaffFrame();

			}
		});

		seeCustomers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showCustomerFrame();
			}
		});

		addNewBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showAddBookFrame();
			}
		});

		addNewCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showAddCustomerFrame();
			}
		});

		fileReadingOps.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showReadingWritingOpsFrame();
			}
		});
		centerPanel.add(bookList);
		centerPanel.add(libraryStaff);
		centerPanel.add(seeCustomers);
		centerPanel.add(addNewBook);
		centerPanel.add(addNewCustomer);
		centerPanel.add(fileReadingOps);

		south.add(borrowReturnButton);

	}

	static void showBorrowReturnFrame() {

		JFrame borrowReturnFrame = new JFrame();
		JPanel borrowReturnPanel = new JPanel();
		borrowReturnFrame.setTitle("Book Borrowing And Returning Screen");
		borrowReturnFrame.setSize(600, 400);

		JTextField bookName = new JTextField(20);
		JTextField customerName = new JTextField(20);

		JButton borrowBook = new JButton("Borrow Book");
		JButton returnBook = new JButton("Return Book");

		JLabel errorLabel = new JLabel();

		borrowBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				library.borrowBook(customerName.getText(), bookName.getText(), errorLabel);
			}
		});

		returnBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				library.returnBook(customerName.getName(), bookName.getName(), errorLabel);
			}
		});

		borrowReturnPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;

		borrowReturnPanel.add(new JLabel("Book Name :"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;

		borrowReturnPanel.add(bookName);

		gbc.gridx = 0;
		gbc.gridy = 1;

		borrowReturnPanel.add(new JLabel("Customer Name :"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;

		borrowReturnPanel.add(customerName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;

		borrowReturnPanel.add(borrowBook, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;

		borrowReturnPanel.add(returnBook, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;

		borrowReturnPanel.add(errorLabel, gbc);

		borrowReturnFrame.add(borrowReturnPanel);
		borrowReturnFrame.setVisible(true);

	}

	static void showReadingWritingOpsFrame() {

		FileWriterReader rw = new FileWriterReader();

		JFrame rwMainFrame = new JFrame();
		JPanel rwMainPanel = new JPanel();
		rwMainFrame.setTitle("File Reading And Writing Operations Screen");
		rwMainFrame.setSize(1000, 400);

		JButton readFile = new JButton("Read data");
		JButton writeFile = new JButton("Write data");
		JButton printFile = new JButton("Print existing data");

		JLabel pathLabel = new JLabel();

		JFileChooser f = new JFileChooser(Paths.get(".").toAbsolutePath().normalize().toString());

		f.setVisible(false);
		readFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(true);
				int result = f.showOpenDialog(f);

				if (result == JFileChooser.APPROVE_OPTION) {

					File selectedFile = f.getSelectedFile();
					pathLabel.setText("Current Path:" + selectedFile.getAbsolutePath());
					f.setVisible(false);

					rw.selectPath(f.getSelectedFile().getAbsolutePath().toString());
					try {
						rw.readData(library);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		writeFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(true);
				int result = f.showSaveDialog(f);

				if (result == JFileChooser.APPROVE_OPTION) {

					pathLabel.setText("Current Path:" + f.getSelectedFile().getAbsolutePath());
					f.setVisible(false);

					rw.selectPath(f.getSelectedFile().getAbsolutePath().toString());

					try {
						rw.writeData(library);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});

		printFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(true);
				int result = f.showSaveDialog(f);

				if (result == JFileChooser.APPROVE_OPTION) {

					pathLabel.setText("Current Path:" + f.getSelectedFile().getAbsolutePath());
					f.setVisible(false);
					rw.selectPath(f.getSelectedFile().getAbsolutePath().toString());

					try {
						rw.exportDataList(library);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		rwMainPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		rwMainPanel.add(f);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		pathLabel.setText("Current Path:");
		rwMainPanel.add(pathLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		rwMainPanel.add(readFile, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		rwMainPanel.add(writeFile, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		rwMainPanel.add(printFile, gbc);

		rwMainFrame.add(rwMainPanel);
		rwMainFrame.setVisible(true);
	}

	static void showCustomerFrame() {

		JFrame customerFrame = new JFrame();
		String[] header = { "Name", "Birth Date", "ID Number", "Address", "Borrowed Book", "School" };
		JTable table = new JTable(library.returnCustomerString(), header);
		
		table.setBounds(30, 40, 400, 300);

		JScrollPane sp = new JScrollPane(table);
		
		customerFrame.setTitle("Customers List Screen");
		customerFrame.add(sp);
		customerFrame.setSize(600, 800);
		customerFrame.setVisible(true);
	}

	static void showStaffFrame() {

		JFrame staffFrame = new JFrame();
		String[] header = { "Name", "Birth Date", "ID Number", "Position" };
		JTable table = new JTable(library.returnEmployeeString(), header);
		
		table.setBounds(30, 40, 400, 300);

		JScrollPane sp = new JScrollPane(table);

		staffFrame.setTitle("Library Staff List Screen");
		staffFrame.add(sp);
		staffFrame.setSize(600, 800);
		staffFrame.setVisible(true);
	}

	static void showBookListFrame() {

		JFrame bookListFrame = new JFrame();
		String[] header = { "Book Name", "Author", "Book Id", "Status" };
		JTable table = new JTable(library.returnBookString(), header);
		table.setBounds(30, 40, 400, 300);

		JScrollPane sp = new JScrollPane(table);

		bookListFrame.setTitle("Book List Screen");
		bookListFrame.add(sp);
		bookListFrame.setSize(600, 800);
		bookListFrame.setVisible(true);

	}

	static void showAddCustomerFrame() {

		JFrame addCustomerFrame = new JFrame();
		JPanel addCustomerPanel = new JPanel();

		JTextField customerName = new JTextField(20);
		JTextField customerBirthDate = new JTextField(20);
		JTextField customerIdNumber = new JTextField(20);
		JTextField customerAddress = new JTextField(20);
		JTextField studentSchool = new JTextField(20);

		JLabel addressLabel = new JLabel("Address");
		JLabel schoolLabel = new JLabel("School");

		JButton addNewCustomer = new JButton("ADD NEW CUSTOMER");

		JLabel errorLabel = new JLabel();

		schoolLabel.setVisible(false);
		studentSchool.setVisible(false);
		addCustomerFrame.setTitle("Customer Registering Screen");
		
		JCheckBox isStudent = new JCheckBox("Select this if customer is a Student");

		isStudent.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (isStudent.isSelected()) {

					schoolLabel.setVisible(true);
					studentSchool.setVisible(true);

				}

				else {

					schoolLabel.setVisible(false);
					studentSchool.setVisible(false);

				}
			}
		});

		addNewCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {

					String name = customerName.getText();
					int birthDate = Integer.parseInt(customerBirthDate.getText());
					int idNumber = Integer.parseInt(customerIdNumber.getText());
					String address = customerAddress.getText();

					if (isStudent.isSelected()) {

						String school = studentSchool.getText();

						library.addCustomer(new Student(name, birthDate, idNumber, address, school));
						errorLabel.setText("A new Student Successfully added!");
						errorLabel.setForeground(Color.GREEN);
					}

					else {

						library.addCustomer(new Customer(name, birthDate, idNumber, address));
						errorLabel.setText("A New Customer Successfully added!");
						errorLabel.setForeground(Color.GREEN);
					}

				} catch (NumberFormatException e2) {
					// TODO: handle exception
					errorLabel.setText("Error! ID or Birth Date has to be integer values!");
					errorLabel.setForeground(Color.RED);

				} catch (Exception e1) {
					// TODO: handle exception
					errorLabel.setText("An Error Occured");
					errorLabel.setForeground(Color.RED);
					e1.printStackTrace();
				}

			}
		});

		addCustomerFrame.setSize(400, 600);

		addCustomerPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;

		addCustomerPanel.add(new JLabel("Name: "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;

		addCustomerPanel.add(customerName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		addCustomerPanel.add(new JLabel("Birth Date: "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;

		addCustomerPanel.add(customerBirthDate, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;

		addCustomerPanel.add(new JLabel("ID number: "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;

		addCustomerPanel.add(customerIdNumber, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;

		addCustomerPanel.add(addressLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;

		addCustomerPanel.add(customerAddress, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;

		addCustomerPanel.add(schoolLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;

		addCustomerPanel.add(studentSchool, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;

		addCustomerPanel.add(isStudent, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;

		addCustomerPanel.add(addNewCustomer, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;

		addCustomerPanel.add(errorLabel, gbc);

		addCustomerFrame.add(addCustomerPanel);
		addCustomerFrame.setVisible(true);
	}

	static void showAddBookFrame() {

		JFrame addBookFrame = new JFrame();
		JPanel addBookPanel = new JPanel();

		addBookFrame.setTitle("Book Registering Screen");
		
		JTextField bookTitle = new JTextField(20);
		JTextField bookAuthor = new JTextField(20);
		JTextField bookID = new JTextField(20);

		JLabel errorLabel = new JLabel();
		JButton addNewBook = new JButton("ADD NEW BOOK");

		addNewBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					String title = bookTitle.getText();
					String Author = bookAuthor.getText();
					int id = Integer.parseInt(bookID.getText());
					library.addBook(new Book(id, Author, title));
					errorLabel.setText("Book successfully added to the list!");
					errorLabel.setForeground(Color.green);
					bookTitle.setText("");
					bookAuthor.setText("");
					bookID.setText("");

				} catch (NumberFormatException IdFieldException) {
					// TODO: handle exception
					System.out.println("please enter a number");
					errorLabel.setText("ID value has to be an integer!");
					errorLabel.setForeground(Color.red);
				}

				catch (Exception e2) {
					e2.printStackTrace();
					errorLabel.setText("An Error has occured!");
					errorLabel.setForeground(Color.red);
				}
			}
		});

		addBookFrame.setSize(400, 600);

		addBookPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;

		addBookPanel.add(new JLabel("Title   "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;

		addBookPanel.add(bookTitle, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		addBookPanel.add(new JLabel("Author   "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;

		addBookPanel.add(bookAuthor, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;

		addBookPanel.add(new JLabel("ID   "), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;

		addBookPanel.add(bookID, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;

		addBookPanel.add(addNewBook, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;

		addBookPanel.add(errorLabel, gbc);

		addBookFrame.add(addBookPanel);
		addBookFrame.setVisible(true);
	}

	static void addSampleData() {

		
		
		library.addBook(new Book(546378, "George Orwell", "1984"));
		library.addBook(new Book(776348, "Sun Tzu", "Art Of War"));		
		library.addBook(new Book(856134, "J. R. R. Tolkien", "The Lord of the Rings"));

		
		library.addCustomer(new Customer("Volkan Demirel", 1981, 656986, "Fenerbahçe"));
		library.addCustomer(new Customer("Conor McGregor", 1988, 693145, "Dublin, Ireland"));
		

		library.addStaff(new Employee("Alperen Bebek", 1999, 547632226, "Librarian"));
		library.addStaff(new Employee("Aykut Büyükkaya", 2001, 986321547, "Library Director"));
		library.addStaff(new Employee("Omar Ulu", 1999, 199865247, "Library Archivist"));
		library.addStaff(new Employee("Gokay Bayram", 1998, 245876321, "Library Technician"));
	}

}
