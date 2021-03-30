package company;

import java.util.Scanner;

public class Manager extends Employee {

	private static final long serialVersionUID = 1L;
	public String title;

	public Manager(String name, int emloyeeNumber, OurDate startDate, double salary, String title) {
		super(name, emloyeeNumber, startDate, salary);
		setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void loadExtraInfo() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter manager's title: ");
		String t = in.nextLine();
		in.close();
		setExtraInfo(t);
	}

	public void setExtraInfo(String s) {
		setTitle(s);
	}

	public String getExtraInfo() {
		return getTitle();
	}

	@Override
	public String toString() {

		String s = getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t\t" + getSalary()
				+ "\t\tTitle:" + title;

		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;
		Manager other = (Manager) obj;
		return (this.getName().equals(other.getName()) && this.getEmployeeNumber() == other.getEmployeeNumber()
				&& this.getStartDate().equals(other.getStartDate()) && this.getTitle().equals(other.getTitle()));
	}

}
