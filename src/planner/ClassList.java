package planner;

import java.util.ArrayList;
import java.util.List;


public class ClassList extends java.util.Observable{
	private List<Class> classes;

	public ClassList(){
		classes = new ArrayList<Class>();
	}
	
	public AClass[] getClasses() {
		return classes.toArray(new AClass[classes.size()]);
	}
//	public List<Class> getClassesList(){
//		return classes;
//	}
	public int getSize() {
		return classes.size();
	}
	
	public void addClass(Class c) {
		classes.add(c);
		setChanged();
		notifyObservers();
	}

	public void removeClass(Class c) {
		classes.remove(c);
		setChanged();
		notifyObservers();
	}

	public Class getClass(int index) {
		return classes.get(index);
	}
}
