package planner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SchedulerView extends JPanel implements Observer{

	private ClassList clist;
	private JPanel semesters_panel;//equivalent of list panel

	public SchedulerView(ClassList clist){
		this.clist = clist;
		clist.addObserver(this);
		
		setLayout(new BorderLayout());
		
		semesters_panel = new JPanel();
		semesters_panel.setLayout(new GridLayout(4,2));
		buildListPanel();
		add(semesters_panel, BorderLayout.CENTER);
		
		JPanel editingPanel = new JPanel();
		editingPanel.setLayout(new BorderLayout());
		
		AddClassWidget add_class_widget = new AddClassWidget(clist);
		editingPanel.add(add_class_widget, BorderLayout.WEST);
		//addFileWidget
		
		AddFileWidget add_file_widget = new AddFileWidget(clist);
		editingPanel.add(add_file_widget, BorderLayout.EAST);
		add(editingPanel, BorderLayout.SOUTH);
	}
	private void buildListPanel() {
		for (int i=1; i<=8; i++) {
			JPanel semester = new JPanel();
			semester.setLayout(new GridLayout(0,1));
			semester.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel semester_label = new JLabel("Semester" + " " +(i));
			
			semester_label.setForeground(Color.BLUE);
			semester.add(semester_label, BorderLayout.NORTH);
			for(Class c: clist.getClasses()){
			if(c.getSemester() == i){
				SemesterAdjusterWidget sem_adjuster = new SemesterAdjusterWidget(clist, c);
				semester.add(sem_adjuster);
				
			}
			}
			semesters_panel.add(semester);
		}

		
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		//remove everything so can reload it all
		semesters_panel.removeAll();
		buildListPanel();
		semesters_panel.revalidate();

	}

}
