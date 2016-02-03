/*
 * @(#) MacAuthenticationApp.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import javax.swing.SwingUtilities;

/*
 *
 * MacAuthenticationApp class that does intitialize the authentication app. 
 * <p>
 * MacAuthenticationApp is used to create an new instance of the authentication app.
 *
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see LoginView
 * @see LoginController
 */

public class MacAuthenticationApp {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				LoginView view = new LoginView();
				LoginController controller = new LoginController(view);
				controller.contol();

			}
		});

	}

}
