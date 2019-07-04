package registration_system;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;;

public class Schedule{
	
	private ArrayList<CourseOffering> courselist = new ArrayList<CourseOffering>();
	
	public ArrayList<CourseOffering> getCourseList(){
		return courselist;
	}
	
	public void preSave(ArrayList<CourseOffering> crList){
		this.courselist = crList;
	}
	
	public ArrayList<String> timeCheck() {
		int A[]=new int[12];
		ArrayList<String> error = new ArrayList<String>();
		for(int i=0;i<courselist.size()-1;i++) {
			CourseOffering s1 = courselist.get(i);
			//System.out.println(courselist.get(i).getCode());
			for(int j = i+1;j<courselist.size();j++) {
				CourseOffering s2 = courselist.get(j);
				if(s1.getWeekday() == null || s2.getWeekday() == null) continue;
				if((s1.getWeekday().contains(s2.getWeekday().substring(0))) || (s1.getWeekday().contains(s2.getWeekday().substring(s2.getWeekday().length()-1))) || (s1.getWeekday() == "월,화,수,목,금" && s2.getWeekday() != "토") || (s2.getWeekday() != "토" && s1.getWeekday() == "월,화,수,목,금")) {
					if((s2.getTime1() >= s1.getTime1() && s2.getTime1() <= s1.getTime2()) || (s2.getTime2() >= s1.getTime1() && s2.getTime2() <= s1.getTime1()) ) {
						A[j]=1;
						error.add(s1.getSubject() + "와 " + s2.getSubject() + "의 시간이 중복됩니다.");
						//JOptionPane.showMessageDialog(frame, s1.subject + "와 " + s2.subject + "의 시간이 중복됩니다.");
					}
				}
			}
		}
		for(int i=0;i<courselist.size();i++) {
 			if(A[i] == 1) {
 				courselist.remove(i);
 			}
 		}
		return error;
	}
	
	
	public ArrayList<String> sameCheck() {
		int A[] = new int[12];
		ArrayList<String> error = new ArrayList<String>();
 		for(int i = 0; i<courselist.size()-1;i++) {
 			CourseOffering s1 = courselist.get(i);
			for(int j = i+1; j<courselist.size();j++) {
				CourseOffering s2 = courselist.get(j);
				if(s1.getCode() == null || s2.getCode() ==null) continue;
				if(s1.getCode().equals(s2.getCode())) {
					A[j] = 1;
					error.add(s1.getSubject() + "와(과)" + s2.getSubject() + "를 중복 신청하였습니다.");
					//JOptionPane.showMessageDialog(frame, s1.getSubject() + "와(과)" + s2.getSubject() + "를 중복 신청하였습니다. ");
				}
			}
		}
 		for(int i =0;i<courselist.size();i++) {
 			if(A[i] == 1) {
 				courselist.remove(i);
 			}
 		}
		return error;
 		
 		
	}
	public ArrayList<String> preCheck(String prs) {
		int a[] = new int[12];
		int b[] = new int[12];
		int delete[] = new int[12];
		ArrayList<String> error = new ArrayList<String>();
		for(CourseOffering c : courselist) {
			if(c.getpre_code1() == null || c.getpre_code1().contains("NULL")) continue; 	
			String s[] = c.getpre_code1().split(", ");
			for (int j =0;j<s.length;j++) {
				if (prs.contains(s[j])) {
					a[courselist.indexOf(c)]++;
				}
			}
		}
		for(CourseOffering c : courselist) {
			if(c.getpre_code2() == null || c.getpre_code2().contains("NULL")) continue;
			String s1[] = c.getpre_code2().split(",");
			for(int j =0;j<s1.length;j++) {
				if (prs.contains(s1[j])) {
					b[courselist.indexOf(c)]++;
				}
			}
		}
		
		for(CourseOffering c : courselist) {
			if(c.getpre_code1() != null) {
				if(c.getpre_code1().contains("NULL") && c.getpre_code2().contains("NULL") == false) {
					if(b[courselist.indexOf(c)] == 0) {
						error.add(c.getSubject() + "의 선수과목을 수강하지 않았습니다.");
						//Component frame = null;
						//JOptionPane.showMessageDialog(frame, c.getSubject() + "의 선수과목을 수강하지 않았습니다.");
						delete[courselist.indexOf(c)]++;
					}
				}
				else if(c.getpre_code1().contains("NULL") == false && c.getpre_code2().contains("NULL")) {	
					if(a[courselist.indexOf(c)] != c.getpre_code1().split(",").length) {
						error.add(c.getSubject() + "의 선수과목을 수강하지 않았습니다.");
						//Component frame = null;
						//JOptionPane.showMessageDialog(frame, c.getSubject() + "의 선수과목을 수강하지 않았습니다.");
						delete[courselist.indexOf(c)]++;
					}
				}
				else if(c.getpre_code1().contains("NULL") == false && c.getpre_code2().contains("NULL")==false) {
					if(a[courselist.indexOf(c)] != c.getpre_code1().split(",").length || b[courselist.indexOf(c)] ==0) {
						error.add(c.getSubject() + "의 선수과목을 수강하지 않았습니다.");
						//Component frame = null;
						//JOptionPane.showMessageDialog(frame, c.getSubject() + "의 선수과목을 수강하지 않았습니다.");
						delete[courselist.indexOf(c)]++;
					}
				}
			}
			
			}
		for(int i=0;i<12;i++) {
			if(delete[i]!=0) {
				courselist.remove(i);
			}
		}
		
		return error;
		}
	
	
}

