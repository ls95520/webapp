package hsqldb.dbo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import hsqldb.javabean.Score;

//ScoreDAO类，用来封装对数据库的常见操作

public class ScoreDAO {
	// 数据库的JDBC连接
	private Connection connection;
	// Statement对象
	private Statement statement;
	// 需要执行的SQL语句
	private String sql;
	
	/**
	* 构造函数，建立到score数据库的连接，同时在score数据库中建立Score表
	*/
	public ScoreDAO() {
		// 建立到score数据库的连接
		connection = ScoreDAOFactory.createConnection();
		try {
			//创建statement对象
			statement = connection.createStatement();
			//创建Score表的SQL语句
			sql = "CREATE TABLE Score (SNO CHAR(7) NOT NULL,CNO CHAR(6) NOT NULL,GRADE NUMERIC(4,1),PRIMARY KEY(SNO,CNO))";
			//执行SQL语句
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* 将Score的一个对象插入到数据库中
	*
	* @param score
	*/
	public void insertScore(Score score) {
		//将参数score类的各个属性拼接成插入记录的SQL语句
		sql = "INSERT INTO SCORE VALUES(" + "\'" + score.getSNO() + "\',"+ "\'" + score.getCNO() + "\'," + score.getGRADE() + ")";
		try {
			//程序INSERT INTO 语句为Score类插入一条记录，记录的三个字段值对应着score类的三个属性
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* 在数据库中查询包含某个Score对象信息的记录
	*
	* @param score
	* @return
	*/
	public ResultSet selectScore(Score score) {
		//查询后的结果集
		ResultSet result = null;
		//将参数Score类的各个属性拼接成查询记录的SQL语句
		sql = "select * from score where SNO=" + score.getSNO() + "and CNO="+ score.getCNO();
		try {
			//执行查询，返回与Score类的SNO、CNO属性值相同的记录
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	* 查询数据库中的所有记录
	*
	* @return
	*/
	public ResultSet selectAll() {
		//查询后的结果集
		ResultSet result = null;
		//查询所有记录的SQL语句
		sql = "select * from score";
		try {
			//执行查询，返回所有的记录
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	* 删除某个数据库记录
	*
	* @param score
	*/
	public void deleteScore(Score score) {
		//将参数Score类的各个属性拼接成删除记录的SQL语句
		sql = "delete from score where SNO=" + score.getSNO() + "and CNO="+ score.getCNO();
		try {
			//执行删除操作的SQL语句
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* 更新数据库中的某条记录
	*
	* @param oldScore
	* @param newScore
	*/
	public void updateScore(Score oldScore, Score newScore) {
		//将数据库中满足条件的记录更新为newScore类的SNO、CNO和GRADE属性值
		sql = "update score set SNO=" + newScore.getSNO() + ",CNO="
				+ newScore.getCNO() + ",GRADE=" + newScore.getGRADE()
				+ " where SNO=" + oldScore.getSNO() + "and CNO="
				+ oldScore.getCNO();
		try {
			//执行数据库更新语句
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
