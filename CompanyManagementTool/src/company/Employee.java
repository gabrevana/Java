package company;

import java.io.Serializable;

public abstract class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int employeeNumber;
	private OurDate startDate;
	private double salary;


	public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		setName(name);
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
	}

	public OurDate getStartDate() {
		return startDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	private void setStartDate(OurDate startDate) {
		this.startDate = startDate;
	}

	public double getSalary() {
		return salary;
	}

	private void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {

		String s = name + "\t\t" + employeeNumber + "\t\t" + startDate + "\t\t" + salary;

		return s;

	}

	@Override
	public boolean equals(Object obj) {

		if (getClass() == null || obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		Employee e = (Employee) obj;

		return (this.getName() == e.getName() && this.getStartDate() == e.getStartDate()
				&& this.getEmployeeNumber() == e.getEmployeeNumber() && this.getSalary() == e.getSalary());

	}

	public abstract void loadExtraInfo();
	public abstract String getExtraInfo();
	public abstract void setExtraInfo(String s);

}
