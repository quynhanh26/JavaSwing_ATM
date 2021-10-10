package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import com.sun.tools.javac.Main;

import common.ConnectDB;
import dao.AccountDao;
import entity.Account;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUserName;
	private JLabel lblPass;
	private JTextField txtUser;
	private JButton btnCancel;
	private JButton btnSignin;
	private JLabel lblLog;
	private JPasswordField pass;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginAdmin() {
		setUndecorated(true);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(11, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(103, Short.MAX_VALUE)));

		lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblPass = new JLabel("Pass word");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txtUser = new JTextField();
		txtUser.setColumns(10);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
		btnCancel.setBackground(Color.RED);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnSignin = new JButton("Login");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSigninActionPerformed(e);
			}
		});
		btnSignin.setBackground(Color.GREEN);
		btnSignin.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblLog = new JLabel("Login Form");
		lblLog.setForeground(new Color(0, 255, 255));
		lblLog.setFont(new Font("Segoe UI Black", Font.BOLD, 18));

		pass = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(215, Short.MAX_VALUE)
						.addComponent(lblLog, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE).addGap(196))
				.addGroup(gl_panel.createSequentialGroup().addGap(55)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 113,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE).addComponent(
												btnSignin, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
								.addComponent(pass, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
								.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
						.addGap(21)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addComponent(lblLog, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pass, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(59)
								.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
				.addGap(28)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSignin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(124, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		JFrame frame = new JFrame("Exit");
		if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit Form Login",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}

//	ADMIN USER:admin PASS:261601
//	CLIENT USER quynhanh PASS:111111
//	CLIENT USER: nhathuy PASS :161201

	protected void btnSigninActionPerformed(ActionEvent e) {
		AccountDao accdao = new AccountDao();
		String pas = pass.getText().trim();
		Account acc = accdao.Showinfor(txtUser.getText().trim());
		if (txtUser.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "username not empty");
		} else if (pass.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "password not empty");
		} else {
			String hash = BCrypt.hashpw(pas, BCrypt.gensalt());
			boolean match = BCrypt.checkpw(pas, acc.getPinNum());
			if (match) {
				if (acc.getIsAdmin().equals("Admin")) {
					MainLayout main = new MainLayout();
					main.setVisible(true);
					this.setVisible(false);
				} else if (acc.getIsAdmin().equals("Client")) {
					ShowInfor client = new ShowInfor();
					client.setNumcardacc(acc.getNumcardacc());
					client.setVisible(true);
					this.setVisible(false);
				}
			} else {
				JOptionPane.showMessageDialog(null, "password or username don't exists");
			}
		}
	}
}

//		AccountDao dao = new AccountDao();
//		Account acc = dao.selectAd(Integer.parseInt(txtUser.getText()), pass.getText());
//		if (acc != null) {
//			if (acc.getIsAdmin().equals("Admin")) {
//				MainLayout main = new MainLayout();
//				main.setVisible(true);
//				this.setVisible(false);
//			} else if (acc.getIsAdmin().equals("Client")) {
//				ShowInfor client = new ShowInfor();
//				client.setAccid(acc.getAccid());
//				client.setVisible(true);
//				this.setVisible(false);
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "pass and user not matched");
//		}
//	}
//}
