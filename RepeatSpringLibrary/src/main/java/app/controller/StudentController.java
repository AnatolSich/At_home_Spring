package app.controller;

import app.dao.StudentDao;
import app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

public class StudentController extends HttpServlet {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentDao.getAllStudents());
        return "index";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.GET)
    public String addStudent() {
        return "addStudent";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam("name") String name,
                             @RequestParam("age") Integer age,
                             @RequestParam(value = "isAdmin", defaultValue = "false") Boolean isAdmin) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setRegDate();
        student.setIsAdmin(isAdmin);
        studentDao.addStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.GET)
    public String updateStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", studentDao.getStudentById(id));
        return "updateStudent";
    }

    @RequestMapping(value = "updateStudent/{id}", method = RequestMethod.POST)
    public String updateStudent(@PathVariable int id,
                                @RequestParam("name") String name,
                                @RequestParam("age") int age,
                                @RequestParam("iaAdmin") boolean isAdmin) {
        Student existStudent = studentDao.getStudentById(id);
        existStudent.setName(name);
        existStudent.setAge(age);
        existStudent.setIsAdmin(isAdmin);
        studentDao.updateStudent(existStudent);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteStudent/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int id) {
        studentDao.deleteStudent(id);
        return "redirect:/";
    }

}
