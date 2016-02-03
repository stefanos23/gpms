package gpms.codex.app;

import gpms.codex.mock.server.SystemRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class RegisterController {

	// Register controller uses no model
	private HomeModel homeModel;
	private RegisterView view;
	private ActionListener actionListener;

	public RegisterController(RegisterView view) {
		this.view = view;

	}

	public void contol() {
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				String menuItemActivated = actionEvent.getActionCommand();
				if (menuItemActivated.equals("register")) {
					if (check_inputs()) {
						register_service();
					}
				} else if (menuItemActivated.equals("cancel")) {
					// view.getFrame().dispose();
					view.getFrame().dispose();
				}

			}
		};
		view.getCancelButton().addActionListener(actionListener);
		view.getRegisterButton().addActionListener(actionListener);
	}

	private boolean check_inputs() {

		String userName = view.getTextField().getText();
		if (userName.equals("")) {
			JOptionPane.showMessageDialog(null, "userName Empty");
			return false;
		}

		if (!userName.matches("^[0-9a-zA-Z]+$")) {
			JOptionPane.showMessageDialog(null,
					"UserName should consist of letters and numbers");
			return false;
		}
		if (userName.length() > 16) {
			JOptionPane
					.showMessageDialog(null,
							"Username must be no more than 16 alphanumerice characters");
			view.getTextField().setText("");
			return false;
		}

		String email = view.getMailField().getText();
		if (email.equals("")) {
			JOptionPane.showMessageDialog(null, "Email Empty");
			return false;
		}
		if (!validate_mail(email)) {
			JOptionPane.showMessageDialog(null, "Email Wrong format");
			return false;
		}
		String password = view.getPasswordField().getText();
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Password Empty");
			return false;
		}
		if (password.length() < 1 || password.length() > 16) {
			JOptionPane.showMessageDialog(null,
					"Password should be between 1 and 16 characters");
			return false;
		}
		String realName = view.getRealNameField().getText();
		if (realName.equals("")) {
			JOptionPane.showMessageDialog(null, "RealName Empty");
			return false;
		}
		if (!validate_realName(realName)) {
			JOptionPane.showMessageDialog(null,
					"RealName must contains only letters");
			return false;
		}
		if (realName.length() < 1 || realName.length() > 16) {
			JOptionPane.showMessageDialog(null,
					"RealName should be between 1 and 16 characters");
			return false;
		}

		// String shortBio = view.getShortBioArea().getText();
		// if (shortBio.equals("")){
		// JOptionPane.showMessageDialog(null, "ShortBio Empty");
		// return false;
		// }
		// if (shortBio.length() < 1 || shortBio.length() > 100 ){
		// JOptionPane.showMessageDialog(null,
		// "ShortBio should be between 1 and 100 characters");
		// return false;
		// }

		return true;

	}

	private static boolean validate_mail(String email) {
		Pattern valid_mail = Pattern.compile(
				"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher match_mail = valid_mail.matcher(email);
		return match_mail.find();
	}

	private static boolean validate_realName(String email) {
		Pattern valid = Pattern.compile("^[A-Z]+$", Pattern.CASE_INSENSITIVE);
		Matcher match_mail = valid.matcher(email);
		return match_mail.find();
	}

	private void register_service() {

		// register here
		SystemRegister p2pservices;

		LocalInfo localinfo = new LocalInfo();
		String mac = localinfo.getMacAddressFromIp();

		SystemRegister systemRegister = new SystemRegister();
		systemRegister.register_with_location(view.getTextField().getText(),
				view.getPasswordField().getText(), mac);
		view.getFrame().dispose();

		/*
		 * here you must throw different exceptions like you cant acces from
		 * that machine or bad credeintials
		 */

		// PeerToPeerOpenServices p2pservices;
		// try {
		// p2pservices = new
		// PeerToPeerOpenServicesServiceLocator().getPeerToPeerOpenServices();
		//
		// String userName = view.getTextField().getText();
		// if (userName.length() > 16){
		// JOptionPane.showMessageDialog(null,
		// "Username must be no more than 16 alphanumerice characters");
		// view.getTextField().setText("");
		// return;
		// }
		// String realName = view.getRealNameField().getText();
		// String email = view.getMailField().getText();
		// String shortBio = view.getShortBioArea().getText();
		// String password = view.getPasswordField().getText();
		// if (password.length() > 16){
		// JOptionPane.showMessageDialog(null,
		// "Password must be no more than 16 alphanumerice characters");
		// view.getPasswordField().setText("");
		// return;
		// }
		//
		// try {
		// p2pservices.createUserAccount(userName, realName, shortBio, email,
		// password);
		// view.getFrame().dispose();
		// } catch (BadInputException e) {
		// // TODO Auto-generated catch block
		// JOptionPane.showMessageDialog(null,
		// "UserName already in use. Please choose a different one");
		// } catch (RemoteException e) {
		// // TODO Auto-generated catch block
		// JOptionPane.showMessageDialog(null,
		// "Server Unavailable due to mainantance. Please try again later");
		// view.getFrame().dispose();
		// }
		// } catch (ServiceException e1) {
		// // TODO Auto-generated catch block
		// JOptionPane.showMessageDialog(null, "Server Unavailable");
		// //view.getFrame().dispose();
		// }
		//
	}

}
