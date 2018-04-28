package app.model;

import org.hibernate.annotations.OnDelete;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "age")
    @NotNull
    private Integer age;

    @Column(name = "is_admin")
    @NotNull
    private boolean isAdmin;

    @Column(name = "created_date")
    @GeneratedValue
    @DateTimeFormat(pattern = "MM/yyyy/dd")
    private Timestamp createdDate;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "student")
    private List<Book> books;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
