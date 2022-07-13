package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Course;
import model.Registration;
import model.Student;

public class StudentDaoImpInMemory implements StudentDao {

	public static List<Student> students=new ArrayList<Student>();
	public static Set<Course> courses = new HashSet<Course>();
	public static Map<Student, Course> registrations = new HashMap<Student, Course>();
	
	
	@Override
	public void registration(Student student,Course course) {
		registrations.put(student, course);
	}

	@Override
	public Map<Student, Course> viewAllRegistrations(){
	      return registrations;
	}
	
	@Override
	public String addNewStudent(Student student) {
		students.add(student);
		return "";
	
	}

	@Override
	public void updateStudentProfile(Student student) {
		Student student1= findStudentByRollNo(student.getRollNo());
		int index;
		if(student1!=null) {
			index=students.indexOf(student1);
			students.set(index,student);
		}
		
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
	
		// TODO Auto-generated method stub
		return students.stream().filter(st->st.getRollNo()==rollNo)
				         .findFirst()
                         // .get();
				         .orElse(null);
	}

	@Override
	public List<Student> viewAllStudents() {
		return students.stream().collect(Collectors.toList());
	}

	@Override
	public String addNewCourse(Course course) {
		courses.add(course);
		return "";
		
	}
	public Course findCourseById(int courseId) {
		return courses.stream()
				.filter(c->c.getCourseId()==courseId)
				.findAny()
				.orElse(null);
	}

	@Override
	public List<Course> viewAllCourses() {
		return courses.stream().collect(Collectors.toList());
	}
	
	@Override
	public String registrationDb(Registration registration) {
		return null;
	}

}
