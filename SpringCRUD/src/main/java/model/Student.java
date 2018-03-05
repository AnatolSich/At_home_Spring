package model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Basic
    private String name;

    @Column
    @NotNull
    private Boolean isExtramural;

    @Column(name = "createdDate")
    private Timestamp createdDate;

    public int getId() {
        return id;
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

    public void setCreatedDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String dateStr = format.format(timestamp);
        this.createdDate = Timestamp.valueOf(dateStr);
    }
}