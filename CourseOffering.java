package registration_system;
import java.util.ArrayList;

public class CourseOffering {
	private int index;
	private String semester;
	private String major;
	private String code;
	private String clas;
	private String subject;
	private String credit;
	private String time;
	private String professor;
	private String pre_code1;
	private String pre_code2;
	private String weekday;
	private int time1;
	private int time2;
	private String pre_code3;

	public int getIndex() {
		return index;
	}
	public void setIndpre(int indpre) {
		this.index = indpre;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getpre_code1() {
		return pre_code1;
	}
	public void setpre_code1(String pre_code1) {
		this.pre_code1 = pre_code1;
	}
	public String getpre_code2() {
		return pre_code2;
	}
	public void setpre_code2(String pre_code2) {
		this.pre_code2 = pre_code2;
	}
	public void setpre_code3(String pre_code3) {
		this.pre_code3 = pre_code3;
	}
	CourseOffering(){}
	CourseOffering(int index, String semester, String major, String code, String clas, String subject, String credit, String time, String professor, String pre_code1, String pre_code2, String weekday, int time1, int time2, String pre_code3){
		this.index = index; 
		this.semester = semester;
		this.major = major;
		this.code = code;
		this.clas = clas;
		this.subject = subject;
		this.credit = credit;
		this.time = time;
		this.professor = professor;
		this.pre_code1 = pre_code1;
		this.pre_code2 = pre_code2;
		this.weekday = weekday;
		this.time1 = time1;
		this.time2 = time2;
		this.pre_code3 = pre_code3;
	}
	public int getTime2() {
		return time2;
	}
	public void setTime2(int time2) {
		this.time2 = time2;
	}
	public void setTime1(int time1) {
		this.time1 = time1;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public int getTime1() {
		return time1;
	}
	public String getpre_code3() {
		return pre_code3;
	}



	private ArrayList<CourseOffering> courselist = new ArrayList<CourseOffering>();

	public ArrayList<CourseOffering> getCourseOffering() {

		CourselistFile a = new CourselistFile();
		courselist = a.getCourseOffering();

		return courselist;
	}

	public ArrayList<CourseOffering> search(String a, byte b){
		ArrayList<CourseOffering> searched = new ArrayList<CourseOffering>();
		if(b==0) {
			for(CourseOffering s : courselist) {
				CourseOffering s1 = new CourseOffering();
				if(s.getSubject().indexOf(a) >=0) {
					s1.setMajor(s.getMajor());
					s1.setCode(s.getCode());
					s1.setClas(s.getClas());
					s1.setSubject(s.getSubject());
					s1.setCredit(s.getCredit());
					s1.setTime(s.getTime());
					s1.setProfessor(s.getProfessor());
					if(s.getpre_code3().contains("NULL")) {
						s1.setpre_code3(" ");
					}
					else {
						s1.setpre_code3(s.getpre_code3());
					}
					searched.add(s1);
				}
			}
		}
		else if (b==1) {
			for(CourseOffering s : courselist) {
				CourseOffering s1 = new CourseOffering();
				if(s.getCode().indexOf(a) >=0) {
					s1.setMajor(s.getMajor());
					s1.setCode(s.getCode());
					s1.setClas(s.getClas());
					s1.setSubject(s.getSubject());
					s1.setCredit(s.getCredit());
					s1.setTime(s.getTime());
					s1.setProfessor(s.getProfessor());
					if(s.getpre_code3().contains("NULL")) {
						s1.setpre_code3(" ");
					}
					else {
						s1.setpre_code3(s.getpre_code3());
					}
					searched.add(s1);
				}
			}
		}
		return searched;
	}

	public ArrayList<CourseOffering> preSave(String code[]){
		ArrayList<CourseOffering> presaved = new ArrayList<CourseOffering>();
		for(String a : code) {
			for(CourseOffering s : courselist) {
				if(a.equals(s.getCode()+ "-" +s.getClas())) {
					CourseOffering s1 = new CourseOffering();
					s1.setClas(s.getClas());
					s1.setCode(s.getCode());
					s1.setCredit(s.getCredit());
					s1.setMajor(s.getMajor());
					s1.setProfessor(s.getProfessor());
					s1.setpre_code1(s.getpre_code1());
					s1.setpre_code2(s.getpre_code2());
					s1.setSubject(s.getSubject());
					if(s.getTime().contains("NULL")) {	
						s1.setTime(" ");
						s1.setWeekday(" ");
						s1.setTime1(0);
						s1.setTime2(0);
					}
					else {
						s1.setTime(s.getTime());
						s1.setWeekday(s.getTime().substring(0, s.getTime().indexOf(" ")));
						s1.setTime1(s.getTime1());
						s1.setTime2(s.getTime2());
					}
					s1.setpre_code3(s.getpre_code3());
					presaved.add(s1);
				}
				
			}
		}
		return presaved;
	}


}
