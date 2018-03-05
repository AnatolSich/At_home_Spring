package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.StudentRepository;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents(Model model){
        List<Student> students = studentRepository.getAllStud();
        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.GET)
    public String addStudent(){
        return "addStudent";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam(value = "name") String name
            , @RequestParam(value = "isExtramural", defaultValue = "false") Boolean isExtramural){
        Student student = new Student();
        student.setName(name);
        student.setExtramural(isExtramural);
        student.setCreatedDate();
        studentRepository.addStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteStudent/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.removeStudent(id);
        return "redirect:/";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.GET)
    public String getUpdate(@PathVariable Integer id, Model model){
        model.addAttribute("studentAttribute", studentRepository.getStudent(id));
        return "updateStudent";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.POST)
    public String postUpdate(@RequestParam(value = "name") String name
            , @RequestParam(value = "extramural", defaultValue = "false") Boolean isExtramural
            , @PathVariable Integer id){
        Student student = studentRepository.getStudent(id);
        student.setName(name);
        student.setExtramural(isExtramural);
        studentRepository.updateStudent(student);
        return "redirect:/";
    }

}
