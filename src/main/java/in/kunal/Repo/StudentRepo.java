package in.kunal.Repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	public List<Student> findByActivSw(String activSw);

}
