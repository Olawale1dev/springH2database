package in.olawale.springbooth2database.controller;


import in.olawale.springbooth2database.entity.Course;
import in.olawale.springbooth2database.entity.CourseMaterial;
import in.olawale.springbooth2database.entity.Customer;
import in.olawale.springbooth2database.entity.Student;
import in.olawale.springbooth2database.repository.CourseMaterialRepository;
import in.olawale.springbooth2database.repository.CourseRepository;
import in.olawale.springbooth2database.repository.ICustomerRepo;
import in.olawale.springbooth2database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    ICustomerRepo customerRepo;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Autowired
   private CourseRepository courseRepository ;

    @PostMapping ("/customers")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        try{

            return new ResponseEntity<>( customerRepo.save(customer), HttpStatus.CREATED);
        }catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/student")
    public ResponseEntity<Student>  save (@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("student/{firstName}")
    public ResponseEntity<List<Student>> findByFirst(@PathVariable String firstName){
        try{
             List<Student> list = studentRepository.findByFirstName(firstName);
             if(list.isEmpty()|| list.size()==0){
                 return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
             }
             return  new ResponseEntity<List<Student>>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAllContain(){
        try{
            List<Student> list = studentRepository.findAll();
            if(list.isEmpty()|| list.size()==0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<List<Student>>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping("/student/{lastName}")
    public ResponseEntity<List<Student>> findByLast(@PathVariable String lastName){
        try{
            List<Student> list = studentRepository.findByLastName(lastName);
            if(list.isEmpty() || list.size()==0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<List<Student>>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
//
    @GetMapping("student/{name}")
    public ResponseEntity<List<Student>> printFindByNameContaining(@PathVariable String name){
        try{
            List<Student> list = studentRepository.findByFirstNameContaining(name);
            if(list.isEmpty() || list.size()==0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<List<Student>>(list, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/{guardianName}")
    public ResponseEntity<List<Student>> printFindByGuardianName(@PathVariable String guardianName){
        try{
            List<Student> student=studentRepository.findByGuardianName(guardianName);
            if(student.isEmpty() || student.size()==0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/student/{emailId}")
    public ResponseEntity<List<Student>> printGetStudentByEmailAddress(@PathVariable String emailId){
        try{
            List<Student> student=studentRepository.getStudentByEmailAddress(emailId);
            if(student.isEmpty() || student.size() == 0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   /* @GetMapping("/{emailId}")
    public ResponseEntity<List<Student>> printGetStudentFirstNameByEmailAddress(@PathVariable String emailId){
        try{
             List<Student> student=studentRepository.getStudentFirstNameByEmailAddress(emailId);
            if(student.isEmpty() || student.size()==0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    //Native Query
    /*@GetMapping("/{emailId}")
    public ResponseEntity<List<Student>> printGetStudentByEmailAddressNative(@PathVariable String emailId){
        try{
            List<Student> student=studentRepository.getStudentByEmailAddressNative(emailId);
            if(student.isEmpty() || student.size()==0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    //Native Named Parameter
    @GetMapping("/{emailId}")
    public ResponseEntity<List<Student>> printGetStudentByEmailAddressNativeNamedParam(@PathVariable String emailId){
        try{
            List<Student> student=studentRepository.getStudentByEmailAddressNativeNamedParam(emailId);
            if(student.isEmpty() || student.size()==0){
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping ("/student/{emailid}")
    public ResponseEntity<Student>updateStudentNameByEmailId(@RequestBody Student student){
        try{
            return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
        } catch(Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //if(student.isEmpty() || student.size()==0){
    //                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
    @GetMapping ("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        try{
            List<Customer> list = customerRepo.findAll();
            if(list.isEmpty() || list.size() ==0){
                return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR );
        }

    }

    @GetMapping ("/customers/{id}")
    public ResponseEntity<Customer> getSingleCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepo.findById(id);

        if (customer.isPresent()){
        return new ResponseEntity<Customer>(customer.get(), HttpStatus.OK);
        }
        else{ return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND ); }
    }
    @PutMapping ("/customers/{id}")
    public ResponseEntity<Customer>updateCustomers(@RequestBody Customer customer){
        try{
          return new ResponseEntity<Customer>(customerRepo.save(customer), HttpStatus.OK);
        } catch(Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomers(@PathVariable Long id){
        try{
            Optional <Customer> customer = customerRepo.findById(id);
            if (customer.isPresent()){
                customerRepo.delete(customer.get());
            }
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/courseMaterial")
    public ResponseEntity<CourseMaterial> save(@RequestBody CourseMaterial courseMaterial){
        try{
            return new ResponseEntity<CourseMaterial>(courseMaterialRepository.save(courseMaterial), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/course")
    public ResponseEntity<Course> save(@RequestBody Course course){
        try{
            return new ResponseEntity<Course>(courseRepository.save(course), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


