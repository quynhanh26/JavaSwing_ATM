package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import common.ConnectDB;
import entity.Account;

public class AccountDao {
	public List<Account> getAccount() {

		var list = new ArrayList<Account>();

		try (var conn = ConnectDB.getConnection();
				var cs = conn.prepareCall("{ call selAllAcc }");
				var rs = cs.executeQuery()) {
			while (rs.next()) {
				var acc = new Account();
				acc.setAccid(rs.getInt("accid"));
				acc.setNumcardacc(rs.getString("numcardacc"));
				acc.setFullname(rs.getString("fullname"));
				acc.setGender(rs.getString("gender"));
				acc.setDob(rs.getDate("dob").toLocalDate());
				acc.setPinNum(rs.getString("pinNum"));
				acc.setBalance(rs.getInt("balance"));
				acc.setIsAdmin(rs.getString("IsAdmin"));
				list.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertAccount(Account acc) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call insertAcc(?,?,?,?,?)}");) {
			cs.setString(1, acc.getNumcardacc());
			cs.setString(2, acc.getFullname());
			cs.setString(3, acc.getGender());
			cs.setDate(4, Date.valueOf(acc.getDob()));
			cs.setString(5, acc.getPinNum());
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editAccount(Account acc) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call updateAcc(?,?)}");) {
			cs.setString(1, acc.getNumcardacc());
			cs.setString(2, acc.getFullname());
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(Account acc) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call delAcc(?)}");) {
			cs.setString(1, acc.getNumcardacc());
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CallableStatement createCS(Connection connect, String stored, String numcardacc) throws Exception {
		var cs = connect.prepareCall(stored);
		cs.setString(1, numcardacc);
		return cs;
	}

	public CallableStatement createCS1(Connection connect, String stored, String numcardacc) throws Exception {
		var cs = connect.prepareCall(stored);
		cs.setString(1, numcardacc);
		return cs;
	}

	public Account Showinfor(String fullname) {
		Account acc = new Account();
		try (var connect = ConnectDB.getConnection(); var cs = createCS1(connect, "{call selecAdmin(?)}", fullname);) {
			var rs = cs.executeQuery();
			while (rs.next()) {
				acc.setNumcardacc(rs.getString("numcardacc"));
				acc.setFullname(rs.getString("fullname"));
				acc.setGender(rs.getString("gender"));
				acc.setDob(rs.getDate("dob").toLocalDate());
				acc.setPinNum(rs.getString("pinNum"));
				acc.setBalance(rs.getInt("balance"));
				acc.setIsAdmin(rs.getString("IsAdmin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

//	public CallableStatement createCS1(Connection connect, String stored, String numcardacc) throws Exception {
//		var cs = connect.prepareCall(stored);
//		cs.setString(1, numcardacc);
//		return cs;
//	}
//	

	public Account Showinfor1(String numcardacc) {
		Account acc = new Account();
		try (var connect = ConnectDB.getConnection(); var cs = createCS(connect, "{call selInfor(?)}", numcardacc);) {
			var rs = cs.executeQuery();
			while (rs.next()) {
				acc.setFullname(rs.getString("fullname"));
				acc.setNumcardacc(rs.getString("numcardacc"));
				acc.setBalance(rs.getInt("balance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	public void UpdateBa(String numcardacc, int balance) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call updatebalance(?,?) }");) {
			cs.setString(1, numcardacc);
			cs.setInt(2, balance);
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void RechargeBal(Account acc, String numcardacc) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call recharge(?,?) }");) {
			cs.setString(1, numcardacc);
			cs.setInt(2, acc.getBalance());
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int Transfer(String numcardacc,  String numcardtrans,int  amountacc , int amounttrans) {
		Account acc = new Account();
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call transTo(?,?,?,?) }");) {
			cs.setString(1,numcardacc );
			cs.setString(2,numcardtrans );
			cs.setInt(3, amountacc);
			cs.setInt(4, amounttrans);
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amountacc;
	}

	public boolean checkAccount(String numcardacc) {
		try (var connect = ConnectDB.getConnection(); var cs = createCS(connect, "{call checkAcc(?)}", numcardacc);) {
			var rs = cs.executeQuery();
			rs.next();
			boolean exists = rs.getInt(1) > 0;
			return exists;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
