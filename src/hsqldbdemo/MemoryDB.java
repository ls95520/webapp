package hsqldbdemo;

import java.sql.*;

public class MemoryDB {
	public static void main(String arg[]){
		try {
			//����HSQLDB���ݿ�JDBC����
			Class.forName("org.hsqldb.jdbcDriver");
			//���ڴ��н�����ʱ���ݿ�score���û���Ϊsa������Ϊ��
			Connection connect = DriverManager.getConnection("jdbc:hsqldb:mem:score",
			"sa", "");
			System.out.println("�ڴ���������һ���ϵ�");
			} catch (SQLException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
	}
}
