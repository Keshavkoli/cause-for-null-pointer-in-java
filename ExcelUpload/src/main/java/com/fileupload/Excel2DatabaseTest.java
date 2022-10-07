package com.fileupload;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2DatabaseTest {
	public static void main(String[] args) throws SQLException, IOException {

		// Database connection
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HRC_DATABASE", "root", "root");
		Statement stmt = con.createStatement();

		// create a new table in the database 'places'
		String sql = "create table HRC(EMPCODE varchar(40), LOGINID varchar(40),LOGINNAME varchar(40),Email_ID varchar(30),USERCODE varchar(40),ZONE varchar(40),CLUSTER(40),BRANCHCODE(40))";
		stmt.execute(sql);

		// Excel
		FileInputStream fis = new FileInputStream(".C:\\Users\\91774\\Desktop\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rows = sheet.getLastRowNum();

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			double empId = row.getCell(0).getNumericCellValue();
			String logid = row.getCell(1).getStringCellValue();
			String logname = row.getCell(2).getStringCellValue();
			String email = row.getCell(3).getStringCellValue();
			String ucode = row.getCell(4).getStringCellValue();
			String zone = row.getCell(5).getStringCellValue();
			String clus = row.getCell(5).getStringCellValue();
			String branch = row.getCell(5).getStringCellValue();

			sql = "insert into HRC values('" + empId + "', '" + logid + "', '" + logname + "', '" + email + "', '"
					+ ucode + "', '" + zone + "','" + clus + "','" + branch + "')";
			stmt.execute(sql);
			stmt.execute("commit");
		}

		workbook.close();
		fis.close();
		con.close();

		System.out.println("Done!!");

	}
}
