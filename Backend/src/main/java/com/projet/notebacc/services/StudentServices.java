package com.projet.notebacc.services;

import com.projet.notebacc.model.Student;
import com.projet.notebacc.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class StudentServices {

    private StudentRepository studentRepository;
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Optional<Student>getStudentById(int id){
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteUserById(int id){
        studentRepository.deleteById(id);
    }


    public void updateStudent(int id, String firstname, String lastname , Date birthday){
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()){
            Student client = optionalStudent.get();
            client.setId_Student(id);
            client.setFirstname(firstname);
            client.setLastname(lastname);
            client.setBirthday(birthday);


            studentRepository.save(client);
        }else{
            throw new IllegalArgumentException("Tsy misy ao ilay tiana ovaina.");
        }
    }
}



