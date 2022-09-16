package com.projet.notebacc.controller;

import com.projet.notebacc.model.Registration;
import com.projet.notebacc.services.RegistrationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationServices registrationServices;

    @GetMapping("/registration")
    public List<Registration> getallregistration (){
        return registrationServices.getAllStudent();
    }





    @PutMapping("/registration/id_note/id_student")
    public List<Registration> postStudent(
            @PathVariable int id_note,
            @PathVariable int id_student
    ){registrationServices.deleteUserById(id_note);
        return registrationServices.getAllStudent();

    }


}
