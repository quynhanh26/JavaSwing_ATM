package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import common.ConnectDB;
import dao.AccountDao;
import dao.TransactionDao;
import entity.Account;
import entity.Transaction;
import helper.Regex;
import helper.Validation;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ShowInfor extends JDialog {
	private JPanel panel_2;
	private JLabel lblInfor;
	private JTextField txtpin;
	private JLabel lblpinNum;
	private JButton btnWithdrawal;
	private JButton btnTransfer;
	private JButton btnRecharge;
	private JButton btnInfroAcc;
	private JLabel lblNewLabel;
	private JLabel lblname;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblnum;
	private JLabel lblmoney;
	private JTextField txtchane;
	private JButton btnupdate;
	private JLabel lblaccid;
	private JTextField txtaccid;
	private JButton btnNum1;
	private JButton btnNum2;
	private JButton btnNum3;
	private JButton btnNum4;
	private JButton btnNum5;
	private JButton btnNum6;
	private JButton btnNum7;
	private JButton btnNum8;
	private JButton btnNum9;
	private JButton btnNum0;
	private JButton btnEnter;
	private JButton btnCancel;
	private JButton btnClear;
	private JButton btnBack;
	private int fee = 1100;
	private JButton btnLogin;
	private String numcardacc;

	public String getNumcardacc() {
		return numcardacc;
	}

	public void setNumcardacc(String numcardacc) {
		this.numcardacc = numcardacc;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ShowInfor dialog = new ShowInfor();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ShowInfor() {
		setBounds(100, 100, 813, 460);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		btnNum1 = new JButton("1");
		btnNum1.setBackground(Color.LIGHT_GRAY);
		btnNum1.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});

		btnNum1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum2 = new JButton("2");
		btnNum2.setBackground(Color.LIGHT_GRAY);
		btnNum2.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum3 = new JButton("3");
		btnNum3.setBackground(Color.LIGHT_GRAY);
		btnNum3.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.RED);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("VNI-Times", Font.ITALIC, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn(e);
			}
		});
		btnCancel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum4 = new JButton("4");
		btnNum4.setBackground(Color.LIGHT_GRAY);
		btnNum4.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum5 = new JButton("5");
		btnNum5.setBackground(Color.LIGHT_GRAY);
		btnNum5.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum6 = new JButton("6");
		btnNum6.setBackground(Color.LIGHT_GRAY);
		btnNum6.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("VNI-Times", Font.ITALIC, 20));
		btnClear.setBackground(Color.YELLOW);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn(e);
			}
		});
		btnClear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum7 = new JButton("7");
		btnNum7.setBackground(Color.LIGHT_GRAY);
		btnNum7.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum8 = new JButton("8");
		btnNum8.setBackground(Color.LIGHT_GRAY);
		btnNum8.setFont(new Font("VNI-Oxford", Font.BOLD, 26));
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum9 = new JButton("9");
		btnNum9.setBackground(Color.LIGHT_GRAY);
		btnNum9.setFont(new Font("VNI-Oxford", Font.PLAIN, 26));
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn(e);
			}
		});

		btnEnter.setFont(new Font("VNI-Times", Font.ITALIC, 20));
		btnEnter.setBackground(Color.GREEN);

		btnEnter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(ShowInfor.class.getResource("/ATM_Icon/empty.png")));
		btnNewButton_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNum0 = new JButton("0");
		btnNum0.setBackground(Color.LIGHT_GRAY);
		btnNum0.setFont(new Font("VNI-Oxford", Font.PLAIN, 26));
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Num(e);
			}
		});
		btnNum0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JButton btnNewButton_14 = new JButton("");

		btnNewButton_14.setIcon(new ImageIcon(ShowInfor.class.getResource("/ATM_Icon/empty.png")));
		btnNewButton_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn(e);
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("VNI-Times", Font.ITALIC, 20));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNum4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNum7, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 90,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addComponent(btnNum1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
				.addGap(27)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnNum0, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_14, GroupLayout.PREFERRED_SIZE, 90,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnNum8, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNum9, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnNum5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNum6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnNum2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnNum3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnter, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNum2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNum1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNum3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNum4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNum5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNum6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNum7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNum8, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNum9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNum0, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_14, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		panel.setLayout(gl_panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);

		btnWithdrawal = new JButton("Debit");
		btnWithdrawal.setBackground(Color.LIGHT_GRAY);
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Load(e);
			}
		});

		btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Load(e);
			}
		});
		btnTransfer.setBackground(Color.LIGHT_GRAY);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnWithdrawal, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(btnWithdrawal, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGap(29)
						.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		JPanel panel_4 = new JPanel();

		txtpin = new JTextField();
		txtpin.setVisible(false);
		txtpin.setColumns(10);

		lblpinNum = new JLabel("Welcome customer");

		lblaccid = new JLabel("Enter numcard:");
		lblaccid.setVisible(false);

		txtaccid = new JTextField();
		txtaccid.setColumns(10);
		txtaccid.setVisible(false);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGap(72)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblpinNum, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtpin, Alignment.LEADING).addComponent(txtaccid,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
						.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_panel_4.createSequentialGroup().addGap(82).addComponent(lblaccid, GroupLayout.DEFAULT_SIZE,
						88, Short.MAX_VALUE)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGap(14)
						.addComponent(lblpinNum, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtpin, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE).addGap(1)
						.addComponent(lblaccid, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtaccid, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_4.setLayout(gl_panel_4);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);

		btnRecharge = new JButton("Credit");
		btnRecharge.setBackground(Color.LIGHT_GRAY);
		btnRecharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Load(e);
			}
		});

		btnInfroAcc = new JButton("Infro Acc");
		btnInfroAcc.setBackground(Color.LIGHT_GRAY);
		btnInfroAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Load(e);
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRecharge, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInfroAcc, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(btnRecharge, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGap(31)
						.addComponent(btnInfroAcc, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(
										groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(panel_4, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
														.addComponent(panel_1, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
												.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 152,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));

		lblInfor = new JLabel("Infor Account");

		lblNewLabel = new JLabel("Tên tài khoản:");

		lblname = new JLabel("");

		lblNewLabel_1 = new JLabel("Số tài khoản:");

		lblNewLabel_2 = new JLabel("Số tiền:");

		lblNewLabel_3 = new JLabel("Change pass");

		lblnum = new JLabel("");

		lblmoney = new JLabel("");

		txtchane = new JTextField();
		txtchane.setColumns(10);

		btnupdate = new JButton("Update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn(e);
			}
		});

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn(e);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup().addGap(62).addComponent(lblInfor,
								GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblname, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblnum,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnupdate, GroupLayout.PREFERRED_SIZE, 67,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 71,
														GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED).addGroup(
										gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
														.addComponent(lblmoney, GroupLayout.DEFAULT_SIZE, 177,
																Short.MAX_VALUE)
														.addComponent(txtchane))
												.addGroup(Alignment.TRAILING,
														gl_panel_2.createSequentialGroup()
																.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 67,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(27)))))
				.addGap(17)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(lblInfor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblname, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblnum, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblmoney, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(32)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtchane, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(32)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnupdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(85, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
	}

//	protected void btnCancelActionPerformed(ActionEvent e) {
//		JFrame frame = new JFrame("Exit");
//		if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit Form Login",
//				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
//			System.exit(0);
//		}
//	}

	public void Num(ActionEvent e) {
		if (e.getSource() == btnNum1) {
			txtpin.setText(txtpin.getText() + 1);
		} else if (e.getSource() == btnNum2) {
			txtpin.setText(txtpin.getText() + 2);
		} else if (e.getSource() == btnNum3) {
			txtpin.setText(txtpin.getText() + 3);
		} else if (e.getSource() == btnNum4) {
			txtpin.setText(txtpin.getText() + 4);
		} else if (e.getSource() == btnNum5) {
			txtpin.setText(txtpin.getText() + 5);
		} else if (e.getSource() == btnNum6) {
			txtpin.setText(txtpin.getText() + 6);
		} else if (e.getSource() == btnNum7) {
			txtpin.setText(txtpin.getText() + 7);
		} else if (e.getSource() == btnNum8) {
			txtpin.setText(txtpin.getText() + 8);
		} else if (e.getSource() == btnNum9) {
			txtpin.setText(txtpin.getText() + 9);
		} else if (e.getSource() == btnNum0) {
			txtpin.setText(txtpin.getText() + 0);
		}
	}

	public void Infor(AccountDao client) {
		Account acc = client.Showinfor1(numcardacc);
		lblname.setText(acc.getFullname());
		lblnum.setText(acc.getNumcardacc() + "");
		lblmoney.setText(acc.getBalance() + "");
	}

	public void UpdateTrans(TransactionDao transac) {
		Transaction trans = new Transaction();
		trans.setNumcardacc(numcardacc);
		trans.setNumcardtrans(txtaccid.getText());
		trans.setAmount(Integer.parseInt(txtpin.getText()));
		trans.setDispatchDate(LocalDate.now());
		trans.setDeliveryTime(LocalTime.now());
		transac.insertTrans(trans);

	}

//	public void Withdrawal(AccountDao client) {
//		Account acc = new Account();
//		int wid = Integer.parseInt(txtpin.getText());
//		if (wid >= 5000000) {
//			lblpinNum.setText("Amount is exceeds normals");
//			lblaccid.setVisible(false);
//			txtpin.setVisible(false);
//			txtaccid.setVisible(false);
//			btnRecharge.setVisible(false);
//			btnTransfer.setVisible(false);
//			btnWithdrawal.setVisible(false);
//			btnInfroAcc.setVisible(false);
//		} else if (wid <= 100) {
//			lblpinNum.setText("Amounts too low");
//			txtpin.setVisible(false);
//			lblaccid.setVisible(false);
//			txtaccid.setVisible(false);
//			btnRecharge.setVisible(false);
//			btnTransfer.setVisible(false);
//			btnWithdrawal.setVisible(false);
//			btnInfroAcc.setVisible(false);
//		} else {
//			try (var connect = ConnectDB.getConnection(); var stmt = connect.createStatement();) {
//				var rs = stmt.executeQuery("select * from Account where accid = " + (accid));
//				if (rs.next()) {
//					int balance = rs.getInt("balance");
//					if (balance >= wid) {
//						int temp = balance - wid;
//						int row = stmt
//								.executeUpdate("Update Account set balance =" + (temp) + "where accid = " + (accid));
//						if (row == 0) {
//							lblpinNum.setText("No widthrawal occured");
//							txtpin.setVisible(false);
//							lblaccid.setVisible(false);
//							txtaccid.setVisible(false);
//							btnRecharge.setVisible(false);
//							btnTransfer.setVisible(false);
//							btnWithdrawal.setVisible(false);
//							btnInfroAcc.setVisible(false);
//						} else {
//							lblpinNum.setText("Widthrawal " + (wid) + " success");
//							Infor(client);
//							txtpin.setVisible(false);
//							lblaccid.setVisible(false);
//							txtaccid.setVisible(false);
//							btnRecharge.setVisible(false);
//							btnTransfer.setVisible(false);
//							btnWithdrawal.setVisible(false);
//							btnInfroAcc.setVisible(false);
//						}
//					} else {
//						lblpinNum.setText("The amount in the account is not enough");
//						txtpin.setVisible(false);
//						lblaccid.setVisible(false);
//						txtaccid.setVisible(false);
//						btnRecharge.setVisible(false);
//						btnTransfer.setVisible(false);
//						btnWithdrawal.setVisible(false);
//						btnInfroAcc.setVisible(false);
//					}
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	}
//
//	public void Received(ClientDao client) {
//		Account acc = new Account();
//		int wid = Integer.parseInt(txtpin.getText());
//		try (var connect = ConnectDB.getConnection(); var stmt = connect.createStatement();) {
//			var rs = stmt.executeQuery("select * from Account where accid = '" + txtaccid.getText() + "'");
//			if (rs.next()) {
//				int balance = rs.getInt("balance");
//				int temp = balance + wid;
//				int row = stmt.executeUpdate(
//						"Update Account set balance =" + (temp) + "where accid = '" + txtaccid.getText() + "'");
//				if (row == 0) {
//					lblpinNum.setText("No widthrawal occured");
//					txtpin.setVisible(false);
//					lblaccid.setVisible(false);
//					txtaccid.setVisible(false);
//					btnRecharge.setVisible(false);
//					btnTransfer.setVisible(false);
//					btnWithdrawal.setVisible(false);
//					btnInfroAcc.setVisible(false);
//				} else {
//					lblpinNum.setText("Widthrawal " + (wid) + " success");
//					Infor(client);
//					txtpin.setVisible(false);
//					lblaccid.setVisible(false);
//					txtaccid.setVisible(false);
//					btnRecharge.setVisible(false);
//					btnTransfer.setVisible(false);
//					btnWithdrawal.setVisible(false);
//					btnInfroAcc.setVisible(false);
//				}
//			}
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//	}

	public void Load(TransactionDao transac) {
		Transaction trans = new Transaction();
		trans.setNumcardacc(numcardacc);
		trans.setNumcardtrans(txtaccid.getText());
		trans.setAmount(Integer.parseInt(txtpin.getText()));
		trans.setDispatchDate(LocalDate.now());
		trans.setDeliveryTime(LocalTime.now());
		transac.insertTrans(trans);

	}

	public void Load(ActionEvent e) {
		AccountDao client = new AccountDao();
		TransactionDao transdao = new TransactionDao();
		if (e.getSource() == btnInfroAcc) {
			Infor(client);
			btnRecharge.setVisible(false);
			btnTransfer.setVisible(false);
			btnWithdrawal.setVisible(false);
			btnInfroAcc.setVisible(false);
			lblpinNum.setVisible(false);
			txtpin.setVisible(false);
			lblaccid.setVisible(false);
			txtaccid.setVisible(false);
		} else if (e.getSource() == btnRecharge) {
			Account acc =client.Showinfor1(numcardacc);
			if (!txtpin.getText().isEmpty() && Integer.parseInt(txtpin.getText()) >= 1000
					&& Integer.parseInt(txtpin.getText()) <= 5000000) {
				client.UpdateBa(numcardacc, Integer.parseInt(txtpin.getText()) + acc.getBalance());
				lblpinNum.setText("Recharge success");
				txtpin.setVisible(false);
				lblaccid.setVisible(false);
				txtaccid.setVisible(false);
				Infor(client);
				btnRecharge.setVisible(false);
				btnTransfer.setVisible(false);
				btnWithdrawal.setVisible(false);
				btnInfroAcc.setVisible(false);
			}else if(txtpin.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "The balance empty");
			}else {
				JOptionPane.showMessageDialog(null, "You can't credit");
			}
			
		} else if (e.getSource() == btnWithdrawal) {
			Account acc = new Account();
			acc.setBalance(Integer.parseInt(txtpin.getText()));
			if (txtpin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "The password empty");
			} else {
				client.RechargeBal(acc, numcardacc);
				lblpinNum.setText("Debit success");
				txtpin.setVisible(false);
				lblaccid.setVisible(false);
				txtaccid.setVisible(false);
				Infor(client);
				btnRecharge.setVisible(false);
				btnTransfer.setVisible(false);
				btnWithdrawal.setVisible(false); 
				btnInfroAcc.setVisible(false);
			}
		} else { 
			Account acc = client.Showinfor1(numcardacc);
			Account acc1 = client.Showinfor1(txtaccid.getText());
			int fee = 2000;
			int wid = Integer.parseInt(txtpin.getText());
			if (Validation.checkRegex(Regex.NUM, txtaccid.getText()) && txtaccid.getText().length() == 8) {
				if (!txtaccid.getText().equals(numcardacc) && Integer.parseInt(txtpin.getText()) >= 1000
						&& Integer.parseInt(txtpin.getText()) < (acc.getBalance() - fee)
						&& client.checkAccount(txtaccid.getText()) == true) {
					client.Transfer(numcardacc , txtaccid.getText(), acc.getBalance() - fee - wid, acc1.getBalance() + wid );
					Infor(client);
					JOptionPane.showMessageDialog(null, "You tranfer " + txtpin.getText() + " to " + acc1.getFullname() +" success");
					UpdateTrans(transdao);
				} else if (txtaccid.getText().equals(numcardacc)) {
					JOptionPane.showMessageDialog(null, "Cannot transfer money to yourself");
				} else if (txtaccid.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a Account code number");
				} else if (Integer.parseInt(txtpin.getText()) < (acc.getBalance() - fee)
						&& !txtaccid.getText().isEmpty() && client.checkAccount(txtaccid.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Acc code does not exist");
				} else {
					JOptionPane.showMessageDialog(null, "The amount in the account is not enough");
				}
			} else {
				txtaccid.setText("");
			}
		}

	}

	public void btn(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			JFrame frame = new JFrame("Exit");
			if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit showinfor",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource() == btnEnter) {
			lblpinNum.setText("Enter balance");
			txtpin.setVisible(true);
			lblaccid.setVisible(true);
			txtaccid.setVisible(true);
		} else if (e.getSource() == btnClear) {
			txtpin.setText("");
			txtaccid.setText("");
		} else if (e.getSource() == btnupdate) {
			Account acc = new Account();
			AccountDao dao = new AccountDao();
			String pass = txtchane.getText();
			String hash = null;
			if (pass != null && !pass.isEmpty()) {
				hash = BCrypt.hashpw(pass, BCrypt.gensalt());
			}
			acc.setNumcardacc(numcardacc);
			acc.setPinNum(hash);
			dao.editAccount(acc);
		} else if (e.getSource() == btnBack) {
			lblpinNum.setVisible(true);
			txtpin.setVisible(true);
			lblaccid.setVisible(true);
			txtaccid.setVisible(true);
			btnRecharge.setVisible(true);
			btnTransfer.setVisible(true);
			btnWithdrawal.setVisible(true);
			btnInfroAcc.setVisible(true);

		} else if (e.getSource() == btnLogin) {
			LoginAdmin login = new LoginAdmin();
			login.setVisible(true);
			this.setVisible(false);
		}

	}

}
