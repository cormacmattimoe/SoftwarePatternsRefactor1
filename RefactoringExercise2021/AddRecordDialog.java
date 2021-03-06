/*
 * 
 * This is a dialog for adding new Employees and saving records to file
 * 
 * */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class AddRecordDialog extends JDialog implements ActionListener {
	JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	JButton save, cancel;
	EmployeeDetails parent;
	String[] gender = { "", "M", "F" };
	// department combo box values
	String[] department = { "", "Administration", "Production", "Transport", "Management" };
	// full time combo box values
	String[] fullTime = { "", "Yes", "No" };
	// constructor for add record dialog
	public AddRecordDialog(EmployeeDetails parent) {
		setTitle("Add Record");
		setModal(true);
		this.parent = parent;
		this.parent.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane(dialogPane());
		setContentPane(scrollPane);
		
		getRootPane().setDefaultButton(save);
		
		setSize(500, 370);
		setLocation(350, 250);
		setVisible(true);
	}// end AddRecordDialog

	// Set up and initialise the Employee Dialog Pane
	public Container dialogPane() {
		JPanel empDetails = new JPanel(new MigLayout());
		JPanel buttonPanel = new JPanel();
		JTextField field;
		int ColumnSize = 20;
		idField = new JTextField(ColumnSize);
		ppsField = new JTextField(ColumnSize);
		surnameField = new JTextField(ColumnSize);
		firstNameField = new JTextField(ColumnSize);
		genderCombo = new JComboBox<String>(gender);
		departmentCombo = new JComboBox<String>(department);
		salaryField = new JTextField(ColumnSize);
		fullTimeCombo = new JComboBox<String>(fullTime);
		
		//Calling this class to draw the Employee Pane
		EmployeePanelConfig employeePanelConfig = new EmployeePanelConfig();
		empDetails = employeePanelConfig.configureEmployeePanel(idField, ppsField, surnameField, firstNameField, genderCombo, 
				departmentCombo, salaryField, fullTimeCombo, gender, department, fullTime); 
		
	
		idField.setEditable(false);
		
		buttonPanel.add(save = new JButton("Save"));
		save.addActionListener(this);
		save.requestFocus();
		buttonPanel.add(cancel = new JButton("Cancel"));
		cancel.addActionListener(this);
		empDetails.add(buttonPanel, LayoutManager.loType3);
		
		// loop through all panel components and add fonts and listeners
		for (int i = 0; i < empDetails.getComponentCount(); i++) {
			empDetails.getComponent(i).setFont(this.parent.font1);
			if (empDetails.getComponent(i) instanceof JComboBox) {
				empDetails.getComponent(i).setBackground(Color.WHITE);
			}
			else if(empDetails.getComponent(i) instanceof JTextField){
				field = (JTextField) empDetails.getComponent(i);
				if(field == ppsField)
					field.setDocument(new JTextFieldLimit(9));
				else
				field.setDocument(new JTextFieldLimit(20));
			}
		}
		idField.setText(Integer.toString(this.parent.getNextFreeId()));
		return empDetails;
	}

	// add record to file
	public void addRecord() {
		boolean fullTime = false;
		Employee theEmployee;

		if (((String) fullTimeCombo.getSelectedItem()).equalsIgnoreCase("Yes"))
			fullTime = true;
		// create new Employee record with details from text fields
		theEmployee = new Employee(Integer.parseInt(idField.getText()),
				ppsField.getText().toUpperCase(), 
				surnameField.getText().toUpperCase(),
				firstNameField.getText().toUpperCase(),
				genderCombo.getSelectedItem().toString().charAt(0),
				departmentCombo.getSelectedItem().toString(),
				Double.parseDouble(salaryField.getText()), fullTime);
		
		this.parent.currentEmployee = theEmployee;
		this.parent.addRecord(theEmployee);
		this.parent.displayRecords(theEmployee);
	}

	// check for input in text fields


	public boolean checkInput() {
		boolean valid = true;
		// if any of inputs are in wrong format, colour text field and display message
		if (ppsField.getText().equals("")) 
		{
			ppsField.setBackground(ColorManager.errorColor);
			valid = false;
		}
		if (this.parent.correctPps(this.ppsField.getText().trim(), -1)) 
		{
			ppsField.setBackground(ColorManager.errorColor);
			valid = false;
		}
		if (surnameField.getText().isEmpty()) 
		{
			surnameField.setBackground(ColorManager.errorColor);
			valid = false;
		}
		if (firstNameField.getText().isEmpty())
		{
			firstNameField.setBackground(ColorManager.errorColor);
			valid = false;
		}
		if (genderCombo.getSelectedIndex() == 0)
		{
			genderCombo.setBackground(ColorManager.errorColor);
			valid = false;
		}
		if (departmentCombo.getSelectedIndex() == 0) {
			departmentCombo.setBackground(ColorManager.errorColor);
			valid = false;
		}
		try 
		{
			Double.parseDouble(salaryField.getText());
			// check if salary is greater than 0
			if (Double.parseDouble(salaryField.getText()) < 0) 
			{
				salaryField.setBackground(ColorManager.errorColor);
				valid = false;
			}
		}
		catch (NumberFormatException num) 
		{
			salaryField.setBackground(ColorManager.errorColor);
			valid = false;
		}
		if (fullTimeCombo.getSelectedIndex() == 0) {
			fullTimeCombo.setBackground(ColorManager.errorColor);
			valid = false;
		}
		return valid;
	}// end checkInput

	


	// action performed
	public void actionPerformed(ActionEvent e) {
		// if chosen option save, save record to file
		if (e.getSource() == save) {
			// if inputs correct, save record
			if (checkInput())
			{
				addRecord();// add record to file
				dispose();// dispose dialog
				this.parent.changesMade = true;
			}// end if
			// else display message and set text fields to white colour
				else {
					JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
					ColorManager backgroundColour = new ColorManager(ppsField,surnameField,firstNameField,salaryField,genderCombo,departmentCombo,fullTimeCombo);
					backgroundColour.setToWhite();
				}
			}
		// end if
		else if (e.getSource() == cancel)
			dispose();// dispose dialog
	}// end actionPerformed
	
}// end class AddRecordDialog