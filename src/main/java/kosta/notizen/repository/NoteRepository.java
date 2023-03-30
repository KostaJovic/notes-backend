package kosta.notizen.repository;


import kosta.notizen.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository which provides a standard set of CRUD (Create, Read, Update, Delete) methods for the Note entity.
// The first type parameter of JpaRepository is the entity type, which in this case is Note.
// The second type parameter is the type of the entity's ID, which in this case is Long.
// By extending JpaRepository, NoteRepository gets all the CRUD methods for free.
// You can also define custom methods here, which will be automatically implemented by Spring Data JPA.
public interface NoteRepository extends JpaRepository<Note, Long> {
}