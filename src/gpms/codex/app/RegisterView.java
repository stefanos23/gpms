package gpms.codex.app;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class RegisterView {

	private JFrame frame;
	private JPanel panel;
    private JPanel panel2;
    private JPanel buttonPanel;
    private JLabel label;
    private JLabel passLabel;
    private JLabel realNameLabel;
    private JLabel mailLabel;
    private JLabel shortBioLabel;
    private JTextField textField;
    private JTextField passwordField;
    private JTextField realNameField;
    private JTextField mailField;
    private JTextArea shortBioArea;
    private JButton registerButton;
    private JButton cancelButton;
	
	public RegisterView(){
		
		JFrame.setDefaultLookAndFeelDecorated(true);
    	frame = new JFrame("Registration");
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.setSize(300, 300);
    	frame.setResizable(false);
        //set my frame to start not in the corner
        frame.setLocation(250, 250);
        frame.setLayout(new FlowLayout());
        panel = new JPanel(new GridLayout(8,1));
        panel2 = panel;
        //panel2 = new JPanel(new GridLayout(4,1));
        buttonPanel = new JPanel(new GridLayout(1,2));
        
        //label 
        label = new JLabel("Username:  ");
        //frame.add(label,BorderLayout.CENTER);
        panel.add(label);
        
    //button
     
      textField = new JTextField( 15);
      //frame.add(textField);
      panel2.add(textField);
      
    //label 
      passLabel = new JLabel("Password:  ");
      //frame.add(label,BorderLayout.CENTER);
      panel.add(passLabel);
      
      passwordField = new JTextField(15);
      panel2.add(passwordField);
      //frame.add(passwordField, BorderLayout.SOUTH);
      
      
    //label 
      realNameLabel = new JLabel("RealName:  ");
      //frame.add(label,BorderLayout.CENTER);
      panel.add(realNameLabel);
      
      realNameField = new JTextField(15);
      panel2.add(realNameField);
      //frame.add(passwordField, BorderLayout.SOUTH);
      
    //label 
      mailLabel = new JLabel("Mail:  ");
      //frame.add(label,BorderLayout.CENTER);
      panel.add(mailLabel);
      
      mailField = new JTextField(15);
      panel2.add(mailField);
      //frame.add(passwordField, BorderLayout.SOUTH);//label 
      
      shortBioLabel = new JLabel("ShortBio:  ");
      //frame.add(label,BorderLayout.CENTER);
      
      
      shortBioArea = new JTextArea(4,15);
      shortBioArea.setLineWrap(true);
      //shortBioArea.setWrapStyleWord(true);
      //shortBioArea.setVerticalScrollBarPolicy(
              //JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      //shortBioArea.setPreferredSize(new Dimension(250, 250));
      JScrollPane scrollPane = new JScrollPane(shortBioArea);
      //scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
      //shortBioArea.set
      //frame.add(passwordField, BorderLayout.SOUTH);
      
      
      registerButton = new JButton("register"); 
      buttonPanel.add(registerButton);
      
      cancelButton = new JButton("cancel"); 
      buttonPanel.add(cancelButton);
        
        
      frame.add(panel);
      frame.add(panel2);
      //frame.add(panel_for_bio);
      frame.add(buttonPanel);
     //frame.pack();
        frame.setVisible(true);
			
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getPasswordField() {
		return passwordField;
	}

	public JTextField getRealNameField() {
		return realNameField;
	}

	public JTextField getMailField() {
		return mailField;
	}

	public JTextArea getShortBioArea() {
		return shortBioArea;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}
	
	
	
	
	
}
