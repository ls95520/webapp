package hsqldb.javabean;

//ӳ��HSQLDB���ݿ�Score���JavaBean��

public class Score {
	// ѧ��
	private String SNO;
	// �γ̱��
	private String CNO;
	// �γ̷���
	private float GRADE;
	
	//CNO���Ե�getter����
	public String getCNO(){
		return CNO;
	}
	
	//CNO���Ե�setter����
	public void setCNO(String cno) {
		CNO = cno;
	}
	
	//GRADE���Ե�getter����
	public float getGRADE() {
		return GRADE;
	}
	
	//GRADE���Ե�setter����
	public void setGRADE(float grade) {
		GRADE = grade;
	}
	
	//SNO���Ե�getter����
	public String getSNO() {
		return SNO;
	}
	
	//SNO���Ե�setter����
	public void setSNO(String sno) {
		SNO = sno;
	}
}
