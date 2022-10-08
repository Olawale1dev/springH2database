package in.olawale.springbooth2database.repository;

import in.olawale.springbooth2database.entity.Course;
import in.olawale.springbooth2database.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course coursePMT =
                Course.builder()
                        .title("PMT")
                        .credit(5)
                        .build();

        Course courseENG =
                Course.builder()
                        .title("ENG")
                        .credit(4)
                        .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Mr gilolo")
                        .lastName("benson")
                        //.course(Arrays.asList(coursePMT, courseENG))
                        .build();
        teacherRepository.save(teacher);

    }

}