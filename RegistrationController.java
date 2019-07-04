package registration_system;

import java.util.ArrayList;

public class RegistrationController {
	private CourseOffering courseOffer = new CourseOffering();
	private Schedule schedule = new Schedule();
	private Student student = new Student();
	private Save saveFile = new Save();
	
	public boolean login(String id, String password) {
		try{
			if(id.length()==8 && Integer.parseInt(id) > 0 && password.equals("20130712")) {
				student.setId(id);
				return true;
			}
			else return false;
		}
		catch(Exception e) {
			return false;
		}
	}

	public ArrayList<CourseOffering> getCourseOfferings() {
		return courseOffer.getCourseOffering();
}

	public ArrayList<CourseOffering> search(String searchSub, byte nameOrCode){
		return courseOffer.search(searchSub, nameOrCode);
	}

	public ArrayList<String> [] register(String[] sub) {
		ArrayList<String>[]checkError = new ArrayList[3];
		checkError[0] = new ArrayList<>();
		checkError[1] = new ArrayList<>();
		checkError[2] = new ArrayList<>();

		String preCourseList;
		schedule.preSave(courseOffer.preSave(sub));	
		checkError[0] = schedule.timeCheck();
		preCourseList = student.getPre();
		checkError[1] = schedule.preCheck(preCourseList);
		checkError[2] = schedule.sameCheck();
		student.register(schedule);
		return checkError;
	}

	public boolean submit() {
		if(student.creditCheck())
			return true;
		else return false;
	}

	public void writeFile() {
		saveFile.writeFile(student.getSchedule().get(0).getCourseList(),student.getId());
	}

	public ArrayList<CourseOffering> getRegisteredSchedule(){
		return schedule.getCourseList();
	}
}
