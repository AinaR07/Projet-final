package com.projet.notebacc.controller;

import com.projet.notebacc.model.Note;
import com.projet.notebacc.services.NoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
public class NoteController {
    @Autowired
    private NoteServices noteServices;

    @GetMapping("/note")
    public List<Note> getallnote (){
        return noteServices.getAllNote();
    }


   @PostMapping("/note/id_note")
   public Note insertUser(@RequestBody Note note){
        return noteServices.saveNote(note);
   }

    @DeleteMapping("/note/id_note/id_student")
    public void deleteStudent(@PathVariable int id){
        noteServices.deleteUserById(id);
    }

    @PutMapping("/note/id_note/id_student")
    public Optional<Note> postStudent(
            @PathVariable int id_note,
            @PathVariable int id_student
    ){noteServices.deleteUserById(id_note);
        return noteServices.getNoteById(id_student);

    }

}