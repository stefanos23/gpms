/*
 * RegisterController.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import gpms.codex.mock.server.SystemRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * 
 * RegisterController class is the controller(mcv pattern) of the register
 * phase. RegisterController is used to control the register phase.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see RegisterView
 * @see ActionListener
 * 
 */

public class RegisterController {

	private RegisterView view;
	private ActionListener actionListener;

	public RegisterController(RegisterView view) {
		this.view = view;

	}

	/**
	 * Control methods attach listeners to the register view, and handles all
	 * the requests.
	 */

	public void contol() {
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				String menuItemActivated = actionEvent.getActionCommand();
				if (menuItemActivated.equals("register")) {
					// register the user if their inputs are predicted
					if (checkInputs()) {
						registerService();
					}
				} else if (menuItemActivated.equals("cancel")) {
					// dispose the register view
					view.getFrame().dispose();
				}

			}
		};

		// attach listeners to buttons
		view.getCancelButton().addActionListener(actionListener);
		view.getRegisterButton().addActionListener(actionListener);
	}

	/**
	 * This method check the user's input for size and format.
	 * 
	 * @return
	 */

	private boolean checkInputs() {

		String userName = view.getTextField().getText();
		// username should not be empty
		if (userName.equals("")) {
			JOptionPane.showMessageDialog(null, "userName Empty");
			return false;
		}
		// username should consist of letters and numbers
		if (!userName.matches("^[0-9a-zA-Z]+$")) {
			JOptionPane.showMessageDialog(null,
					"UserName should consist of letters and numbers");
			return false;
		}
		// username should be at most 16 alphanumeric characters
		if (userName.length() > 16) {
			JOptionPane
					.showMessageDialog(null,
							"Username must be no more than 16 alphanumerice characters");
			view.getTextField().setText("");
			return false;
		}

		String email = view.getMailField().getText();
		// email should not be empty
		if (email.equals("")) {
			JOptionPane.showMessageDialog(null, "Email Empty");
			return false;
		}
		// email should have a standart format e.g. name@something.something
		if (!validateMail(email)) {
			JOptionPane.showMessageDialog(null, "Email Wrong format");
			return false;
		}
		String password = view.getPasswordField().getText();
		// password should not be empty
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Password Empty");
			return false;
		}
		// password should be no more than 16 alphanumerics
		if (password.length() < 1 || password.length() > 16) {
			JOptionPane.showMessageDialog(null,
					"Password should be between 1 and 16 characters");
			return false;
		}
		String realName = view.getRealNameField().getText();
		// realname should not be empty
		if (realName.equals("")) {
			JOptionPane.showMessageDialog(null, "RealName Empty");
			return false;
		}
		// realname must contain only letters
		if (!validateRealName(realName)) {
			JOptionPane.showMessageDialog(null,
					"RealName must contains only letters");
			return false;
		}
		// realname should not be more than 16 characters
		if (realName.length() < 1 || realName.length() > 16) {
			JOptionPane.showMessageDialog(null,
					"RealName should be between 1 and 16 characters");
			return false;
		}

		return true;

	}

	/**
	 * This method checks if the user's mails has a standard format like
	 * id@something.something
	 * 
	 * @param email
	 * @return
	 */

	public static boolean validateMail(String email) {
		if (email == null) {
			return false;
		}
		// the regular expression defines the standard format
		Pattern valid_mail = Pattern.compile(
				"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher match_mail = valid_mail.matcher(email);
		return match_mail.find();
	}

	/**
	 * This method checks if the user's real name consists only of letters
	 * 
	 * @param email
	 * @return
	 */

	public static boolean validateRealName(String email) {
		if (email == null) {
			return false;
		}
		Pattern valid = Pattern.compile("^[A-Z]+$", Pattern.CASE_INSENSITIVE);
		Matcher match_mail = valid.matcher(email);
		return match_mail.find();
	}

	/**
	 * This method takes the users information and register the user using the
	 * (mock)server.
	 * 
	 */

	private void registerService() {

		// get the mac address
		LocalInfo localinfo = new LocalInfo();
		String mac = localinfo.getMacAddressFromIp();
		// connect to the server to register
		SystemRegister systemRegister = new SystemRegister();
		if (systemRegister.registerWithLocation(view.getTextField().getText(),
				view.getPasswordField().getText(), mac)) {
			view.getFrame().dispose();
		} else {
			JOptionPane.showMessageDialog(null,
					"Username in use, please choose a different one");
		}

	}

}
