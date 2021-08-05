package cn.hp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static String Driver = "com.mysql.jdbc.Driver";
	private static String Url = "jdbc:mysql://localhost:3306/provinces?characterEncoding=utf8";
	private static String user = "root";
	private static String pwd = "123456";
	public static Connection conn;

	public static Connection getConn() {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url, user, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}


	public static void getClose() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		System.out.println(getConn());
		if (getConn()!=null) {
			System.out.println("���ӳɹ�");
		}
	}
}
