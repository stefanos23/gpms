/*
 * LoginView.java 1.1 2016/02/03
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

/**
 * 
 * LoginView class is the view of the login process. LoginView is used to create
 * a representation of the login process.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see UIManager
 * @see JFrame
 * @see JLabel
 * @see JFrame
 * @see JTextField
 * @see JPasswordField
 * @see JButton
 * 
 */

public class LoginView {

	private final int width = 300;
	private final int height = 130;

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

		// select the design of the view using UIManager's LookAndFeel method.
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		// create the frame and initialise it
		frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);
		// set my frame to start not in the corner
		frame.setLocation(200, 200);
		frame.setLayout(new FlowLayout());
		// frame.setLayout(new GridLayout(2,2));
		panel = new JPanel(new GridLayout(2, 1));
		panel2 = new JPanel(new GridLayout(2, 1));
		buttonPanel = new JPanel(new GridLayout(1, 3));

		label = new JLabel("Username:  ");
		panel.add(label);

		textField = new JTextField(15);
		panel2.add(textField);

		passLabel = new JLabel("Password:  ");
		panel.add(passLabel);

		passwordField = new JPasswordField(15);
		panel2.add(passwordField);

		loginButton = new JButton("login");
		buttonPanel.add(loginButton);

		registerButton = new JButton("register");
		buttonPanel.add(registerButton);

		exitButton = new JButton("exit");
		buttonPanel.add(exitButton);

		frame.add(panel);
		frame.add(panel2);
		frame.add(buttonPanel);
		frame.setVisible(true);

	}

	/**
	 * This method is a getter for the username's field.
	 * 
	 * @return the username
	 */

	public JTextField getTextField() {
		return textField;
	}

	/**
	 * This method is a getter for the user's password field
	 * 
	 * @return the user's password field
	 */

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/**
	 * This method is a getter for the login button
	 * 
	 * @return the login button
	 */

	public JButton getLoginButton() {
		return loginButton;
	}

	/**
	 * This method is a getter for the exit button
	 * 
	 * @return the exit button
	 */

	public JButton getExitButton() {
		return exitButton;
	}

	/**
	 * This method is a getter for the register button
	 * 
	 * @return the register button
	 */

	public JButton getRegisterButton() {
		return registerButton;
	}

	/**
	 * This method is a setter for the username field
	 * 
	 * @return the register button
	 */

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * This method is a setter for the password field
	 * 
	 */

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	/**
	 * This method is a getter for the login frame
	 * 
	 * @return the login frame
	 */

	public JFrame getFrame() {
		return frame;
	}

}
