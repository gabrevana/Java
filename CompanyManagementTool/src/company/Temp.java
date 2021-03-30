package company;

import java.util.Scanner;

public class Temp extends Employee {

	private static final long serialVersionUID = 1L;
	private OurDate endContractDate;

	public Temp(String name, int emloyeeNumber, OurDate startDate, double salary, OurDate endContractDate) {
		super(name, emloyeeNumber, startDate, salary);
		setEndContractDate(endContractDate);
	}

	public OurDate getEndContractDate() {
		return endContractDate;
	}

	public void setEndContractDate(OurDate endContractDate) {
		this.endContractDate = endContractDate;
	}

	@Override
	public void loadExtraInfo() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the contract end date: ");
		System.out.print("YEAR: ");
		int year = in.nextInt();

		System.out.print("MONTH: ");
		int month = in.nextInt();

		System.out.print("DAY: ");
		int day = in.nextInt();
		in.close();
		OurDate temp = new OurDate(day, month, year);
		setExtraInfo(temp);
	}

	public void setExtraInfo(OurDate s) {
		setEndContractDate(s);
	}

	public String getExtraInfo() {
		return getEndContractDate().toString();
	}

	@Override
	public String toString() {
		String s = getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t\t" + getSalary()
				+ "\t\tEnd of Contract:" + endContractDate;
		return s;
	}

	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;
		Temp other = (Temp) obj;
		return (this.getName().equals(other.getName()) && this.getEmployeeNumber() == other.getEmployeeNumber()
				&& this.getStartDate().equals(other.getStartDate())
				&& this.getEndContractDate().equals(other.getEndContractDate()));
	}

	@Override
	public void setExtraInfo(String s) {
	}
}
