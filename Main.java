package registration_system;

import java.awt.EventQueue;
import java.io.IOException;

public class Main{

	public static void main(String[] args) throws IOException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForCoursesForm window = new RegisterForCoursesForm();
					window.getFrame3().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
