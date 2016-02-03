/*
 * @(#) HomeController.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 *
 * HomeController class is the controller for the home View
 * <p>
 * MacAuthenticationApp is controlling all the user inputs and is responsible for calling the 
 * appropriate system(mock server) operations.
 *
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see HomeView
 */

public class HomeController {

	private HomeModel model;
	private HomeView view;
	private ActionListener actionListener;

	public HomeController(HomeModel model, HomeView view) {
		this.model = model;
		this.view = view;

	}

	public void contol() {
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				String menuItemActivated = actionEvent.getActionCommand();
				if (menuItemActivated.equals("Exit")) {

					exit();

				} else if (menuItemActivated.equals("View Profile")) {

				} else if (menuItemActivated.equals("sendMessage")) {

				} else if (menuItemActivated.equals("view Message")) {

				}
			}
		};

		/*
		 * this action listener base code if for
		 * http://www.java2s.com/Code/Java/
		 * Swing-JFC/JListselectionchangedlistener.htm
		 */

		view.getExit().addActionListener(actionListener);
		// view.getProfile().addActionListener(actionListener);
		// view.getMsg().addActionListener(actionListener);
		// view.getInbx().addActionListener(actionListener);

	}

	private void exit() {

		view.getFrame().dispose();
		System.exit(0);
	}
}