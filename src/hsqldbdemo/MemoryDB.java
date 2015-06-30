package hsqldbdemo;

import java.sql.*;

public class MemoryDB {
	public static void main(String arg[]){
		try {
			//加载HSQLDB数据库JDBC驱动
			Class.forName("org.hsqldb.jdbcDriver");
			//在内存中建立临时数据库score，用户名为sa，密码为空
			Connection connect = DriverManager.getConnection("jdbc:hsqldb:mem:score",
			"sa", "");
			System.out.println("在此行上设置一个断点");
			} catch (SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
	}
}
