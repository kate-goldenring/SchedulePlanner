package planner;

public class AClass implements Class {
	private int courseNum;
	private String department;
	private int priority;
	private int semester;
	
	public AClass(String department, int courseNum, int priority, int semester){
		this.courseNum = courseNum;
		this.department = department;
		this.priority= priority;
		try{
		setSemester(semester);
		}catch(IllegalArgumentException e){
			setSemester(1);
		}
	
	}
	public AClass(String department, int courseNum, int priority){
		this.courseNum = courseNum;
		this.department = department;
		this.priority= priority;
		setSemester(1);
	
	}

	@Override
	public int getNumber() {
		return courseNum;
	}

	public int getPriority(){
		return priority;
	}
	

	@Override
	public String getDepartment() {
		return department;
	}
	
	public int getSemester(){
		return semester;
	}
	
	public void setSemester(int semester){
		if(semester>8 || semester<1){
			throw new IllegalArgumentException("semester is not between 1-8");
		}
		this.semester = semester;
	}
	

}
