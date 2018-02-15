package model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "students")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Basic
    private String name;

    @Column
    @NotNull
    private Boolean isExtramural;

    @Column(name = "createdDate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Timestamp createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExtramural() {
        return isExtramural;
    }

    public void setExtramural(Boolean extramural) {
        isExtramural = extramural;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
