package planner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class AddClassWidget extends JPanel implements ActionListener{
	private ClassList clist;
	private JTextField dept_field;
	private JTextField num_field;
	private JSlider priority_slider;
	private JButton add_class_button;


	public AddClassWidget(ClassList clist){
		this.clist = clist;
		dept_field = new JTextField(5);
		add(new JLabel("Class Department: "));		
		add(dept_field);

		num_field = new JTextField(5);
		add(new JLabel("Class Number: "));		
		add(num_field);

		priority_slider = new JSlider(0, 5, 0);
		priority_slider.setPaintTicks(true);
		priority_slider.setSnapToTicks(true);
		priority_slider.setPaintLabels(true);
		priority_slider.setMajorTickSpacing(1);
		add(new JLabel("Priority: "));
		add(priority_slider);

		add_class_button = new JButton("+");
		add_class_button.setActionCommand("add");
		add(add_class_button);
		
		add_class_button.addActionListener(this);



	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String dept_name = dept_field.getText();
		String course_num = num_field.getText();
		int priority = priority_slider.getValue();
		Class class_to_add = new AClass(dept_name, Integer.parseInt(course_num), priority);
		clist.addClass(class_to_add);
		System.out.println(clist.getSize());
	
		
		dept_field.setText("");
		num_field.setText("");
		priority_slider.setValue(0);
		

	}

}
