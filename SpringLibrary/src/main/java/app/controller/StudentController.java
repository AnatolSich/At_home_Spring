package app.controller;

import app.dao.StudentDao;
import app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents(Model model) {
        List<Student> students = studentDao.getStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam("name") String name, @RequestParam("age") String age,
                             @RequestParam(value = "isAdmin", defaultValue = "false") Boolean isAdmin) {
        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setAdmin(isAdmin);
        student.setCreatedDate();
        studentDao.addStudent(student);
        return "addStudent";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.GET)
    public String addStudent() {
        return "addStudent";
    }

    @RequestMapping(value = "deleteStudent/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Integer id) {
        studentDao.removeStudent(id);
        return "redirect:/";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.GET)
    public String updateStudents(Model model, @PathVariable Integer id) {
        model.addAttribute("student", studentDao.getStudent(id));
        return "updateStudent";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.POST)
    public String updateStudents(@RequestParam("name") String name, @RequestParam("age") String age,
                                 @RequestParam(value = "isAdmin", defaultValue = "false") Boolean isAdmin,
                                 @PathVariable Integer id) {
        Student student = studentDao.getStudent(id);
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setAdmin(isAdmin);
        studentDao.updateStudent(student);
        return "redirect:/";
    }
}
