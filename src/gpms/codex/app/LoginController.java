package gpms.codex.app;

import gpms.codex.mock.server.BadInputException;
import gpms.codex.mock.server.LocationNotSupportedException;
import gpms.codex.mock.server.SystemRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginController {
	private HomeModel homeModel;
	private LoginView view;
	private ActionListener actionListener;

	public LoginController(LoginView view) {
		this.view = view;

	}

	public void contol() {
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				String menuItemActivated = actionEvent.getActionCommand();
				if (menuItemActivated.equals("exit")) {
					view.getFrame().dispose();
					System.exit(0);
				} else if (menuItemActivated.equals("login")) {
					try {
						checkLogin();
					} catch (BadInputException e) {
						// TODO Auto-generated catch block
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

		String pass = view.getPasswordField().getText();
		if (pass.length() > 45) {
			JOptionPane.showMessageDialog(null, "Bad Credentials");
			view.getTextField().setText("");
			view.getPasswordField().setText("");
			return;
		}

		LocalInfo mac = new LocalInfo();
		String macAddress = mac.getMacAddressFromIp();

		SystemRegister systemRegister = new SystemRegister();
		systemRegister.login_with_location(user, pass, macAddress);

		// homeModel = new HomeModel(user, user2);
		view.getFrame().dispose();
		invokeMainService();

		/*
		 * here you must throw different exceptions like you cant acces from
		 * that machine or bad credeintials
		 */

		// if everything alright call login webservice and create user profile
		// object

	}

	private void invokeMainService() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				HomeView view = new HomeView();
				HomeController controller = new HomeController(homeModel, view);
				controller.contol();

				// BasicModel model = new BasicModel(0);
				// HomeView view = new HomeView();
				// BasicController controller = new BasicController(model,view);
				// controller.contol();
			}
		});
	}
}
