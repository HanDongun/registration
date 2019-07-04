package registration_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Student {
	private int id;
	private int semester;
	private String preSubject;
	private ArrayList<Schedule> schedule;

	Student() {
		schedule = new ArrayList<>();
		setPreSubject();
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public int getId() {
		return id;
	}

	public ArrayList<Schedule> getSchedule(){
		return schedule;
	}

	public String getPre() {
		return preSubject;
	}

	public void setPreSubject(){
		File file = new File("pre.txt");
		ArrayList<String> pre = new ArrayList<>();
		String prs ="";
		String line = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));

			while((line = br.readLine()) != null)
				pre.add(line);
			for(int j=0;j<pre.size();j++) {
				if(pre.get(j).indexOf("-")!=-1) {
					prs += pre.get(j).substring(0, pre.get(j).indexOf("-")) + " ";
				}
			}
			prs = prs.substring(4, prs.length());
			this.preSubject = prs;
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void register(Schedule sc) {
		schedule.add(sc);
	}

	public boolean creditCheck() {
		float cr = 0;
		for(int i = 0; i < schedule.get(0).getCourseList().size();i++)
			cr += Float.parseFloat(schedule.get(0).getCourseList().get(i).getCredit());
		if(cr>=9 && cr<=24)
			return true;
		else return false;
	}
}
