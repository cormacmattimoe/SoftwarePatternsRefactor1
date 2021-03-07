import javax.swing.JComboBox;
import javax.swing.JTextField;


	
	public class ValidateScreenInput
	
	{
	
		ValidatePPS parent;
		ValidatePPS vps;

		public void ValidateScreenInput() {
			
		}
		
		public static boolean validateInput(JTextField ppsField, JTextField surnameField, JTextField firstNameField, JComboBox<String> genderCombo, JComboBox<String> departmentCombo) {
			boolean valid = true;
			EmployeeDetails empDe = new EmployeeDetails();
			if (ppsField.isEditable() && ppsField.getText().trim().isEmpty()) {
				ppsField.setBackground(ColorManager.errorColor);
				valid = false;
			} 
			if (surnameField.isEditable() && surnameField.getText().trim().isEmpty()) {
				surnameField.setBackground(ColorManager.errorColor);
				valid = false;
			} 
			if (firstNameField.isEditable() && firstNameField.getText().trim().isEmpty()) {
				firstNameField.setBackground(ColorManager.errorColor);
				valid = false;
			}
			if (genderCombo.getSelectedIndex() == 0 && genderCombo.isEnabled()) {
				genderCombo.setBackground(ColorManager.errorColor);
				valid = false;
			} 
			if (departmentCombo.getSelectedIndex() == 0 && departmentCombo.isEnabled()) {
				departmentCombo.setBackground(ColorManager.errorColor);
				valid = false;
			} 
			return valid;
			
			
		}
		
		

}
