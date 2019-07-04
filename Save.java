package registration_system;

import java.io.FileWriter;

import java.util.ArrayList;

public class Save {
	public void writeFile(ArrayList<CourseOffering> courselist , int StudentId) {
		try {
				
			FileWriter fw = new FileWriter("save.txt");
			String a = "2019학년도 1학기 \r\n" + "학번 : " + StudentId + "\r\n";
			fw.write(a);
			String b = "학과" + "\t\t" + "과목코드-분반" + "\t" + "과목" + "\t\t" + "학점" + "\t" + "강의시간_강의실" + "\t\t" + "교수진" + "\t\t" + "선수과목" + "\r\n"; 
			fw.write(b);
			for(CourseOffering s : courselist) {
				if(s.getMajor() == null) continue;
				String data = s.getMajor() + "\t" + s.getCode() + "-" + s.getClas() + "\t" + s.getSubject() + "\t" + s.getCredit() + "\t" + s.getTime() + "\t" + s.getProfessor();
				if(s.getpre_code3().contains("NULL")) data += "\r\n";
				else data += "\t" + s.getpre_code3() + "\r\n";
				fw.write(data);
			}
			fw.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}