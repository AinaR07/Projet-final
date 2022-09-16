package com.projet.notebacc.services;

import com.projet.notebacc.model.Note;
import com.projet.notebacc.model.Registration;
import com.projet.notebacc.repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationServices {

    private RegistrationRepository registrationRepository;

    public List<Registration> getAllStudent(){
        return registrationRepository.findAll();
    }

    public void deleteUserById(int id){
        registrationRepository.deleteById(id);
    }


    public void updateNote(int id){
        Optional<Registration> optionalRegistration = registrationRepository.findById(id);

        if(optionalRegistration.isPresent()){
            Registration student = optionalRegistration.get();
            student.setId_Registration(id);
            registrationRepository.save(student);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void addRegistration(int id, Registration student) {
    }
}
