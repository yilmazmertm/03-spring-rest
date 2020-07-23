package restapi.rest;

import org.springframework.web.bind.annotation.*;
import restapi.entity.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Mert", "Yılmaz"));
        theStudents.add(new Student("Hasan", "Yılmaz"));
        theStudents.add(new Student("M", "Y"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
