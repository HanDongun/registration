package registration_system;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CourselistFile {
	
	
	public ArrayList<CourseOffering> getCourseOffering() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("sub4.xml");
			NodeList row = doc.getElementsByTagName("ROW");
			ArrayList <CourseOffering> courselist = new ArrayList<CourseOffering>();
			
			for(int i = 0; i < row.getLength();i++) {
				Node p = row.item(i);
				NodeList childNodeList = p.getChildNodes();
				CourseOffering s = new CourseOffering();
				for(int j = 0; j<childNodeList.getLength();j++) {
					Node childNode = childNodeList.item(j);
					s.setIndpre(i);
					if(childNode.getNodeName().equals("학기")) {
						String a1 = childNode.getFirstChild().getNodeValue();
						s.setSemester(a1);
					}
					if(childNode.getNodeName().equals("학과")) {
						String a2 = childNode.getFirstChild().getNodeValue();
						s.setMajor(a2);
					}
					if(childNode.getNodeName().equals("과목번호")) {
						String a3 = childNode.getFirstChild().getNodeValue();				
						s.setCode(a3);
					}
					if(childNode.getNodeName().equals("분반")) {
						String a4 = childNode.getFirstChild().getNodeValue();				
						s.setClas(a4);
					}
					if(childNode.getNodeName().equals("과목명")) {
						String a5 = childNode.getFirstChild().getNodeValue();				
						s.setSubject(a5);
					}
					if(childNode.getNodeName().equals("학점")) {
						String a6 = childNode.getFirstChild().getNodeValue();				
						s.setCredit(a6);
					}
					if(childNode.getNodeName().equals("수업시간_강의실")) {
						String a7 = childNode.getFirstChild().getNodeValue();			
						s.setTime(a7);
						if (a7 == null) continue;
						int indpre1 = s.getTime().indexOf(' ');
						if (indpre1 == -1) continue;	
						
						String b = s.getTime().substring(0, indpre1);
						
						int indpre2 = s.getTime().substring(indpre1+1, s.getTime().length()).indexOf(' ');
						if (indpre2 == -1) continue;
						
						String b2 = s.getTime().substring(indpre1+1,indpre1 + indpre2+1);
					
						String b3 = b2.substring(0, b2.indexOf(':')) + b2.substring(b2.indexOf(':')+1,b2.indexOf('~'));
						
						int c = Integer.parseInt(b3);
					
						String b4 = b2.substring(b2.indexOf('~')+1, b2.lastIndexOf(':')) + b2.substring(b2.lastIndexOf(':')+1, b2.length());
						int c2 = Integer.parseInt(b4);
						s.setWeekday(b);
						s.setTime1(c);
						s.setTime2(c2);
					}
					if(childNode.getNodeName().equals("교수진")) {
						String a8 = childNode.getFirstChild().getNodeValue();				
						s.setProfessor(a8);
					}
					if(childNode.getNodeName().equals("선수과목1")) {
						String a9 = childNode.getFirstChild().getNodeValue();				
						s.setpre_code1(a9);
					}
					if(childNode.getNodeName().equals("선수과목2")) {
						String a10 = childNode.getFirstChild().getNodeValue();				
						s.setpre_code2(a10);
					}
					if(childNode.getNodeName().equals("선수과목3")) {
						String a11 = childNode.getFirstChild().getNodeValue();				
						s.setpre_code3(a11);
					}
				}
				courselist.add(s);
			}
			return courselist;
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
			
	}
	
	
	
}
