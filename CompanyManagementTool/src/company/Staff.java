package company;

import java.util.Scanner;


public class Staff extends Employee {

	private static final long serialVersionUID = 1L;
	private String department;
	
	
	public Staff(String name, int emloyeeNumber, OurDate startDate, double salary, String department) {
		super(name, emloyeeNumber, startDate, salary);
		setDepartment(department);
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void loadExtraInfo() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the department: ");
		String t = in.nextLine();
		in.close();
		setExtraInfo(t);
	}
	
	public void setExtraInfo(String s) {
		setDepartment(s);
	}
	
	public String getExtraInfo() {
		return getDepartment();
	}
	
	@Override
	public String toString() {

		String s = getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t\t" + getSalary() + "\t\tTitle:" + department;

		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Staff other = (Staff) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate()) && this.getDepartment() == other.getDepartment());
	}

}