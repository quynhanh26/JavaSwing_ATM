package dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import common.ConnectDB;
import entity.Transaction;

public class TransactionDao {
	public List<Transaction> getTransaction() {

		var list = new ArrayList<Transaction>();

		try (var conn = ConnectDB.getConnection();
				var cs = conn.prepareCall("{ call selAllTrans }");
				var rs = cs.executeQuery()) {
			while (rs.next()) {
				var trans = new Transaction();
				trans.setTranid(rs.getInt("transid"));
				trans.setNumcardacc(rs.getString("numcardacc"));
				trans.setNumcardtrans(rs.getString("numcardtrans"));
				trans.setAmount(rs.getInt("amount"));
				trans.setDispatchDate(rs.getDate("dispatchDate").toLocalDate());
				trans.setDeliveryTime(rs.getTime("deliveryTime").toLocalTime());
				list.add(trans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertTrans(Transaction trans) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call insertTran(?,?,?,?,?)}");) {
			cs.setString(1, trans.getNumcardacc());
			cs.setString(2, trans.getNumcardtrans());
			cs.setInt(3, trans.getAmount());
			cs.setDate(4, Date.valueOf(trans.getDispatchDate()));
			cs.setTime(5, Time.valueOf(trans.getDeliveryTime()));
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editTrans(Transaction trans) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call updateTrans(?,?,?,?)}");) {
			cs.setString(1, trans.getNumcardtrans());
			cs.setInt(2, trans.getAmount());
			cs.setDate(3, Date.valueOf(trans.getDispatchDate()));
			cs.setTime(4, Time.valueOf(trans.getDeliveryTime()));
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTrans(Transaction acc) {
		try (var connect = ConnectDB.getConnection(); var cs = connect.prepareCall("{call delTran(?)}");) {
			cs.setInt(1, acc.getTranid());
			var rs = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
