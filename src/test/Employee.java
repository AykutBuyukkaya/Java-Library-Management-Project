package test;

public class Employee extends Person {

	private String position;

	static int totalNumberOfEmployees;
	public Employee(String name, int birthDate, int idNumber, String position) {
		super(name, birthDate, idNumber);
		this.position = position;
		totalNumberOfEmployees++;
	}

	
	
	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public static int getTotalNumberOfEmployees() {
		return totalNumberOfEmployees;
	}



	public static void setTotalNumberOfEmployees(int totalNumberOfEmployees) {
		Employee.totalNumberOfEmployees = totalNumberOfEmployees;
	}


	

	@Override
	public String toString() {

		return "Employee [ "+super.toString() + ", Position= " + position+" ]";
	}

}
