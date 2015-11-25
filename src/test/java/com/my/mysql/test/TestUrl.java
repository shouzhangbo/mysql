package com.my.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestUrl {

	public static Connection get(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			String url = "jdbc:mysql://localhost:3306/bob?user=root&password=houzhangbo";
			conn = DriverManager.getConnection(url); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(get());
	}
}
