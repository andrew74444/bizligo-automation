package com.cpcommunity.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DbManager {
	private static Connection con = null; // sql
	private static Connection conn = null; // mysql

	// SQL Server
	public static void setDbConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(TestConfig.driver);
			con = DriverManager.getConnection(TestConfig.dbConnectionUrl, TestConfig.dbUserName, TestConfig.dbPassword);

			if (!con.isClosed())
				System.out.println("Successfully connected to SQL server");

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());

			// monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
			// TestConfig.subject+" - (Script failed with Error, Datamart database used for
			// reports, connection not established)", TestConfig.messageBody,
			// TestConfig.attachmentPath, TestConfig.attachmentName);
		}

	}

	// public static void setMysqlDbConnection() throws SQLException,
	// ClassNotFoundException
	// {
	// try
	// {
	//
	// Class.forName (TestConfig.mysqldriver);
	// conn = DriverManager.getConnection (TestConfig.mysqlurl,
	// TestConfig.mysqluserName, TestConfig.mysqlpassword);
	// if(!conn.isClosed())
	// System.out.println("Successfully connected to MySQL server");
	//
	//
	// }
	// catch (Exception e)
	// {
	// System.err.println ("Cannot connect to database server");
	//
	// // monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
	// TestConfig.subject+" - (Script failed with Error, Datamart database used for
	// reports, connection not established)", TestConfig.messageBody,
	// TestConfig.attachmentPath, TestConfig.attachmentName);
	// }

	// }

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		setDbConnection();
		System.out.println(DbManager.getQuery("select * from aspnetusers WHERE Email LIKE '%san%'"));
	}

	public static List<String> getQuery(String query) throws SQLException {

		// String Query="select top 10* from ev_call";
		Statement St = con.createStatement();
		ResultSet rs = St.executeQuery(query);
		System.out.println(rs);
		int totalColumns = rs.getMetaData().getColumnCount();
		int totalRows = 0;

		while (rs.next()) {
			totalRows++;
		}

		System.out.println("totalRows = " + totalRows);
		System.out.println("total columns = " + totalColumns);

		// for (i=1;i<j;i++) {
		// values.add(rs.getString(i));
		// }

		// rs = St.executeQuery(query);
		// int i = 0;
		// Object[][] data = new Object[totalRows][1];
		// for (int rNum = 0; rNum < (0 + totalRows); rNum++) {
		// Hashtable<String, String> table = new Hashtable<String, String>();
		// for (int cNum = 0; cNum < totalColumns; cNum++) {
		// System.out.println(rs.getMetaData().getColumnName(cNum+1));
		// System.out.println(rs.getString(i+1));
		// table.put(rs.getMetaData().getColumnName(cNum+1), rs.getString(cNum + 1));
		// }
		// data[i][0] = table;
		// i++;
		// }

			Map<String, String> dataInMap = new TreeMap<String, String>();


		rs = St.executeQuery(query);
		List<String> values = new ArrayList<String>();
		int i =0;
		Object[][] data = new Object[totalRows][1];
		
			while (rs.next()) {
			
			// System.out.println(name);
			// String k = rs.getString("ID");
			// String s = rs.getString("FirstName");
			// System.out.println(k + "\t\t" + s);
//			values.add(rs.getString(i));
				for (int cNum = 0; cNum < totalColumns; cNum++) {
				dataInMap.put(rs.getMetaData().getColumnName(cNum + 1), rs.getString(cNum + 1));
			}
//			System.out.println(dataInMap);
			data[i][0] = dataInMap;
			i++;
		}
		// closing DB Connectio
		System.out.println(dataInMap);
			System.out.println(values);
		// System.out.println(dataInMap.get("FirstName"));;
		con.close();
		return values;
	}

	//
	// Statement St = con.createStatement();
	// ResultSet rs = St.executeQuery(query);
	// System.out.println(rs);
	// int totalColumns = rs.getMetaData().getColumnCount();
	//
	// int totalRows = 0;
	//
	// while (rs.next()) {
	// System.out.println(rs.getString(totalRows));
	// totalRows++;
	// }
	// System.out.println("totalRows = " + totalRows);
	// System.out.println("total columns = " + totalColumns);
	// rs = St.executeQuery(query);
	// int i = 0;
	// Object[][] data = new Object[totalRows][1];
	// for (int rNum = 0; rNum < (0 + totalRows); rNum++) {
	// Hashtable<String, String> table = new Hashtable<String, String>();
	// for (int cNum = 0; cNum < totalColumns; cNum++) {
	// System.out.println(rs.getMetaData().getColumnName(cNum+1));
	// System.out.println(rs.getString(1));
	// table.put(rs.getMetaData().getColumnName(cNum+1), rs.getString(cNum + 1));
	// }
	// data[i][0] = table;
	// i++;
	// }
	//
	// List<String> values = new ArrayList<String>();
	// i = 1;
	//
	// while (rs.next()) {
	//
	// String name = rs.getMetaData().getColumnName(14);
	// System.out.println(name);
	// System.out.println("ID: " + rs.getInt(name));
	// System.out.println("PhoneNumber: " + rs.getInt(name));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	// System.out.println("ID: " + rs.getInt("ID:"));
	//
	// String s = rs.getString("FirstName");
	//
	// values.add(rs.getString(i));
	// i++;
	//
	// }
	// // closing DB Connection
	// con.close();

	public static List<String> getMysqlQuery(String query) throws SQLException {

		Statement St = conn.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values1 = new ArrayList<String>();
		while (rs.next()) {

			values1.add(rs.getString(1));

		}
		return values1;
	}

	public static Connection getConnection() {
		return con;
	}

	public class GetAllRows {

	}

}