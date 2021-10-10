package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.mindrot.jbcrypt.BCrypt;

import dao.AccountDao;
import entity.Account;
import helper.Regex;
import helper.Validation;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ListSelectionModel;

public class AdminAccount extends JInternalFrame {
	private JTextField txtSearch;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelte;
	private JButton btnCancel;
	private JTextField txtNumcard;
	private JButton btnSearch;
	private JButton btnShowInforAccount;
	private JTextField txtfullname;
	private JLabel lblnumcard;
	private JLabel lblFullName;
	private JLabel lblPinNum;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblGender;
	private JLabel lblDob;
	private JTextField txtPin;
	private JDateChooser dateChooser;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private String gender = "male";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_4;
	private JLabel lblid;
	private JLabel lblaccid;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AdminAccount() {
		setClosable(true);
		setBounds(10, 10, 770, 591);

		panel_1 = new JPanel();

		panel_2 = new JPanel();

		panel_3 = new JPanel();

		panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));

		scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(211, 211, 211));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(29, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

		panel_4 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, 0, 0, Short.MAX_VALUE))))
					.addGap(251))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_4, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 265, Short.MAX_VALUE))
					.addGap(133))
		);

		txtNumcard = new JTextField();

		txtNumcard.setColumns(10);

		txtfullname = new JTextField();
		txtfullname.setColumns(10);

		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMaleActionPerformed(e);
			}
		});
		rdbtnMale.setSelected(true);
		rdbtnMale.setFont(new Font("VNI-Helve-Condense", Font.PLAIN, 15));

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFemaleActionPerformed(e);
			}
		});
		rdbtnFemale.setFont(new Font("VNI-Helve-Condense", Font.PLAIN, 15));

		dateChooser = new JDateChooser();

		txtPin = new JTextField();
		txtPin.setColumns(10);

		lblaccid = new JLabel("");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblaccid, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(rdbtnMale)
								.addGap(62)
								.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addGap(104))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(txtPin, 301, 301, 301)
								.addContainerGap(25, Short.MAX_VALUE))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
								.addGap(25))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(txtfullname, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
								.addGap(25))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(txtNumcard, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
								.addGap(25)))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblaccid, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtNumcard, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfullname, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		panel_4.setLayout(gl_panel_4);

		lblnumcard = new JLabel("Numcard :");
		lblnumcard.setFont(new Font("VNI-Couri", Font.BOLD | Font.ITALIC, 20));

		lblFullName = new JLabel("Full Name :");
		lblFullName.setFont(new Font("VNI-Couri", Font.BOLD | Font.ITALIC, 20));

		lblPinNum = new JLabel("Pin Num :");
		lblPinNum.setFont(new Font("VNI-Couri", Font.BOLD | Font.ITALIC, 20));

		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("VNI-Couri", Font.BOLD | Font.ITALIC, 20));

		lblDob = new JLabel("Dob :");
		lblDob.setFont(new Font("VNI-Couri", Font.BOLD | Font.ITALIC, 20));

		lblid = new JLabel("AccId  :");
		lblid.setFont(new Font("VNI-Couri", Font.BOLD | Font.ITALIC, 20));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(78)
					.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addComponent(lblnumcard, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPinNum, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender))
					.addGap(25))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(lblnumcard, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPinNum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		panel_3.setLayout(gl_panel_3);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnSearch.setBackground(Color.BLUE);

		btnShowInforAccount = new JButton("Show acc");
		btnShowInforAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowInforAccountActionPerformed(e);
			}
		});

		btnShowInforAccount.setForeground(Color.WHITE);
		btnShowInforAccount.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnShowInforAccount.setBackground(Color.PINK);

		lblNewLabel = new JLabel("<html>&#128270;</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnShowInforAccount)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnShowInforAccount, GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(txtSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43,
										Short.MAX_VALUE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		btnInsert = new JButton("Add Account");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});

		btnInsert.setFont(new Font("VNI-Palatin", Font.PLAIN, 16));
		btnInsert.setBackground(Color.CYAN);

		btnUpdate = new JButton("Edit Account");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("VNI-Palatin", Font.PLAIN, 16));
		btnUpdate.setBackground(Color.GREEN);

		btnDelte = new JButton("Delete");
		btnDelte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelteActionPerformed(e);
			}
		});
		btnDelte.setFont(new Font("VNI-Palatin", Font.PLAIN, 16));
		btnDelte.setBackground(Color.RED);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
		btnCancel.setFont(new Font("VNI-Palatin", Font.PLAIN, 16));
		btnCancel.setBackground(Color.YELLOW);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnInsert, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 145,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 145,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(btnDelte, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnDelte, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(91, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);

	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		LoginAdmin login = new LoginAdmin();
		login.setVisible(true);
		this.setVisible(false);
	}

	protected void btnShowInforAccountActionPerformed(ActionEvent e) {
		AccountDao accdao = new AccountDao();
		LoadAcc(accdao);
	}

	private void LoadAcc(AccountDao dao) {
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return Integer.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return LocalDate.class;
				case 5:
					return String.class;
				default:
					return String.class;
				}
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("Accid");
		model.addColumn("Numcardacc");
		model.addColumn("Fullname");
		model.addColumn("Gender");
		model.addColumn("Dob");
		model.addColumn("IsAdmin");

		dao.getAccount().forEach(acc -> model.addRow(new Object[] { acc.getAccid(), acc.getNumcardacc(),
				acc.getFullname(), acc.getGender(), acc.getDob(), acc.getIsAdmin() }));
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		String find = txtSearch.getText();
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + find));
		sorter.setSortKeys(null);

	}

	protected void btnUpdateActionPerformed(ActionEvent e) {
		AccountDao accdao = new AccountDao();
		Account acc = new Account();
		acc.setNumcardacc(txtNumcard.getText());
		acc.setFullname(txtfullname.getText());
		accdao.editAccount(acc);
		LoadAcc(accdao);
	}

	protected Object btnDelteActionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure delete?", "delete", JOptionPane.ERROR_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			AccountDao accdao = new AccountDao();
			Account acc = new Account();
			acc.setNumcardacc(txtNumcard.getText());
			accdao.deleteAccount(acc);
			LoadAcc(accdao);
			JOptionPane.showMessageDialog(null, "Delete success");
			lblaccid.setText("");
			txtfullname.setText("");
			txtNumcard.setText("");
			txtPin.setText("");

		} else {
			JOptionPane.showMessageDialog(null, "can't delete");
		}
		return result;
	}

	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		lblaccid.setText(table.getValueAt(row, 0).toString());
		txtNumcard.setText(table.getValueAt(row, 1).toString());
		txtfullname.setText(table.getValueAt(row, 2).toString());
		String sex = table.getValueAt(row, 3).toString();
		if (sex.equals("male")) {
			rdbtnMale.setSelected(true);
		} else if (sex.equals("female")) {
			rdbtnFemale.setSelected(true);
			;
		}
		try {
			dateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(row, 4).toString()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	protected void btnInsertActionPerformed(ActionEvent e) {
		AccountDao accdao = new AccountDao();
		Account acc = new Account();
		if (Validation.checkRegex(Regex.NUM, txtNumcard.getText()) && txtNumcard.getText().length() == 8) {
			acc.setNumcardacc(txtNumcard.getText());
		} else {
			JOptionPane.showConfirmDialog(null, "You must be enter 8 number");
		}
		if (Validation.checkRegex(Regex.NAME, txtfullname.getText())) {
			acc.setFullname(txtfullname.getText());
		} else {
			JOptionPane.showConfirmDialog(null, "You must enter fullname");
		}
		acc.setGender(rdbtnFemale.isSelected() ? "female" : "male");
		acc.setDob(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		if (Validation.checkRegex(Regex.NUMTO6, txtPin.getText()) && txtPin.getText().length() == 6) {
			String hash = null;
			hash = BCrypt.hashpw(txtPin.getText(), BCrypt.gensalt());
			acc.setPinNum(hash);
		} else {
			JOptionPane.showConfirmDialog(null, "You must be enter 6 number");
		}

		accdao.insertAccount(acc);
		LoadAcc(accdao);
	}

	protected void rdbtnMaleActionPerformed(ActionEvent e) {
		gender = "male";
	}

	protected void rdbtnFemaleActionPerformed(ActionEvent e) {
		gender = "female";
	}
}
