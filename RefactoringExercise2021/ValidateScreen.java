import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ValidateScreen {

	
	public ValidateScreen() {
		
	}
	
	public static boolean checkInput(JTextField ppsField, JTextField surnameField, JTextField firstNameField, JComboBox<String> genderCombo, JComboBox<String> departmentCombo, JTextField salaryField,JComboBox<String> fullTimeCombo)
	{
	boolean valid = true;
	// if any of inputs are in wrong format, colour text field and display message
	if (ppsField.getText().equals("")) 
	{
		ppsField.setBackground(ColorManager.errorColor);
		valid = false;
	}
	FileDetails application = new FileDetails();
	File file;
    boolean ppsValid = false;
    String pps = ppsField.getText();
    if (pps.length() == 8) {
	      if (Character.isDigit(pps.charAt(0)) && Character.isDigit(pps.charAt(1)) &&
	        Character.isDigit(pps.charAt(2)) && Character.isDigit(pps.charAt(3)) &&
	        Character.isDigit(pps.charAt(4)) && Character.isDigit(pps.charAt(5)) &&
	        Character.isDigit(pps.charAt(6)) &&
	        Character.isLetter(pps.charAt(7))) 
	      {
	    	  /*
	    	   * Still to be done...
	    	   * 
	        // open file for reading
	        application.openReadFile(file.getAbsolutePath());
	        // look in file is PPS already in use
	        ppsValid = application.isPpsExist(pps, 0);
	        application.closeReadFile(); // close file for reading
	        */
	    	  ppsValid = true;
	      } 
	      else
	        ppsValid = false;
	    }
	    else
	      ppsValid = false;

	if (ppsValid == false) 
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
	


	 
	  

}
