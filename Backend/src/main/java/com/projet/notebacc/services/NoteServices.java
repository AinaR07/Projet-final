package com.projet.notebacc.services;

import com.projet.notebacc.model.Note;
import com.projet.notebacc.model.Student;
import com.projet.notebacc.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServices {
    private NoteRepository noteRepository;
    public List<Note> getAllNote(){
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(int id){
        return noteRepository.findById(id);
    }

    public Note saveNote(Note note){

        return noteRepository.save(note);
    }

    public void deleteUserById(int id){
        noteRepository.deleteById(id);
    }


    public void updateNote(int id){
        Optional<Note> optionalNote = noteRepository.findById(id);

        if(optionalNote.isPresent()){
            Note student = optionalNote.get();
            student.setId_note(id);
            noteRepository.save(student);
        }else{
            throw new IllegalArgumentException();
        }
    }
}
