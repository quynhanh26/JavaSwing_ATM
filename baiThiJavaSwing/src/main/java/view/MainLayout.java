package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.AccountDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class MainLayout extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmSelectTrans;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JDesktopPane desktopPane;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainLayout frame = new MainLayout();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainLayout() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 838);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Account");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Select Account");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItemActionPerformed(e);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		mnNewMenu_1 = new JMenu("Transaction");
		menuBar.add(mnNewMenu_1);

		mntmSelectTrans = new JMenuItem("Select Transaction");
		mntmSelectTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmSelectTransActionPerformed(e);
			}
		});

		mnNewMenu_1.add(mntmSelectTrans);

		mnNewMenu_2 = new JMenu("Logout");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmNewMenuItem_1ActionPerformed(e);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 852, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(477, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	protected void mntmNewMenuItemActionPerformed(ActionEvent e) {
		AdminAccount ad = new AdminAccount();
		ad.setVisible(true);
		desktopPane.add(ad);
	}

	protected void mntmSelectTransActionPerformed(ActionEvent e) {
		Transaction1 trans = new Transaction1();
		trans.setVisible(true);
		desktopPane.add(trans);
	}

	protected void mntmNewMenuItem_1ActionPerformed(ActionEvent e) {
		LoginAdmin login = new LoginAdmin();
		login.setVisible(true);
		this.setVisible(false);
	}
}
