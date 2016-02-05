/*
 * MacAuthenticationApp.java 1.1 2016/02/03
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * RegisterView class is the view of the register process. RegisterView is used
 * to create a representation of the register process.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see JFrame
 * @see JLabel
 * @see JButton
 * @see JPanel
 * @see JTextField
 * 
 */

public class RegisterView {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel2;
	private JPanel buttonPanel;
	private JLabel label;
	private JLabel passLabel;
	private JLabel realNameLabel;
	private JLabel mailLabel;
	private JTextField textField;
	private JTextField passwordField;
	private JTextField realNameField;
	private JTextField mailField;
	private JButton registerButton;
	private JButton cancelButton;

	public RegisterView() {

		// select the design of the view using UIManager's LookAndFeel method.
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		frame = new JFrame("Registration");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setResizable(false);
		// set my frame to start not in the corner
		frame.setLocation(250, 250);
		frame.setLayout(new FlowLayout());
		panel = new JPanel(new GridLayout(8, 1));
		panel2 = panel;
		buttonPanel = new JPanel(new GridLayout(1, 2));

		label = new JLabel("Username:  ");
		panel.add(label);

		textField = new JTextField(15);
		panel2.add(textField);

		passLabel = new JLabel("Password:  ");
		panel.add(passLabel);

		passwordField = new JTextField(15);
		panel2.add(passwordField);

		realNameLabel = new JLabel("RealName:  ");
		panel.add(realNameLabel);

		realNameField = new JTextField(15);
		panel2.add(realNameField);

		mailLabel = new JLabel("Mail:  ");
		panel.add(mailLabel);

		mailField = new JTextField(15);
		panel2.add(mailField);

		registerButton = new JButton("register");
		buttonPanel.add(registerButton);

		cancelButton = new JButton("cancel");
		buttonPanel.add(cancelButton);

		frame.add(panel);
		frame.add(panel2);
		frame.add(buttonPanel);
		frame.setVisible(true);

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
	 * This method is a getter for the cancel button
	 * 
	 * @return the cancel button
	 */

	public JButton getCancelButton() {
		return cancelButton;
	}

	/**
	 * This method is a getter for the user name
	 * 
	 * @return the user's username
	 */

	public JTextField getTextField() {
		return textField;
	}

	/**
	 * This method is a getter for the user's password
	 * 
	 * @return the login frame
	 */

	public JTextField getPasswordField() {
		return passwordField;
	}

	/**
	 * This method is a getter for the user's realname
	 * 
	 * @return the real name of the user
	 */

	public JTextField getRealNameField() {
		return realNameField;
	}

	/**
	 * This method is a getter for the mail field
	 * 
	 * @return the user's mail
	 */

	public JTextField getMailField() {
		return mailField;
	}

	/**
	 * This method is a getter for the register frame
	 * 
	 * @return the register frame
	 */

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * This method is a setter for the username field
	 * 
	 */

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * This method is a setter for the password field
	 * 
	 */

	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}

}
