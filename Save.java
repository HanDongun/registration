package registration_system;

import java.io.FileWriter;

import java.util.ArrayList;

public class Save {
	public void writeFile(ArrayList<CourseOffering> courselist , int StudentId) {
		try {
				
			FileWriter fw = new FileWriter("save.txt");
			String a = "2019�г⵵ 1�б� \r\n" + "�й� : " + StudentId + "\r\n";
			fw.write(a);
			String b = "�а�" + "\t\t" + "�����ڵ�-�й�" + "\t" + "����" + "\t\t" + "����" + "\t" + "���ǽð�_���ǽ�" + "\t\t" + "������" + "\t\t" + "��������" + "\r\n"; 
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