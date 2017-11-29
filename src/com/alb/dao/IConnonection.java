package com.alb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface IConnonection {


	default Connection connection() throws Exception {

		Connection con = null;
		String user = "root";
		String pass = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/constructora";
			con = DriverManager.getConnection(url, user, pass);
			
			if(con != null)
				System.out.println("Good connection");
			else
				System.err.println("Bad Connection");

		} catch (Exception e) {
			System.err.println("bad Connection");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return con;
	}

}
