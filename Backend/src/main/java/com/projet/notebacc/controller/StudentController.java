package com.projet.notebacc.controller;

import com.projet.notebacc.model.Student;
import com.projet.notebacc.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api")
@RestController
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @GetMapping("/student")
    public List<Student> getallstudent (){

        return studentServices.getAllStudent();
    }

    @GetMapping("/Student/id_student")
    public Optional<Student> getById(@PathVariable int id){
        return studentServices.getStudentById (id);
    }

    @PostMapping("/student")
    public Student insertUser(@RequestBody Student student){

        return studentServices.saveStudent(student);
    }

    @DeleteMapping("/student/id_student")
    public void deleteStudent(@PathVariable int id){
        studentServices.deleteUserById(id);
    }


}

