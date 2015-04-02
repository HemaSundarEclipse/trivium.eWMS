package com.samplePractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB {
	@Test
	public void name() throws ClassNotFoundException, SQLException {

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/v5.0.0", "postgres", "postgres");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select alias from account_owner");
		
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
	}
}