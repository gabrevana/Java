package company;

import java.awt.*;
import javax.swing.*;

public class GUICompanyConsole extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int screenX, screenY;
	private Company startUp;

	public static void main(String[] args) {

		Toolkit tk = Toolkit.getDefaultToolkit(); // get handle to AWT
		Dimension screenSize = tk.getScreenSize(); // get the screensize from Toolkit
		screenX = (int) screenSize.getWidth() / 2;
		screenY = (int) screenSize.getHeight() / 2;
		new GUICompanyConsole().new LoadJFrame();

	}

	private class GBAssist extends GridBagConstraints {

		private static final long serialVersionUID = 1L;

		public GBAssist() {
			gridx = 0;
			gridy = 0;
		}

		public GBAssist setGrid(int x, int y, Dimension d) {
			gridx = x;
			gridy = y;
			gridwidth = (int) d.getWidth();
			gridheight = (int) d.getHeight();
			return this;
		}
	}

	public class LoadJFrame extends JFrame {

		private static final long serialVersionUID = 1L;
		private JButton addManagerEmployeeBtn = new JButton("Add New Manager"),
				addStaffEmployeeBtn = new JButton("Add New Staff"),
				addTempEmployeeBtn = new JButton("Add New Temp Employee"),
				deleteEmployeeBtn = new JButton("Delete Current Employee"),
				findEmployeeBtn = new JButton("Find Employee"), nextEmployeeBtn = new JButton("Next Employee"),
				previousEmployeeBtn = new JButton("Previous Employee"),
				saveToFileBtn = new JButton("Save Employees to File"),
				loadFromFileBtn = new JButton("Load Employees from File");

		private JLabel empName = new JLabel("Name"), empNumber = new JLabel("Number"),
				empStartDate = new JLabel("Start Date"), empSalary = new JLabel("Salary"),
				empExtraInfo = new JLabel("Special Information");

		private JTextArea txtName = new JTextArea(""), txtNumber = new JTextArea(""), txtStartDate = new JTextArea(""),
				txtSalary = new JTextArea(""), txtExtraInfo = new JTextArea("");

		private JPanel empPanel = new JPanel(), fileIOPanel = new JPanel(), empInfoPanel = new JPanel();

		private Dimension buttonSize = new Dimension(screenX / 4, screenY / 9),
				labelSize = new Dimension(screenX / 8, screenY / 9),
				txtSize = new Dimension((int) (screenX / 2.5), screenY / 9);

		private LoadJFrame() {
			startUp = new Company();
			JFrame frame = new JFrame();
			frame.setTitle("Company Management Tool"); // set title at top of frame
			frame.setResizable(true); // frame is fixed size
			frame.setLocationRelativeTo(this); // default location to centre of screen
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loadPanels();
			loadButtonHandlers(frame);
			frame.add(empPanel, BorderLayout.EAST);
			frame.add(empInfoPanel, BorderLayout.CENTER);
			frame.add(fileIOPanel, BorderLayout.SOUTH);
			frame.pack();
			frame.setVisible(true);
		}

		private void loadPanels() {
			GBAssist c = new GBAssist();
			empPanel.setLayout(new GridLayout(7, 1, 10, 10));
			loadButton(empPanel, addManagerEmployeeBtn, buttonSize, 16);
			loadButton(empPanel, addStaffEmployeeBtn, buttonSize, 16);
			loadButton(empPanel, addTempEmployeeBtn, buttonSize, 16);
			loadButton(empPanel, deleteEmployeeBtn, buttonSize, 16);
			loadButton(empPanel, findEmployeeBtn, buttonSize, 16);
			loadButton(empPanel, nextEmployeeBtn, buttonSize, 16);
			loadButton(empPanel, previousEmployeeBtn, buttonSize, 16);
			empPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

			fileIOPanel.setLayout(new GridLayout(1, 2, 10, 10));
			loadButton(fileIOPanel, saveToFileBtn, buttonSize, 16);
			loadButton(fileIOPanel, loadFromFileBtn, buttonSize, 16);
			fileIOPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

			empInfoPanel.setLayout(new GridLayout(10, 0, 2, 10));
			empInfoPanel.setPreferredSize(new Dimension(screenX / 2, screenY / 2));
			empInfoPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

			empInfoPanel.add(empName, c.setGrid(0, 0, labelSize));
			empName.setFont(new Font("SansSerif", Font.PLAIN, 16));
			empInfoPanel.add(txtName, c.setGrid(1, 0, txtSize));
			txtName.setFont(new Font("SansSerif", Font.PLAIN, 20));

			empInfoPanel.add(empNumber, c.setGrid(2, 0, labelSize));
			empNumber.setFont(new Font("SansSerif", Font.PLAIN, 16));
			empInfoPanel.add(txtNumber, c.setGrid(3, 0, txtSize));
			txtNumber.setFont(new Font("SansSerif", Font.PLAIN, 20));

			empInfoPanel.add(empStartDate, c.setGrid(4, 0, labelSize));
			empStartDate.setFont(new Font("SansSerif", Font.PLAIN, 16));
			empInfoPanel.add(txtStartDate, c.setGrid(5, 0, txtSize));
			txtStartDate.setFont(new Font("SansSerif", Font.PLAIN, 20));

			empInfoPanel.add(empSalary, c.setGrid(6, 0, labelSize));
			empSalary.setFont(new Font("SansSerif", Font.PLAIN, 16));
			empInfoPanel.add(txtSalary, c.setGrid(7, 0, txtSize));
			txtSalary.setFont(new Font("SansSerif", Font.PLAIN, 20));

			empInfoPanel.add(empExtraInfo, c.setGrid(8, 0, labelSize));
			empExtraInfo.setFont(new Font("SansSerif", Font.PLAIN, 16));
			empInfoPanel.add(txtExtraInfo, c.setGrid(9, 0, txtSize));
			txtExtraInfo.setFont(new Font("SansSerif", Font.PLAIN, 20));

		}

		private void loadButton(JPanel p, JButton btn, Dimension d, int fontSize) {
			p.add(btn);
			btn.setPreferredSize(d);
			btn.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
		}

		public String getNameFromTextArea() {
			return txtName.getText();
		}

		public int getNumberFromTextArea() {
			return Integer.parseInt(txtNumber.getText());
		}

		public OurDate getStartDateFromTextArea() {
			OurDate date = new OurDate();
			date.setOurDate(txtStartDate.getText());
			return date;
		}

		public double getSalaryFromTextArea() {
			return Double.parseDouble(txtSalary.getText());
		}

		public String getExtraInfoFromTextArea() {
			return txtExtraInfo.getText();
		}

		public void setNameToTextArea(String name) {
			txtName.setText(name);
		}

		public void setNumberToTextArea(String n) {
			txtNumber.setText(n);
		}

		public void setStartDateToTextArea(String date) {
			txtStartDate.setText(date);
		}

		public void setSalaryToTextArea(String d) {
			txtSalary.setText(d);
		}

		public void setExtraInfoToTextArea(String ex) {
			txtExtraInfo.setText(ex);
		}

		private void loadButtonHandlers(JFrame frame) {

			addManagerEmployeeBtn.addActionListener(event -> {
				try {
					Employee emp = new Manager(getNameFromTextArea(), getNumberFromTextArea(),
							getStartDateFromTextArea(), getSalaryFromTextArea(), getExtraInfoFromTextArea());
					startUp.getEmployees().add(emp);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			addStaffEmployeeBtn.addActionListener(event -> {
				try {
					Employee emp = new Staff(getNameFromTextArea(), getNumberFromTextArea(), getStartDateFromTextArea(),
							getSalaryFromTextArea(), getExtraInfoFromTextArea());
					startUp.getEmployees().add(emp);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			addTempEmployeeBtn.addActionListener(event -> {
				try {
					OurDate date = new OurDate();
					date.setOurDate(getExtraInfoFromTextArea());
					Employee emp = new Temp(getNameFromTextArea(), getNumberFromTextArea(), getStartDateFromTextArea(),
							getSalaryFromTextArea(), date);
					startUp.getEmployees().add(emp);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			deleteEmployeeBtn.addActionListener(event -> {
				try {

					startUp.deleteEmployee(getNumberFromTextArea());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			findEmployeeBtn.addActionListener(event -> {
				try {
					Employee foundEmployee = startUp.findEmployee(getNumberFromTextArea());
					txtName.setText(foundEmployee.getName());
					txtNumber.setText(Integer.toString(foundEmployee.getEmployeeNumber()));
					txtStartDate.setText(foundEmployee.getStartDate().toString());
					txtSalary.setText(Double.toString(foundEmployee.getSalary()));
					txtExtraInfo.setText(foundEmployee.getExtraInfo());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			nextEmployeeBtn.addActionListener(event -> {
				try {
					int currentEmployeeValue = startUp.getCurrentEmployeeValue();
					Employee nextEmployee = startUp.getCurrentEmployee();
					txtName.setText(nextEmployee.getName());
					txtNumber.setText(Integer.toString(nextEmployee.getEmployeeNumber()));
					txtStartDate.setText(nextEmployee.getStartDate().toString());
					txtSalary.setText(Double.toString(nextEmployee.getSalary()));
					txtExtraInfo.setText(nextEmployee.getExtraInfo());
					startUp.setCurrentEmployeeValue(currentEmployeeValue + 1);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			previousEmployeeBtn.addActionListener(event -> {
				try {
					int currentEmployeeValue = startUp.getCurrentEmployeeValue();
					startUp.setCurrentEmployeeValue(currentEmployeeValue - 1);
					Employee prevEmployee = startUp.getCurrentEmployee();
					txtName.setText(prevEmployee.getName());
					txtNumber.setText(Integer.toString(prevEmployee.getEmployeeNumber()));
					txtStartDate.setText(prevEmployee.getStartDate().toString());
					txtSalary.setText(Double.toString(prevEmployee.getSalary()));
					txtExtraInfo.setText(prevEmployee.getExtraInfo());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			saveToFileBtn.addActionListener(event -> {
				try {
					startUp.saveEmployeesToFile();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});

			loadFromFileBtn.addActionListener(event -> {
				try {
					startUp.loadEmployeesFromFile();
					startUp.setCurrentEmployeeValue(0);
					int currentEmployeeValue = startUp.getCurrentEmployeeValue();
					Employee nextEmployee = startUp.getCurrentEmployee();
					txtName.setText(nextEmployee.getName());
					txtNumber.setText(Integer.toString(nextEmployee.getEmployeeNumber()));
					txtStartDate.setText(nextEmployee.getStartDate().toString());
					txtSalary.setText(Double.toString(nextEmployee.getSalary()));
					txtExtraInfo.setText(nextEmployee.getExtraInfo());
					startUp.setCurrentEmployeeValue(currentEmployeeValue + 1);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			});
		}
	}
}
