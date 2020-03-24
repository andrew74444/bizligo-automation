package com.cpcommunity.utilities;

import java.sql.Connection;
import java.sql.SQLException;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


//		DbManager.setMysqlDbConnection();
//		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id = 2"));

		
		DbManager.setDbConnection();
		System.out.println(DbManager.getQuery("SELECT C.name from Communities c inner join CommunityCategoriesmapping ccm on c.id=ccm.CommunityID INNER JOIN CommunityCategories  CC ON CC.ID=CCM.CommunityCategoryID where (c.name like '%Film%' OR CC.Name like '%Film%') AND C.StatusID=2 AND C.IsActive=1 ORDER BY c.Name ASC"));

		
		
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		             
//		// Creating a connection to the database
//		Connection conn = DriverManager.getConnection("jdbc:sqlserver://artOfTesting.com/testDB", "userName",
//				"password");
//
//		// Executing SQL query and fetching the result
//		Statement st = conn.createStatement();
//		String sqlStr = "select * from testTable";
//		ResultSet rs = st.executeQuery(sqlStr);
//		while (rs.next()) {
//			System.out.println(rs.getString("name"));
//		}
		
	}
		

			
		
		
	}	
	


