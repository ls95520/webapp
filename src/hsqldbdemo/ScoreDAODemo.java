package hsqldbdemo;

import java.util.logging.Logger;
import java.sql.*;

import hsqldb.dbo.*;
import hsqldb.javabean.*;

public class ScoreDAODemo {
	public static void main(String[] arg) throws SQLException{
		//firstScore ʵ����
		Score firstScore = new Score();
		//CNO�ֶ�ֵΪ34
		firstScore.setCNO("34");
		//SNO�ֶ�ֵΪ1
		firstScore.setSNO("1");
		//GRADE�ֶ�ֵΪ2.5
		firstScore.setGRADE((float) 2.5);
		
		// secondScoreʵ��
		Score secondScore = new Score();
		//CNO�ֶ�ֵΪ45
		secondScore.setCNO("45");
		//GRADE�ֶ�ֵΪ67.9
		secondScore.setGRADE((float) 67.9);
		//SNO�ֶ�ֵΪ2
		secondScore.setSNO("2");
		
		// thirdScoreʵ��
		Score thirdScore = new Score();
		//CNO�ֶ�ֵΪ78
		thirdScore.setCNO("78");
		//SNO�ֶ�ֵΪ3
		thirdScore.setSNO("3");
		//GRADE�ֶ�ֵΪ89
		thirdScore.setGRADE((float) 89.0);
		
		ScoreDAO scoreDAO = new ScoreDAO();
		// ͨ��ScoreDAO��ʵ��ִ�в������
		scoreDAO.insertScore(firstScore);
		// ��ѯ���ݿ��е����м�¼
		ResultSet result = scoreDAO.selectAll();
		// ������м�¼��Ϣ
		//info(result);
		
		// ͨ��ScoreDAO��ʵ��ִ�в������
		scoreDAO.insertScore(secondScore);
		// ��ѯ���ݿ��е����м�¼
		result = scoreDAO.selectAll();
		// ������м�¼��Ϣ
		//info(result);
		
		//ͨ��ScoreDAO��ʵ��ִ�и��²���
		scoreDAO.updateScore(secondScore, thirdScore);
		//��ѯ���ݿ��е����м�¼
		result = scoreDAO.selectAll();
		//�����¼��Ϣ
		//info(result);
		
		//ͨ��ScoreDAO��ʵ��ִ��ɾ������
		scoreDAO.deleteScore(firstScore);
		//��ѯ���ݿ��е����м�¼
		result = scoreDAO.selectAll();
		//�����¼��Ϣ
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
