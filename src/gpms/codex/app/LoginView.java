/*
 * @(#) LoginView.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
*
* MacAuthenticationApp class that does intitialize the authentication app. 
* <p>
* MacAuthenticationApp is used to create an new instance of the authentication app.
*
* @author TeamCodex
* @version 1.1 First relocation
* @see UIManager
* @see JFrame
* 
*/ 

public class LoginView {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel2;
	private JPanel buttonPanel;
	private JLabel label;
	private JLabel passLabel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton registerButton;
	private JButton exitButton;

	public LoginView() {

		// JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 130);
		frame.setResizable(false);
		// set my frame to start not in the corner
		frame.setLocation(200, 200);
		frame.setLayout(new FlowLayout());
		// frame.setLayout(new GridLayout(2,2));
		panel = new JPanel(new GridLayout(2, 1));
		panel2 = new JPanel(new GridLayout(2, 1));
		buttonPanel = new JPanel(new GridLayout(1, 3));

		// label
		label = new JLabel("Username:  ");
		// frame.add(label,BorderLayout.CENTER);
		panel.add(label);

		// button

		textField = new JTextField(15);
		// frame.add(textField);
		panel2.add(textField);

		// label
		passLabel = new JLabel("Password:  ");
		// frame.add(label,BorderLayout.CENTER);
		panel.add(passLabel);

		passwordField = new JPasswordField(15);
		panel2.add(passwordField);
		// frame.add(passwordField, BorderLayout.SOUTH);

		// add buttons
		loginButton = new JButton("login");
		buttonPanel.add(loginButton);

		registerButton = new JButton("register");
		buttonPanel.add(registerButton);

		exitButton = new JButton("exit");
		buttonPanel.add(exitButton);

		frame.add(panel);
		frame.add(panel2);
		frame.add(buttonPanel);
		// frame.pack();
		frame.setVisible(true);

	}

	public JTextField getTextField() {
		return textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JFrame getFrame() {
		return frame;
	}

}
