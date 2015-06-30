package hsqldb.dbo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import hsqldb.javabean.Score;

//ScoreDAO�࣬������װ�����ݿ�ĳ�������

public class ScoreDAO {
	// ���ݿ��JDBC����
	private Connection connection;
	// Statement����
	private Statement statement;
	// ��Ҫִ�е�SQL���
	private String sql;
	
	/**
	* ���캯����������score���ݿ�����ӣ�ͬʱ��score���ݿ��н���Score��
	*/
	public ScoreDAO() {
		// ������score���ݿ������
		connection = ScoreDAOFactory.createConnection();
		try {
			//����statement����
			statement = connection.createStatement();
			//����Score���SQL���
			sql = "CREATE TABLE Score (SNO CHAR(7) NOT NULL,CNO CHAR(6) NOT NULL,GRADE NUMERIC(4,1),PRIMARY KEY(SNO,CNO))";
			//ִ��SQL���
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* ��Score��һ��������뵽���ݿ���
	*
	* @param score
	*/
	public void insertScore(Score score) {
		//������score��ĸ�������ƴ�ӳɲ����¼��SQL���
		sql = "INSERT INTO SCORE VALUES(" + "\'" + score.getSNO() + "\',"+ "\'" + score.getCNO() + "\'," + score.getGRADE() + ")";
		try {
			//����INSERT INTO ���ΪScore�����һ����¼����¼�������ֶ�ֵ��Ӧ��score�����������
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* �����ݿ��в�ѯ����ĳ��Score������Ϣ�ļ�¼
	*
	* @param score
	* @return
	*/
	public ResultSet selectScore(Score score) {
		//��ѯ��Ľ����
		ResultSet result = null;
		//������Score��ĸ�������ƴ�ӳɲ�ѯ��¼��SQL���
		sql = "select * from score where SNO=" + score.getSNO() + "and CNO="+ score.getCNO();
		try {
			//ִ�в�ѯ��������Score���SNO��CNO����ֵ��ͬ�ļ�¼
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	* ��ѯ���ݿ��е����м�¼
	*
	* @return
	*/
	public ResultSet selectAll() {
		//��ѯ��Ľ����
		ResultSet result = null;
		//��ѯ���м�¼��SQL���
		sql = "select * from score";
		try {
			//ִ�в�ѯ���������еļ�¼
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	* ɾ��ĳ�����ݿ��¼
	*
	* @param score
	*/
	public void deleteScore(Score score) {
		//������Score��ĸ�������ƴ�ӳ�ɾ����¼��SQL���
		sql = "delete from score where SNO=" + score.getSNO() + "and CNO="+ score.getCNO();
		try {
			//ִ��ɾ��������SQL���
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* �������ݿ��е�ĳ����¼
	*
	* @param oldScore
	* @param newScore
	*/
	public void updateScore(Score oldScore, Score newScore) {
		//�����ݿ������������ļ�¼����ΪnewScore���SNO��CNO��GRADE����ֵ
		sql = "update score set SNO=" + newScore.getSNO() + ",CNO="
				+ newScore.getCNO() + ",GRADE=" + newScore.getGRADE()
				+ " where SNO=" + oldScore.getSNO() + "and CNO="
				+ oldScore.getCNO();
		try {
			//ִ�����ݿ�������
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
