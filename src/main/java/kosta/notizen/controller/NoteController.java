package kosta.notizen.controller;

import kosta.notizen.entity.Note;
import kosta.notizen.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/notes") // Specifies the base URL for all requests handled by this controller
@CrossOrigin(origins = "http://localhost:3000") // Specifies that cross-origin requests from http://localhost:3000 are allowed
public class NoteController {
	@Autowired
	private NoteRepository noteRepository; // Autowires the NoteRepository so that it can be used in this controller

	@GetMapping
	public List<Note> getNotes() {
		return noteRepository.findAll(); // Returns a list of all notes in the database
	}

	@PostMapping
	public Note createNote(@RequestBody Note note) {
		return noteRepository.save(note); // Saves a new note to the database
	}

	@GetMapping("/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
		Optional<Note> optionalNote = noteRepository.findById(id); // Finds the note with the specified ID, if it exists
		if (optionalNote.isPresent()) {
			return ResponseEntity.ok(optionalNote.get()); // Returns the note with a 200 OK status code
		} else {
			return ResponseEntity.notFound().build(); // Returns a 404 Not Found status code
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Note> updateNoteById(@PathVariable Long id, @RequestBody Note note) {
		Optional<Note> optionalNote = noteRepository.findById(id); // Finds the note with the specified ID, if it exists
		if (optionalNote.isPresent()) {
			Note existingNote = optionalNote.get(); // Gets the existing note from the Optional
			existingNote.setTitle(note.getTitle()); // Updates the existing note's title
			existingNote.setContent(note.getContent()); // Updates the existing note's content
			noteRepository.save(existingNote); // Saves the updated note to the database
			return ResponseEntity.ok(existingNote); // Returns the updated note with a 200 OK status code
		} else {
			return ResponseEntity.notFound().build(); // Returns a 404 Not Found status code
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
		Optional<Note> optionalNote = noteRepository.findById(id); // Finds the note with the specified ID, if it exists
		if (optionalNote.isPresent()) {
			noteRepository.delete(optionalNote.get()); // Deletes the note from the database
			return ResponseEntity.noContent().build(); // Returns a 204 No Content status code
		} else {
			return ResponseEntity.notFound().build(); // Returns a 404 Not Found status code
		}
	}
}
