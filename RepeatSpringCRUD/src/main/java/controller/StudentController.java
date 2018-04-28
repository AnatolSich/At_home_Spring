package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.StudentService;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String allStudent(Model model) {
        List<Student> list = studentService.getAllStudent();
        model.addAttribute("students", list);
        return "index";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.GET)
    public String addStudentGet() {
        return "addStudent";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public String addStudentPost(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "external" , defaultValue = "false") Boolean external) {
        Student student = new Student();
        student.setName(name);
        student.setExternal(external);
        student.setCreateDate();
        studentService.addStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateStudentGet(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        return "updateStudent";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String updateStudentPost(@PathVariable int id,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "external", defaultValue = "false") Boolean external) {
        Student student = studentService.getStudent(id);
        student.setName(name);
        student.setExternal(external);
        studentService.updateStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteStudentGet(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/";

    }

}
