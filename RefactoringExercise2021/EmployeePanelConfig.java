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

		empDetails.add(new JLabel("ID:"), LayoutManager.loType1);
		empDetails.add(idField, LayoutManager.loType2);

		empDetails.add(new JLabel("PPS Number:"),LayoutManager.loType1);
		empDetails.add(ppsField, LayoutManager.loType2);

		empDetails.add(new JLabel("Surname:"),LayoutManager.loType1);
		empDetails.add(surnameField, LayoutManager.loType2);

		empDetails.add(new JLabel("First Name:"),LayoutManager.loType1);
		empDetails.add(firstNameField,LayoutManager.loType2);

		empDetails.add(new JLabel("Gender:"),LayoutManager.loType1);
		empDetails.add(genderCombo, LayoutManager.loType2);

		empDetails.add(new JLabel("Department:"),LayoutManager.loType1);
		empDetails.add(departmentCombo, LayoutManager.loType2);

		empDetails.add(new JLabel("Salary:"),LayoutManager.loType1);
		empDetails.add(salaryField, LayoutManager.loType2);

		empDetails.add(new JLabel("Full Time:"),LayoutManager.loType1);
		empDetails.add(fullTimeCombo, LayoutManager.loType2);

		return empDetails;

	}
}
