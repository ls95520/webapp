package hsqldb.javabean;

//映射HSQLDB数据库Score表的JavaBean类

public class Score {
	// 学号
	private String SNO;
	// 课程编号
	private String CNO;
	// 课程分数
	private float GRADE;
	
	//CNO属性的getter方法
	public String getCNO(){
		return CNO;
	}
	
	//CNO属性的setter方法
	public void setCNO(String cno) {
		CNO = cno;
	}
	
	//GRADE属性的getter方法
	public float getGRADE() {
		return GRADE;
	}
	
	//GRADE属性的setter方法
	public void setGRADE(float grade) {
		GRADE = grade;
	}
	
	//SNO属性的getter方法
	public String getSNO() {
		return SNO;
	}
	
	//SNO属性的setter方法
	public void setSNO(String sno) {
		SNO = sno;
	}
}
