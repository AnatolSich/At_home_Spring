package app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "author")
    @NotNull
    private String author;

    @Column(name = "pages")
    @NotNull
    private int pages;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
