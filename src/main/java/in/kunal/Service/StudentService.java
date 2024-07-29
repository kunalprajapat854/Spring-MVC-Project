package in.kunal.Service;

import java.util.List;

import in.kunal.Entity.Student;

public interface StudentService {
	
	public List<Student> getallstudents();
	
	public void delete (Integer id);
	
	public boolean save(Student student);
	
	public Student findbyid (Integer id);
	
	
	

}
