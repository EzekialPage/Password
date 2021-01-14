//Ezekial Page
//checks for validity of an entered password
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Password {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		//creates array of lazy passwords
		Scanner sc = new Scanner(new File("WeakPass.txt"));

		String[] worstList = new String[25];
		/*
		for (int i = 0; i < 25; i++) {
			worstList[i] = sc.nextLine();
			System.out.println(worstList[i]);
		}
		*/
		String pass;
		int counter = 0;
		pass = JOptionPane.showInputDialog("Enter a password");
		boolean accepted = false;
		while (counter < 4) {

			if (checkStrength(pass, worstList) == true) {
				JOptionPane.showMessageDialog(null,
						"Error. Lazy password.");
				counter++;
				// checks first 3 characters for difference
			} else if (checkFirstThree(pass) == false) {
				JOptionPane.showMessageDialog(null,
						"Error. First 3 characters of password must differ.");
				counter++;

				// checks for spaces
			} else if (checkSpaces(pass) == false) {
				JOptionPane.showMessageDialog(null,
						"Error. Password must have no spaces.");
				counter++;

				// tests password length minimum
			} else if (checkLength(pass) == false) {
				JOptionPane.showMessageDialog(null,
						"Error. Password must be at least 8 characters.");
				counter++;

				// checks for illegal starting characters
			} else if (checkStart(pass) == false) {
				JOptionPane.showMessageDialog(null,
						"Error. Password must not start with ! or ?");
				counter++;

				// checks for special character
			} else if (checkSpecial(pass) == false) {
				JOptionPane
						.showMessageDialog(null,
								"Error. Password must have at least 1 special character.");
				counter++;

				// checks for last letters
			} else if (checkLastThree(pass) == false) {
				JOptionPane.showMessageDialog(null,
						"Error. Last 3 characters must differ.");
				counter++;
			}else {
				JOptionPane.showMessageDialog(null, "Password accepted");
				counter = 4;
				accepted = true;
			}// end password checks
			if (counter != 4)
				pass = JOptionPane.showInputDialog("Enter a new password");
			else if (accepted == false) {
				JOptionPane.showMessageDialog(null,
						"Too many attempts\nProgram terminating.");
			}
		}// end while
	}// end main

	// creates method to check string length requirements
	public static boolean checkLength(String p) {
		if (p.length() >= 8) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkFirstThree(String p) {
		if ((p.charAt(0) != p.charAt(1)) || (p.charAt(0) != p.charAt(2))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkLastThree(String p) {
		if ((p.charAt(p.length() - 1) != p.charAt(p.length() - 2))
				|| (p.charAt(p.length() - 1) != p.charAt(p.length() - 3))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkSpaces(String p) {
		if (p.indexOf(' ') == -1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkSpecial(String p) {
		if ((p.indexOf('@') >= 0) || (p.indexOf('!') >= 0)
				|| (p.indexOf('$') >= 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkStart(String p) {
		if ((p.charAt(0) != '!') && (p.charAt(0) != '?')) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkStrength(String p, String[] worstList){
		boolean result = false;
		
		//searches for matches
		for (int i = 0; i < worstList.length; i++) {
			if (p.equals(worstList[i])) {
				result = true;
				i = worstList.length;
			}
		}
		return result;
	}
}// end class

