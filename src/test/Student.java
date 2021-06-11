package test;

public class Student extends Customer {

	private String school;

	public Student(String name, int birthDate, int idNumber, String address, String school) {
		super(name, birthDate, idNumber, address);
		this.school = school;
	}

	public Student(String name, int birthDate, int idNumber, String school) {
		super(name, birthDate, idNumber);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student [ Name= " + super.getName() + ", Birthdate= " + super.getDateOfBirth() + ", ID Number="
				+ super.getIdNumber() + ", School= " + this.getSchool() + " ]";
	}

}
