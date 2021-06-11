package test;

abstract class Person {

	private String name;
	private int birthDate;
	private int idNumber;

	public Person(String name, int birthDate, int idNumber) {

		this.name = name;
		this.birthDate = birthDate;
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDateOfBirth() {
		return birthDate;
	}

	public void setDateOfBirth(int birthDate) {
		this.birthDate = birthDate;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Name= " + name + ", Birthdate= " + birthDate + ", ID Number= " + idNumber;
	}

	

}
