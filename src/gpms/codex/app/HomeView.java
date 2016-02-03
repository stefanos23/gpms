package gpms.codex.app;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

public class HomeView {

	private JFrame frame;
	private JLabel label;
	private JButton msg, inbx, prfl, ext;

	DefaultListModel message_list;
	JList list;

	JMenuBar mBar;
	JMenu menu1;
	JMenuItem exit;
	JPopupMenu popup1;
	JMenu menu2;
	JPopupMenu popup2;
	JMenuItem profile;

	public HomeView() {

		frame = new JFrame("PeerToPeerSnapText");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(410, 226);
		frame.setResizable(false);
		// set my frame to start not in the corner
		frame.setLocation(200, 200);
		frame.setLayout(new BorderLayout());

		// JPanel panel = new JPanel(new BorderLayout());

		// message_list = new DefaultListModel();
		// list = new JList(message_list);
		// JScrollPane pane = new JScrollPane(list);

		mBar = new JMenuBar();
		frame.setJMenuBar(mBar);

		menu1 = new JMenu("File");
		menu1.setMnemonic('F');
		popup1 = menu1.getPopupMenu();
		mBar.add(menu1);

		exit = new JMenuItem("Exit");
		exit.setMnemonic('E');
		menu1.add(exit);

		// menu2 = new JMenu( "Profile" );
		// menu2.setMnemonic( 'P' );
		// popup2= menu2.getPopupMenu();
		// popup2.setLightWeightPopupEnabled( false );
		// mBar.add( menu2 );

		// profile= new JMenuItem( "View Profile" );
		// profile.setMnemonic( 'V' );
		// menu2.add( profile );

		msg = new JButton("sendMessage");
		inbx = new JButton("view Message");

		// frame.add(pane,BorderLayout.NORTH);
		// frame.add(inbx,BorderLayout.EAST);
		// frame.add(msg,BorderLayout.WEST);

		frame.setVisible(true);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JButton getMsg() {
		return msg;
	}

	public void setMsg(JButton msg) {
		this.msg = msg;
	}

	public JButton getInbx() {
		return inbx;
	}

	public void setInbx(JButton inbx) {
		this.inbx = inbx;
	}

	public JButton getPrfl() {
		return prfl;
	}

	public void setPrfl(JButton prfl) {
		this.prfl = prfl;
	}

	public JButton getExt() {
		return ext;
	}

	public void setExt(JButton ext) {
		this.ext = ext;
	}

	public DefaultListModel getMessage_list() {
		return message_list;
	}

	public void setMessage_list(DefaultListModel model) {
		this.message_list = model;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public JMenuBar getmBar() {
		return mBar;
	}

	public void setmBar(JMenuBar mBar) {
		this.mBar = mBar;
	}

	public JMenu getMenu1() {
		return menu1;
	}

	public void setMenu1(JMenu menu1) {
		this.menu1 = menu1;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}

	public JPopupMenu getPopup1() {
		return popup1;
	}

	public void setPopup1(JPopupMenu popup1) {
		this.popup1 = popup1;
	}

	public JMenu getMenu2() {
		return menu2;
	}

	public void setMenu2(JMenu menu2) {
		this.menu2 = menu2;
	}

	public JPopupMenu getPopup2() {
		return popup2;
	}

	public void setPopup2(JPopupMenu popup2) {
		this.popup2 = popup2;
	}

	public JMenuItem getProfile() {
		return profile;
	}

	public void setProfile(JMenuItem profile) {
		this.profile = profile;
	}

	public static void main(String[] args) {
		HomeView asd = new HomeView();

	}

}
