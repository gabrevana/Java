package company;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Company {

	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private int currentEmployee = 0;

	public Company() {

		employees.add(new Temp("Gabriel", 1, new OurDate(2, 12, 2014), 150000.0, new OurDate(31, 03, 2019)));
		employees.add(new Staff("Faustino", 2, new OurDate(18, 5, 2009), 40000.0, "Sales"));
		employees.add(new Manager("Araujo", 3, new OurDate(22, 2, 2010), 43269.0, "Vice President"));

	}

	/**
	 * Method instantiates subclasses of Employee
	 * <p>
	 * The method uses a switch statement. The condition is passed by empType. Each
	 * subclass is added to the employees Arraylist Otherwise returns null and no
	 * employee is added
	 * 
	 * @param name
	 * @param employeeNumber
	 * @param date
	 * @param salary
	 * @param emptype
	 * @return Employee
	 */
	public Employee addEmployee(String name, int employeeNumber, OurDate startDate, double salary, int empType) {

		switch (empType) {
		case 1:
			Manager manager = new Manager(name, employeeNumber, startDate, salary, "");

			return manager;
		case 2:
			Staff staff = new Staff(name, employeeNumber, startDate, salary, "");

			return staff;
		case 3:
			OurDate date = new OurDate();
			Temp temp = new Temp(name, employeeNumber, startDate, salary, date);

			return temp;
		}

		return null;

	}

	public int currentNumberEmployees() {
		return employees.size();

	}

	public boolean isMaximumEmployees() {
		try {
			employees.add(new Temp("Gabriel", 1, new OurDate(2, 12, 2014), 150000.0, new OurDate(31, 03, 2019)));
			employees.remove(employees.size() - 1);
			return false;
		} catch (OutOfMemoryError oome) {
			return true;
		}
	}

	public ArrayList<Employee> getEmployees() {
		return employees;

	}

	public Employee findSeniorEmployee() {

		Employee senior = employees.get(0);

		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getStartDate().getYear() == senior.getStartDate().getYear()) {

				if (employees.get(i).getStartDate().getMonth() == senior.getStartDate().getMonth()) {

					if (employees.get(i).getStartDate().getDay() < senior.getStartDate().getDay())
						senior = employees.get(i);

				} else if (employees.get(i).getStartDate().getMonth() < senior.getStartDate().getMonth())
					senior = employees.get(i);

			} else if (employees.get(i).getStartDate().getYear() < senior.getStartDate().getYear()) {
				senior = employees.get(i);

			}
		}

		return senior;
	}

	public Employee deleteEmployee(int empNum) {
		for (int i = 0; i < employees.size(); i++) {
			if (empNum == employees.get(i).getEmployeeNumber()) {
				Employee emp = employees.get(i);
				employees.remove(i);
				currentEmployee--;
				return emp;
			}
		}
		return null;
	}

	public Employee findEmployee(int empNum) {
		for (int i = 0; i < employees.size(); i++) {
			if (empNum == employees.get(i).getEmployeeNumber()) {
				currentEmployee = i;
				return employees.get(i);
			}
		}
		return null;
	}

	public void saveEmployeesToFile() throws BadInputException {
		ArrayList<Employee> tmp = getEmployees();
		try (FileOutputStream file = new FileOutputStream("CurrentEmployees.emp");
				ObjectOutputStream output = new ObjectOutputStream(file);) {
			for (Employee i : tmp) {
				output.writeObject(i);
			}

			System.out.printf("Serialized data is saved in CurrentEmployees.emp\n");
		} catch (IOException i) {
			i.printStackTrace();

		}

	}

	public void loadEmployeesFromFile() throws BadInputException {
		try {
			FileInputStream fileIn = new FileInputStream("CurrentEmployees.emp");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			try {
				while (true) {
					if (isMaximumEmployees()) {
						System.out.println("Maximum heap sized reached, unable to add new employees");
						break;
					}
					employees.add((Employee) in.readObject());
				}
			} catch (EOFException gx) {
				System.out.println("End of file reached; Serialized data is loaded");
			}

			in.close();
			fileIn.close();
		} catch (IOException rob) {
			rob.getMessage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public int getCurrentEmployeeValue() {
		return currentEmployee;
	}

	public void setCurrentEmployeeValue(int i) {
		if (i > (employees.size() - 1) || i < 0) {
			throw new BadInputException("End of list");
		} else {
			currentEmployee = i;
		}
	}

	public Employee getCurrentEmployee() {
		return employees.get(currentEmployee);
	}

}
