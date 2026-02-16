package com.rest.notes.controller;

import com.rest.notes.model.Note;
import com.rest.notes.storage.InMemoryNoteStorage;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//could just used import org.springframework.web.bind.annotation.*; to import all the annotations
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/notes")
public class NoteController {
    private final InMemoryNoteStorage noteStorage;

    public NoteController(InMemoryNoteStorage noteStorage) {
        this.noteStorage = noteStorage; // Dependency injection of the storage component
    }

    @PostMapping()
    public Note create(@RequestBody Note note) {
        return noteStorage.create(note);
    }

    @GetMapping
    public Collection<Note> getAll() {
        return noteStorage.getAll();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable Long id) {
        return noteStorage.getById(id);
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note note) {
        return noteStorage.update(id, note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteStorage.delete(id);
    }

}