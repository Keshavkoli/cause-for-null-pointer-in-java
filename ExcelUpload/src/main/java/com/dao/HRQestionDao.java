package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import com.connection.HRCDBConnection;
import com.excelpojo.ExcelCellModel;

/**
 * @author Keshav_Koli
 */
public class HRQestionDao {

	public static boolean insertRecords(List<ExcelCellModel> excelList) throws NamingException, SQLException {
		Connection connection = null;
		PreparedStatement cst = null;
		System.out.println("HRQestionDao.insertRecords()");
		try {
			connection = HRCDBConnection.getConnection();
//			final String sql = "INSERT INTO EXCEL_UPLOAD (EMPCODE,LOGINID,LOGINNAME,Email_ID,USERCODE,ZONE,CLUSTER,BRANCHCODE)"
//					+ " VALUES (?,?,?,?,?,?,?,?)";
//			cst = connection.prepareCall(sql);

			connection.setAutoCommit(false);
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO EXCEL_UPLOAD(EMPCODE,LOGINID,LOGINNAME,Email_ID,USERCODE,ZONE,CLUSTER,BRANCHCODE) VALUES(?,?,?,?,?,?,?,?)");
			for (ExcelCellModel ecm : excelList) {
				ps.setObject(1, ecm.getEmpCode());
				ps.setObject(2, ecm.getLoginId());
				ps.setObject(3, ecm.getLoginName());
				ps.setObject(4, ecm.getEmailId());
				ps.setObject(5, ecm.getUserCode());
				ps.setObject(6, ecm.getZone());
				ps.setObject(7, ecm.getCluster());
				ps.setObject(8, ecm.getBranchCode());
				ps.addBatch();
			}
			System.out.println("HRQestionDao.insertRecords()2");
			int[] numUpdates = ps.executeBatch();
			System.out.println("HRQestionDao.insertRecords(): " + numUpdates);
			for (int i = 0; i < numUpdates.length; i++) {
				if (numUpdates[i] == -2)
					System.out.println("Execution " + i + ": unknown number of rows updated");
				else
					System.out.println("Execution " + i + "successful: " + numUpdates[i] + " rows updated");
			}
			connection.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(HRQestionDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (cst != null) {
				HRCDBConnection.closeStatement(cst);
			}
			if (connection != null) {
				HRCDBConnection.closeConnection(connection);
			}
		}
		return false;

	}

}
