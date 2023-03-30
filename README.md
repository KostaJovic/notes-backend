## Files and their descriptions

### NotizenApplication.java
This file is the entry point of the Spring Boot application. It contains the `main()` method, which starts the Spring Boot application by calling the `run()` method of the `SpringApplication` class.

### Note.java
This file is an entity class that represents the `Note` object. It is annotated with the `@Entity` annotation, which indicates that it is a JPA entity. The `Note` entity has three properties: 
- `id`
- `title`
- `content`

Each property has its respective getter and setter methods.

### NoteRepository.java
This file is a Spring Data JPA repository interface that provides methods to perform CRUD (Create, Read, Update, and Delete) operations on the `Note` entity. It extends the `JpaRepository` interface, which provides a set of common methods for CRUD operations such as:
- `findAll()`
- `findById()`
- `save()`
- `delete()`

By extending `JpaRepository`, `NoteRepository` inherits these methods and can use them to interact with the database.

### NoteController.java
This file is a REST controller that handles HTTP requests related to the `Note` entity. The `NoteController` class has five methods:

#### getNotes()
Handles HTTP GET requests to the base URL and returns a list of all notes in the database. It calls the `findAll()` method of the `NoteRepository` interface.

#### createNote()
Handles HTTP POST requests to the base URL and creates a new note in the database. It takes a `Note` object as input, which is deserialized from the JSON request body. It calls the `save()` method of the `NoteRepository` interface to save
