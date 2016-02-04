/*
 * LoginController.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import gpms.codex.mock.server.BadInputException;
import gpms.codex.mock.server.LocationNotSupportedException;
import gpms.codex.mock.server.SystemRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * 
 * LoginController class is the controller(mcv pattern) of the login phase.
 * LoginController is used to control the login phase.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see LoginView
 * @see ActionListener
 * @see LocalInfo
 * @see BadInputException
 * @see LocationNotSupportedException
 */

public class LoginController {

	private LoginView view;
	private ActionListener actionListener;

	public LoginController(LoginView view) {
		this.view = view;

	}

	/**
	 * Control methods attach listeners to the login view, and handles all the requests.
	 * 
	 */

	public void contol() {
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				String menuItemActivated = actionEvent.getActionCommand();
				if (menuItemActivated.equals("exit")) {
					//exits the program
					view.getFrame().dispose();
					System.exit(0);
				} else if (menuItemActivated.equals("login")) {
					//evaluate the login credentials of the user
					try {
						checkLogin();
					} catch (BadInputException e) {
						JOptionPane.showMessageDialog(null, "Bad Credentials");
						view.getTextField().setText("");
						view.getPasswordField().setText("");
					} catch (LocationNotSupportedException e) {
						JOptionPane
								.showMessageDialog(null,
										"You cannot access this venue from an unregistered location");
						view.getTextField().setText("");
						view.getPasswordField().setText("");
					}
				} else if (menuItemActivated.equals("register")) {
					//initialize the register process
					System.out.println("hew");
					RegisterView view = new RegisterView();
					RegisterController controller = new RegisterController(view);
					controller.contol();
				}
			}
		};
		view.getLoginButton().addActionListener(actionListener);
		view.getExitButton().addActionListener(actionListener);
		view.getRegisterButton().addActionListener(actionListener);
	}

	/**
	 * CheckLogin gets the user's input and validates them using the mock
	 * server. CheckLogin runs when the user presses the login button, and uses
	 * three parameters to authenticate the user, their username, their password
	 * and their current mac address.
	 * 
	 * @throws BadInputException
	 * @throws LocationNotSupportedException
	 */

	private void checkLogin() throws BadInputException,
			LocationNotSupportedException {

		// take user input and check them
		String user = view.getTextField().getText();
		if (user.length() > 16) {
			JOptionPane.showMessageDialog(null,
					"Username should consint at most of 16 characters");
			view.getTextField().setText("");
			view.getPasswordField().setText("");
			return;
		}

		// Here we read the user's password. Although this apporach is not
		// recomented, and a arrayList for
		// obtaining the password is favoured, we keep this simple solution for
		// demostration purposes and
		// after the client's suggestion.
		@SuppressWarnings("deprecation")
		String pass = view.getPasswordField().getText();
		if (pass.length() > 45) {
			JOptionPane.showMessageDialog(null, "Bad Credentials");
			view.getTextField().setText("");
			view.getPasswordField().setText("");
			return;
		}

		// get the mac address as a string
		LocalInfo mac = new LocalInfo();
		String macAddress = mac.getMacAddressFromIp();
		// register using the mock server and the mac address
		SystemRegister systemRegister = new SystemRegister();
		systemRegister.login_with_location(user, pass, macAddress);

		view.getFrame().dispose();
		invokeMainService();

	}

	/**
	 * Method that invokes the main/home screen
	 */
	private void invokeMainService() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				HomeView view = new HomeView();
				HomeController controller = new HomeController(view);
				controller.contol();

			}
		});
	}
}
