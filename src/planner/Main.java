package planner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Schedule Organizer");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClassList clist = new ClassList();
//		clist.addClass(new AClass("COMP", 401, 5,1));
//		clist.addClass(new AClass("COMP", 410, 4,6));
//		clist.addClass(new AClass("ECON", 420, 4,3));
//		clist.addClass(new AClass("ECON", 570, 3,4));
//		clist.addClass(new AClass("ARTH", 299, 3,6));
//		clist.addClass(new AClass("CMPL", 300, 2,8));
//		clist.addClass(new AClass("COMP", 402, 2,3));
//		clist.addClass(new AClass("COMP", 411, 1,2));
//		clist.addClass(new AClass("ECON", 421, 1,5));
//		clist.addClass(new AClass("ECON", 571, 5,6));
//		clist.addClass(new AClass("ARTH", 323, 3));
//		clist.addClass(new AClass("CMPL", 301, 1));
//		
//		 String fileName = "text/courses.txt";
//
//	        // This will reference one line at a time
//	        String line = null;
//
//	        try {
//	           
//	            FileReader fileReader = 
//	                new FileReader(fileName);
//
//	            // Always wrap FileReader in BufferedReader.
//	            BufferedReader bufferedReader = 
//	                new BufferedReader(fileReader);
//
//	            while((line = bufferedReader.readLine()) != null) {
//	            	String[] words = line.split(" ");
//	            	clist.addClass(new AClass(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]),Integer.parseInt(words[3])));
//	            }   
//
//	            // Always close files.
//	            bufferedReader.close();         
//	        }
//	        catch(FileNotFoundException ex) {
//	            System.out.println(
//	                "Unable to open file '" + 
//	                fileName + "'");                
//	        }
//	        catch(IOException ex) {
//	            System.out.println(
//	                "Error reading file '" 
//	                + fileName + "'");                  
//	            // Or we could just do this: 
//	            // ex.printStackTrace();
//	        }

		SchedulerView sched_view = new SchedulerView(clist);
		main_frame.setContentPane(sched_view);
		main_frame.pack();
		main_frame.setVisible(true);
	}

}
