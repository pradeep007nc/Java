package crudrest.crud.rest;

import crudrest.crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestController {
    List<Student> list;

    //get a list of students
    @PostConstruct
    public void loadData(){
        list = new ArrayList<>();
        list.add(new Student("pradeep", "naidu"));
        list.add(new Student("pilli", "babu"));
        list.add(new Student("chillu", "gadu"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return list;
    }

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index from the list

        //check the student id
        if(studentId >= list.size() || studentId < 0){
            throw new studentNotFoundException("Student id not found "+studentId);
        }

        return list.get(studentId);
    }

}









