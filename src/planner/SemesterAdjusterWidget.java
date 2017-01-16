package planner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SemesterAdjusterWidget extends JPanel implements ActionListener{
	private ClassList clist;
	private Class ctm;

	public SemesterAdjusterWidget(ClassList clist, Class class_to_move){
		this.clist = clist;
		this.ctm = class_to_move; // contains the semester index

		this.setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());
		JLabel class_label = new JLabel(class_to_move.getDepartment().toString()+ " " +class_to_move.getNumber());
		add(class_label, BorderLayout.CENTER);
		setOpaque(true);
		setBackground(getPriorityColor(ctm.getPriority()));
		

		//add a panel to contain remove and move buttons 
		JPanel button_panel = new JPanel();

		JButton remove_button = new JButton("X");
		remove_button.setActionCommand("remove");
		remove_button.addActionListener(this);
		button_panel.add(remove_button);

		JButton down_button = new JButton("\u25c0");
		down_button.setActionCommand("left");
		down_button.addActionListener(this);
		button_panel.add(down_button);
		
		JButton up_button = new JButton("\u25b6");//unicode char that points up 
		up_button.setActionCommand("right");
		up_button.addActionListener(this);
		button_panel.add(up_button);
		button_panel.setBackground(getPriorityColor(ctm.getPriority()));


		add(button_panel, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("remove")) {
			clist.removeClass(ctm);
		} else if (cmd.equals("right")) {
			if(ctm.getSemester()==8){

			}else{
				int newSemester = ctm.getSemester() + 1;
				clist.removeClass(ctm);
				clist.addClass(new AClass(ctm.getDepartment(), ctm.getNumber(), ctm.getPriority(), newSemester));
			}
		} else if (cmd.equals("left")) {
			if(ctm.getSemester()==1){

			}else{
				int newSemester = ctm.getSemester() -1;
				clist.removeClass(ctm);
				clist.addClass(new AClass(ctm.getDepartment(), ctm.getNumber(), ctm.getPriority(), newSemester));
			}
		}

	}
	public Color getPriorityColor(int priority){
		if(priority ==2){
			return Color.GREEN.darker();
		}else if(priority ==3){
			return Color.YELLOW.brighter();
		}else if(priority ==4){
			return Color.ORANGE.brighter();
		}else if(priority ==5){
			return Color.RED;
		}else{
				return Color.blue;
		}
	}
}
