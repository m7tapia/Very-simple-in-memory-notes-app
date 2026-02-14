package com.rest.notes.storage;

import com.rest.notes.model.Note;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


public class InMemoryNoteStorage {

    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Note create(Note note) {
        long id = idGenerator.incrementAndGet();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public Collection<Note> getAll() {
        return notes.values();
    }

    public Note getById(Long id) {
        return notes.get(id);
    }
    public Note update(Long id, Note note) {
        if (notes.containsKey(id)) {
            note.setId(id);
            notes.put(id, note);
            return note;
        }
        return null;
    }

    public void delete(Long id) {
        notes.remove(id);
    }
}
