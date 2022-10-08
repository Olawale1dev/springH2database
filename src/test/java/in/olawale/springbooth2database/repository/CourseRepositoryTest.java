package in.olawale.springbooth2database.repository;

import in.olawale.springbooth2database.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> course= courseRepository.findAll();
        System.out.println("courses = " + course);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("okoro")
                .lastName("ben")
                .build();

        Course course = Course
                .builder()
                .title("java")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    @Test
    public void findAllPagination(){

        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithRecords =
                PageRequest.of(1, 2);
        List<Course> course = courseRepository
                .findAll(secondPageWithRecords)
                .getContent();
        Long totalElements = courseRepository
                .findAll(secondPageWithRecords)
                .getTotalElements();

        int totalPages = courseRepository
                .findAll(secondPageWithRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
                System.out.println("courses = " + course);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
                );
        Pageable sortByCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title").descending()
                        .and(Sort.by("credit").descending())
        );

        List<Course> course = courseRepository
                .findAll(sortByTitle)
                .getContent();

        System.out.println("courses = " + course);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> course = courseRepository
                .findByTitleContaining("E",
                         firstPageTenRecords).getContent();

        System.out.println("course = " + course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("juliet")
                .lastName("Eri")
                .build();

        /*Guardian guardian = Guardian
                .builder()
                .name("Mr.Charls")
                .mobile("222222222")
                .email("chrl@gmail.com")
                .build();*/


        Student student = Student
                .builder()
                .firstName("bola")
                .lastName("Oyen")
                .emailId("ebv@gmail.com")
                //.guardian(guardian)
                .build();


       /* CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .url("www.gil.com/PHY321")
                .build();*/


        Course course = Course
                .builder()
                .title("PHY321")
                .credit(4)
                .teacher(teacher)
                //.courseMaterial(courseMaterial)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}