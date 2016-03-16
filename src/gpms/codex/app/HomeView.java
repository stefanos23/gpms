/*
 * HomeView.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.app;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * HomeView class is the view of the home screen process. HomeView is used to
 * create a representation of the home screen process.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see JFrame
 * @see JLabel
 * @see JButton
 * 
 */

public class HomeView {

	private final int width = 410;
	private final int height = 226;

	private JFrame frame;
	JMenuBar mBar;
	JMenu menu1;
	JMenuItem exit;
	JPopupMenu popup1;
	JMenu menu2;
	JPopupMenu popup2;
	JMenuItem profile;

	public HomeView() {

		// select the design of the view using UIManager's LookAndFeel method.
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		// create initial frame and initialize
		frame = new JFrame("UserNotificationApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);

		// set my frame to start not in the corner
		frame.setLocation(200, 200);
		frame.setLayout(new BorderLayout());

		mBar = new JMenuBar();
		frame.setJMenuBar(mBar);

		menu1 = new JMenu("File");
		menu1.setMnemonic('F');
		popup1 = menu1.getPopupMenu();
		mBar.add(menu1);

		exit = new JMenuItem("Exit");
		exit.setMnemonic('E');
		menu1.add(exit);

		frame.setVisible(true);

	}

	/**
	 * Returns the exit button.
	 * 
	 * @return
	 */

	public JMenuItem getExit() {
		return exit;
	}

	/**
	 * Returns the Frame.
	 * 
	 * @return
	 */

	public JFrame getFrame() {
		return frame;
	}

}
