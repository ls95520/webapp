package hsqldb.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//����ScoreDAO��Ĺ�����
public class ScoreDAOFactory {
	//HSQLDB���ݿ��Driver����
	public static final String DRIVER = "org.hsqldb.jdbcDriver";
	//���������ڴ����ݿ��URL
	public static final String URL = "jdbc:hsqldb:mem:score";
	//Connection���󣬱�ʾ�����ݿ������
	private static Connection connection = null;
	/**
	 * �������ڴ����ݿ������
	 * @return
	 */
	public static Connection createConnection() {
		if (connection == null) {
			try {
				//�������ݿ���������
				Class.forName(DRIVER);
				//���������ݿ������
				connection = DriverManager.getConnection(URL, "sa", "");
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
		return connection;
	}
	
	/**
	 ** �ͷŵ��ڴ����ݿ������
	 **/
	public static void closeConnection() {
		if (connection != null) {
				try {
					//�ͷŵ����ݿ������
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	* ȡ��һ��ScoreDAO��ʵ��
	* @return
	*/
	public static ScoreDAO getScoreDAO() {
		return new ScoreDAO();
	}
}