package in.olawale.springbooth2database.repository;

import in.olawale.springbooth2database.entity.Course;
import in.olawale.springbooth2database.entity.CourseMaterial;
import in.olawale.springbooth2database.entity.Guardian;
import in.olawale.springbooth2database.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .email("Mjohn@gmail.com")
                .name("Johny")
                .mobile("4568923456")
                .build();

        Student student = Student.builder()
                .emailId("shbir@gmail.com")
                .firstName("lol")
                .lastName("pelola")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("ECO223")
                .credit(6)
                .build();
        CourseMaterial courseMaterial= CourseMaterial.builder()
                .url("www.teststudent.com.ng/ECO223")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();
        System.out.println("courseMaterial = " + courseMaterials);
    }
}

