package hsqldbdemo;

import java.util.logging.Logger;
import java.sql.*;

import hsqldb.dbo.*;
import hsqldb.javabean.*;

public class ScoreDAODemo {
	public static void main(String[] arg) throws SQLException{
		//firstScore 实例，
		Score firstScore = new Score();
		//CNO字段值为34
		firstScore.setCNO("34");
		//SNO字段值为1
		firstScore.setSNO("1");
		//GRADE字段值为2.5
		firstScore.setGRADE((float) 2.5);
		
		// secondScore实例
		Score secondScore = new Score();
		//CNO字段值为45
		secondScore.setCNO("45");
		//GRADE字段值为67.9
		secondScore.setGRADE((float) 67.9);
		//SNO字段值为2
		secondScore.setSNO("2");
		
		// thirdScore实例
		Score thirdScore = new Score();
		//CNO字段值为78
		thirdScore.setCNO("78");
		//SNO字段值为3
		thirdScore.setSNO("3");
		//GRADE字段值为89
		thirdScore.setGRADE((float) 89.0);
		
		ScoreDAO scoreDAO = new ScoreDAO();
		// 通过ScoreDAO的实例执行插入操作
		scoreDAO.insertScore(firstScore);
		// 查询数据库中的所有记录
		ResultSet result = scoreDAO.selectAll();
		// 输出所有记录信息
		//info(result);
		
		// 通过ScoreDAO的实例执行插入操作
		scoreDAO.insertScore(secondScore);
		// 查询数据库中的所有记录
		result = scoreDAO.selectAll();
		// 输出所有记录信息
		//info(result);
		
		//通过ScoreDAO的实例执行更新操作
		scoreDAO.updateScore(secondScore, thirdScore);
		//查询数据库中的所有记录
		result = scoreDAO.selectAll();
		//输出记录信息
		//info(result);
		
		//通过ScoreDAO的实例执行删除操作
		scoreDAO.deleteScore(firstScore);
		//查询数据库中的所有记录
		result = scoreDAO.selectAll();
		//输出记录信息
		info(result);
	}
	
	private static void info(ResultSet result) throws SQLException{
	    ResultSetMetaData rsmd = result.getMetaData();
	    //System.out.println("querying SELECT * FROM XXX");
	    int columnsNumber = rsmd.getColumnCount();
	    while (result.next()) {
	        for (int i = 1; i <= columnsNumber; i++) {
	            if (i > 1) System.out.print(",  ");
	            String columnValue = result.getString(i);
	            System.out.print(rsmd.getColumnName(i) + " = " + columnValue);
	        }
	        System.out.println("");
	    }
	}

}
