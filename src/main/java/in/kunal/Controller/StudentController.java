package in.kunal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.kunal.Entity.Student;
import in.kunal.Service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/Students")
	private String allStudents(Model model) {
		List<Student> students = service.getallstudents();
		model.addAttribute("Students", students);
		return "index";
	}

	@GetMapping("/Student/form")
	public String studentobject(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "Create_Student";
	}

	@PostMapping("/save")
	public String savestudent(Model model, @ModelAttribute("student") Student student) {
		boolean save = service.save(student);
		model.addAttribute("Save", student);
		return "redirect:/Students";
	}

	@GetMapping("/students/{id}")
	public String delete(@PathVariable Integer id) {
		 service.delete(id);
		return "redirect:/Students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("Student", service.findbyid(id));
		return "Create_Student";
	}

	

}
