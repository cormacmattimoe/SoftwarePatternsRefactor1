import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

 //Class which organises the varying color sections
public class ColorManager {
	
	private JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	private JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	
	public ColorManager(JTextField ppsField, JTextField surnameField, JTextField firstNameField, JTextField salaryField,
			JComboBox<String> genderCombo, JComboBox<String> departmentCombo, JComboBox<String> fullTimeCombo) {
		this.ppsField = ppsField;
		this.surnameField = surnameField;
		this.firstNameField = firstNameField;
		this.salaryField = salaryField;
		this.genderCombo = genderCombo;
		this.departmentCombo = departmentCombo;
		this.fullTimeCombo = fullTimeCombo;
		
	}

	static Color colour1 = new Color(255, 150, 150);
	
	// set text field background colour to white
		void setToWhite() {
			ppsField.setBackground(UIManager.getColor("TextField.background"));
			surnameField.setBackground(UIManager.getColor("TextField.background"));
			firstNameField.setBackground(UIManager.getColor("TextField.background"));
			salaryField.setBackground(UIManager.getColor("TextField.background"));
			genderCombo.setBackground(UIManager.getColor("TextField.background"));
			departmentCombo.setBackground(UIManager.getColor("TextField.background"));
			fullTimeCombo.setBackground(UIManager.getColor("TextField.background"));
		}
}
