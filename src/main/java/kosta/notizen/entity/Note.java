package kosta.notizen.entity;


import javax.persistence.*;

@Entity // Indicates that this is a JPA entity
@Table(name = "notes") // Specifies the name of the database table for this entity
public class Note {
    @Id // Marks the field 'id' as the primary key for this entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID is generated automatically by the database
    private Long id;

    @Column(nullable = false) // Specifies that this field cannot be null
    private String title;

    @Column(nullable = false) // Specifies that this field cannot be null
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}