package registration_system;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RegisterForCoursesForm {
	private JFrame frame;
	private JFrame frame2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static JScrollPane scrollPane;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JFrame frame3;
	private JTextField textField_0;
	private JPasswordField passwordField;
	private RegistrationController regControl = new RegistrationController();	


	public RegisterForCoursesForm() 
	{
		login();
	}

	public JFrame getFrame3() {
		return frame3;
	}

	public void login() {
		frame3 = new JFrame();
		frame3.setBounds(200, 200, 359, 205);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(39, 35, 62, 18);
		frame3.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(39, 75, 62, 18);
		frame3.getContentPane().add(lblNewLabel_1);

		textField_0 = new JTextField();
		textField_0.setBounds(123, 26, 166, 37);
		frame3.getContentPane().add(textField_0);
		textField_0.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(123, 66, 166, 37);
		frame3.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_0.getText();
				String password = passwordField.getText().toString();
				boolean loginCheck = regControl.login(id,password);
				if(loginCheck) {
					initialize2();
					displayCO(regControl.getCourseOfferings()); //main.s는  xml 파일로부터 읽어온 subject 정보를 의미함
					frame3.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(frame3, "아이디나 비밀번호를 잘못 입력하였습니다.");
				}				
			}
		});
		btnNewButton.setBounds(143, 115, 105, 27);
		frame3.getContentPane().add(btnNewButton);
		frame3.setTitle("로그인");
	}

	private void initialize2() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 858, 826);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("수강신청");

		JRadioButton radioButton = new JRadioButton("\uACFC\uBAA9");
		buttonGroup.add(radioButton);
		radioButton.setBounds(53, 37, 71, 27);
		frame.getContentPane().add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("\uCF54\uB4DC");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(130, 37, 139, 27);
		frame.getContentPane().add(radioButton_1);

		textField = new JTextField();
		textField.setBounds(53, 70, 116, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton search = new JButton("\uAC80\uC0C9");
		search.setBounds(183, 69, 105, 27);
		frame.getContentPane().add(search);

		textField_1 = new JTextField();
		textField_1.setBounds(8, 108, 116, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(130, 108, 116, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(252, 108, 116, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(372, 108, 116, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(493, 108, 116, 24);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(612, 108, 116, 24);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(8, 144, 116, 24);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(130, 144, 116, 24);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		JButton btnNewButton_1 = new JButton("\uC218\uAC15\uC2E0\uCCAD");
		btnNewButton_1.setBounds(735, 143, 105, 27);
		frame.getContentPane().add(btnNewButton_1);


		JButton btn2 = new JButton("최종저장");
		btn2.setBounds(545, 743, 281, 24);
		frame.getContentPane().add(btn2);

		JScrollPane scroll_2 = new JScrollPane();
		scroll_2.setBounds(14, 461, 812, 284);
		frame.getContentPane().add(scroll_2);

		textField_9 = new JTextField();
		textField_9.setBounds(252, 144, 116, 24);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(372, 144, 116, 24);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(493, 144, 116, 24);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(612, 144, 116, 24);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);



		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchSub = textField.getText();
				byte nameOrCode = 0;
				ArrayList <CourseOffering> searchResult;
				if (searchSub.length() == 0) JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.");
				else {
					//과목검색
					if (radioButton.isSelected()!=true)
						nameOrCode=1;
					searchResult = regControl.search(searchSub, nameOrCode);
					frame.getContentPane().remove(scrollPane);
					String[] index= {"학과", "과목번호", "분반", "과목명", "학점", "수업시간_강의실", "교수진", "선수과목"};
					String[][] content = new String[searchResult.size()][8];

					for(int i = 0;i<searchResult.size();i++) {
						content[i][0] = searchResult.get(i).getMajor();
						content[i][1] = searchResult.get(i).getCode();
						content[i][2] = searchResult.get(i).getClas();
						content[i][3] = searchResult.get(i).getSubject();
						content[i][4] = searchResult.get(i).getCredit();
						content[i][5] = searchResult.get(i).getTime();
						content[i][6] = searchResult.get(i).getProfessor();
						if(searchResult.get(i).getpre_code3().contains("NULL")) {
							content[i][7] = " ";
						}
						else {
							content[i][7] = searchResult.get(i).getpre_code3();
						}
					}				
					JTable table = new JTable();
					table = new JTable(content, index);
					scrollPane = new JScrollPane(table);
					scrollPane.setBounds(14, 180, 812, 267);
					frame.getContentPane().add(scrollPane);
				}
			}
		});

		//수강신청 버튼
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sub[] = new String[12];
				ArrayList<String>[] error = new ArrayList[3];
				ArrayList<CourseOffering> r = new ArrayList<>();

				sub[0] = textField_1.getText();
				sub[1] = textField_2.getText();
				sub[2] = textField_3.getText();
				sub[3] = textField_4.getText();
				sub[4] = textField_5.getText();
				sub[5] = textField_6.getText();
				sub[6] = textField_7.getText();
				sub[7] = textField_8.getText();
				sub[8] = textField_9.getText();
				sub[9] = textField_10.getText();
				sub[10] = textField_11.getText();
				sub[11] = textField_12.getText();

				error = regControl.register(sub);
				for(int i = 0; i < error.length; i++) {
					for(int j = 0; j < error[i].size(); j++) {
						JOptionPane.showMessageDialog(frame,error[i].get(j));
					}
				}
				
				r = regControl.getRegisteredSchedule();
					
				String[] index= {"학과", "과목번호", "분반", "과목명", "학점", "수업시간_강의실", "교수진", "선수과목"};
				String[][] content = new String[12][9];
				for (int i =0; i<r.size(); i++) {

					content[i][0] = r.get(i).getMajor();
					content[i][1] = r.get(i).getCode();
					content[i][2] = r.get(i).getClas();
					content[i][3] = r.get(i).getSubject();
					content[i][4] = r.get(i).getCredit();
					content[i][5] = r.get(i).getTime();
					if (r.get(i).getProfessor() == null || r.get(i).getProfessor().contains("NULL")){
						content[i][6] = " ";
					}
					else content[i][6] = r.get(i).getProfessor();
					if (r.get(i).getpre_code3() == null || r.get(i).getpre_code3().contains("NULL")){
						content[i][7] = " ";
					}
					else content[i][7] = r.get(i).getpre_code3();
				}

				JTable table = new JTable();
				table = new JTable(content, index);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(14, 461, 812, 284);
				frame.getContentPane().add(scrollPane);
			}

		});

		//최종과목 신청
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(regControl.submit())
				{
					int A = JOptionPane.showConfirmDialog(frame, "최종 저장이 가능합니다. 저장하시겠습니까?");
					if(A==0) {
						regControl.writeFile();
						initialize3();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "최소 9학점, 최대 24학점까지만 신청가능합니다.");
				}
			}
		});}												


	public void initialize3() {
		frame2 = new JFrame();
		frame2.setVisible(true);
		frame2.setBounds(200, 200, 785, 500);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		frame2.setTitle("수강신청완료");


		String[] index= {"학과", "과목번호", "분반", "과목명", "학점", "수업시간_강의실", "교수진", "선수과목"};
		String[][] content = new String[12][9];
		
		ArrayList<CourseOffering> r = new ArrayList<>();
		r = regControl.getRegisteredSchedule();
		
		for (int i =0; i<r.size(); i++) {
			
			content[i][0] = r.get(i).getMajor();
			content[i][1] = r.get(i).getCode();
			content[i][2] = r.get(i).getClas();
			content[i][3] = r.get(i).getSubject();
			content[i][4] = r.get(i).getCredit();
			content[i][5] = r.get(i).getTime();
			if (r.get(i).getProfessor() == null || r.get(i).getProfessor().contains("NULL")){
				content[i][6] = " ";
			}
			else content[i][6] = r.get(i).getProfessor();
			if (r.get(i).getpre_code3() == null || r.get(i).getpre_code3().contains("NULL")){
				content[i][7] = " ";
			}
			else content[i][7] = r.get(i).getpre_code3();
		}
		JTable table = new JTable();
		table = new JTable(content, index);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(14, 31, 739, 410);
		frame2.getContentPane().add(scrollPane);
	}

	
public void displayCO(ArrayList<CourseOffering> courseOffering) {
	String[] index= {"학과", "과목번호", "분반", "과목명", "학점", "수업시간_강의실", "교수진", "선수과목"};
	String[][] content = new String[10][8];
	for (int i =0; i<10; i++) {
		content[i][0] = courseOffering.get(i).getMajor();
		content[i][1] = courseOffering.get(i).getCode();
		content[i][2] = courseOffering.get(i).getClas();
		content[i][3] = courseOffering.get(i).getSubject();
		content[i][4] = courseOffering.get(i).getCredit();
		content[i][5] = courseOffering.get(i).getTime();
		content[i][6] = courseOffering.get(i).getProfessor();
		if(courseOffering.get(i).getpre_code3().contains("NULL")) {
			content[i][7] = " ";
		}
		else {
			content[i][7] = courseOffering.get(i).getpre_code3();
		}

	}
	JTable table = new JTable();
	table = new JTable(content, index);
	scrollPane = new JScrollPane(table);
	scrollPane.setBounds(14, 180, 812, 267);
	frame.getContentPane().add(scrollPane);
}

}