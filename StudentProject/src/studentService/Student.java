package studentService;

public class Student {
	private int id;
	private String name;
	private int MathMark;
	public Student(int id, String name, int mathMark) {
		super();
		this.id = id;
		this.name = name;
		MathMark = mathMark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMathMark() {
		return MathMark;
	}
	public void setMathMark(int mathMark) {
		MathMark = mathMark;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", MathMark=" + MathMark + "]";
	}
	
	
	
}
