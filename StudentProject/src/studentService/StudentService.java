package studentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentManuplation {
		
	List<Student> students=new ArrayList<Student>();
	
	
	@Override
	public void insertStudent() {
		for(int i=0;i<5;i++)
			students.add(new Student(i, "Student "+i, i+75));
	}

	@Override
	public List<Student> getStudents() {
		return students;
	}

	@Override
	public void printStudents() {
		System.out.println("Oday Printing List of User");
		if(students.size()==0)
			System.err.println("Call insertStudent");
		students.forEach(System.out::println);

	}

}
