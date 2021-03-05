import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class EmployeePanelConfig {
	
	public EmployeePanelConfig () {
		
	}

	public JPanel configureEmployeePanel(JTextField idField, JTextField ppsField,
			JTextField surnameField, JTextField firstNameField, JComboBox<String> genderCombo, JComboBox<String> departmentCombo,
			JTextField salaryField, JComboBox<String> fullTimeCombo, String[] parentGender, String[] parentDepartment,
			String[] parentFullTime) {
		
		JPanel empDetails = new JPanel(new MigLayout());
		
		empDetails.setBorder(BorderFactory.createTitledBorder("Employee Details"));

		empDetails.add(new JLabel("ID:"), "growx, pushx");
		empDetails.add(idField, "growx, pushx, wrap");

		empDetails.add(new JLabel("PPS Number:"), "growx, pushx");
		empDetails.add(ppsField, "growx, pushx, wrap");

		empDetails.add(new JLabel("Surname:"), "growx, pushx");
		empDetails.add(surnameField, "growx, pushx, wrap");

		empDetails.add(new JLabel("First Name:"), "growx, pushx");
		empDetails.add(firstNameField, "growx, pushx, wrap");

		empDetails.add(new JLabel("Gender:"), "growx, pushx");
		empDetails.add(genderCombo, "growx, pushx, wrap");

		empDetails.add(new JLabel("Department:"), "growx, pushx");
		empDetails.add(departmentCombo, "growx, pushx, wrap");

		empDetails.add(new JLabel("Salary:"), "growx, pushx");
		empDetails.add(salaryField, "growx, pushx, wrap");

		empDetails.add(new JLabel("Full Time:"), "growx, pushx");
		empDetails.add(fullTimeCombo, "growx, pushx, wrap");

		return empDetails;

	}
}
