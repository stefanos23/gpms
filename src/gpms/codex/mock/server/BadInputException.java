/*
 * BadInputException.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.mock.server;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
*
* BadInputException class is an Exception class.
* BadInputException is used when the user's credentials are wrong.
*
* @author TeamCodex
* @version 1.1 First relocation
* @see Exception
* 
*/

public class BadInputException extends Exception {
	public BadInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
