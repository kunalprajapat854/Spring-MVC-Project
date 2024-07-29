package in.kunal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.kunal.Entity.Student;
import in.kunal.Repo.StudentRepo;

@Service
public class StudentIMPL implements StudentService {

	@Autowired
	private StudentRepo repo;

	public List<Student> getallstudents() {
		return repo.findByActivSw("Y");
	}

	public void delete(Integer id) {
//		Hard delete
		// repo.deleteById(id);
		Optional<Student> findById = repo.findById(id);
		if (findById.isPresent()) {
            Student student = findById.get();
            student.setActivSw("N");
            repo.save(student);
		}

	}

	public boolean save(Student student) {
		student.setActivSw("Y");
		Student save = repo.save(student);
		return save != null;
	}

	public Student findbyid(Integer id) {
		Optional<Student> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
