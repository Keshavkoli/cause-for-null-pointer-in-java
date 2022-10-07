package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.SystemException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HRCDBConnection {
	static Logger logger;
	private static Map dataSourceCache;
	static String USERNAME;
	static String PASSWORD;
	static String CONNECTION_URL;

	static {
		HRCDBConnection.logger = LogManager.getLogger(HRCDBConnection.class.getName());
		HRCDBConnection.dataSourceCache = new HashMap();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException ex) {
			HRCDBConnection.logger.info((Object) "----Class name not found----");
		}
		HRCDBConnection.USERNAME = HRCDBConfig.USERNAME;
		HRCDBConnection.PASSWORD = HRCDBConfig.PASSWORD;
		HRCDBConnection.CONNECTION_URL = HRCDBConfig.CONNECTION_URL;

	}

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(HRCDBConnection.CONNECTION_URL, HRCDBConnection.USERNAME,
					HRCDBConnection.PASSWORD);
			return con;
		} catch (Exception e) {
			HRCDBConnection.logger.info((Object) ("--Exception getConnection method " + e.getMessage()));
			return null;
		}
	}

	public static void closeConnection(final Connection con) throws SQLException {
		try {
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			HRCDBConnection.logger.info((Object) ("--Exception closeConnection method " + ex.getMessage()));
		}
	}

	public static void closeStatement(final Statement st) throws SQLException {
		try {
			st.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			HRCDBConnection.logger.info((Object) ("--Exception closeStatement method " + ex.getMessage()));
		}
	}

	public static void closeResultSet(final ResultSet rs) {
		try {
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			HRCDBConnection.logger.info((Object) ("--Exception closeResultSet method " + ex.getMessage()));
		}
	}

	public static DataSource getDataSource(final String dataSourceName) {
		DataSource dataSource = (DataSource) HRCDBConnection.dataSourceCache.get(dataSourceName);
		if (dataSource == null) {
			try {
				dataSource = getNewDataSource(dataSourceName);
			} catch (Exception ex) {
				ex.printStackTrace();
				HRCDBConnection.logger.info((Object) ("--Exception getDataSource method " + ex.getMessage()));
			}
		}
		return dataSource;
	}

	private static DataSource getNewDataSource(final String dataSourceName) throws NamingException {
		final Context context = new InitialContext();
		final DataSource dataSource = (DataSource) context.lookup(dataSourceName);
		HRCDBConnection.dataSourceCache.put(dataSourceName, dataSource);
		return dataSource;
	}

	public static Connection getConnection(final DataSource dataSource) throws SystemException {
		if (dataSource == null) {
			HRCDBConnection.logger.info((Object) "--DataSource Name is Null--");
		}
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
			HRCDBConnection.logger
					.info((Object) ("--Exception getConnection using datasource method " + ex.getMessage()));
		}
		return connection;
	}

	public static String getDataSourceName() {
		HRCDBConnection.logger.info((Object) "--Inside the DataSourceName() method--");
		return HRCDBConnection.USERNAME;
	}

	public static void main(String h[]) throws Exception {
		Connection con = HRCDBConnection.getConnection();
		System.out.println(con);

	}
}