/*
 * HomeController.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * HomeController class is the controller(mcv pattern) of the home screen phase.
 * HomeController is used to control the home screen phase.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see HomeView
 * @see ActionListener
 * 
 */


public class HomeController {

	private HomeView view;
	private ActionListener actionListener;

	public HomeController(HomeView view) {
		this.view = view;

	}

	/**
	 * Control methods attach listeners to the home view, and handles all the requests.
	 *
	 */
	
	public void contol() {
		//attach an actionListener to hear for events and perform actions based on those events
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
		view.getExit().addActionListener(actionListener);
	}

	/**
	 * Exit method exits the program.
	 */
	
	private void exit() {
		//dispose the frame
		view.getFrame().dispose();
		System.exit(0);
	}
}