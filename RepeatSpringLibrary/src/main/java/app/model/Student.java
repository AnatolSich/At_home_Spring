package app.model;

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
    private int age;

    @Column(name = "reg_date")
    @GeneratedValue
    @DateTimeFormat(pattern = "dd:MM:yyyy")
    @NotNull
    private Timestamp regDate;

    @Column(name = "is_admin")
    @NotNull
    private  boolean isAdmin;

    @OneToMany (cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "student")
    private List<Book> books;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate() {
        this.regDate = new Timestamp(System.currentTimeMillis());
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        isAdmin = isAdmin;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
