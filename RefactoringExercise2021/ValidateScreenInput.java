import javax.swing.JComboBox;
import javax.swing.JTextField;


	
	public class ValidateScreenInput
	
	{
	
		ValidatePPS parent;
		ValidatePPS vps;

		public ValidateScreenInput() {
			
		}
		
		public static boolean validateInputOfFields(JTextField ppsField, JTextField surnameField, JTextField firstNameField, JComboBox<String> genderCombo, JComboBox<String> departmentCombo) {
			boolean fieldValid = true;
			if (ppsField.isEditable() && ppsField.getText().trim().isEmpty()) {
				ppsField.setBackground(ColorManager.errorColor);
				fieldValid = false;
			} 
			if (surnameField.isEditable() && surnameField.getText().trim().isEmpty()) {
				surnameField.setBackground(ColorManager.errorColor);
				fieldValid = false;
			} 
			if (firstNameField.isEditable() && firstNameField.getText().trim().isEmpty()) {
				firstNameField.setBackground(ColorManager.errorColor);
				fieldValid = false;
			}
			if (genderCombo.getSelectedIndex() == 0 && genderCombo.isEnabled()) {
				genderCombo.setBackground(ColorManager.errorColor);
				fieldValid = false;
			} 
			if (departmentCombo.getSelectedIndex() == 0 && departmentCombo.isEnabled()) {
				departmentCombo.setBackground(ColorManager.errorColor);
				fieldValid = false;
			} 
			return fieldValid;
			
			
		}
		
		

}
