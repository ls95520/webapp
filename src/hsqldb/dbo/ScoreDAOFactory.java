package hsqldb.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//创建ScoreDAO类的工厂类
public class ScoreDAOFactory {
	//HSQLDB数据库的Driver名称
	public static final String DRIVER = "org.hsqldb.jdbcDriver";
	//将建立的内存数据库的URL
	public static final String URL = "jdbc:hsqldb:mem:score";
	//Connection对象，表示到数据库的连接
	private static Connection connection = null;
	/**
	 * 建立到内存数据库的连接
	 * @return
	 */
	public static Connection createConnection() {
		if (connection == null) {
			try {
				//加载数据库驱动程序
				Class.forName(DRIVER);
				//建立到数据库的连接
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
	 ** 释放到内存数据库的连接
	 **/
	public static void closeConnection() {
		if (connection != null) {
				try {
					//释放到数据库的连接
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	* 取得一个ScoreDAO的实例
	* @return
	*/
	public static ScoreDAO getScoreDAO() {
		return new ScoreDAO();
	}
}