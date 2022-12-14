package com.halfmoonyoga.studio.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class StudentController {
    @Autowired StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> findStudent(@PathVariable UUID studentId) {
        return studentService.findStudent(studentId);

    }
    @PostMapping("/students")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PostMapping("/students/login")
    public void login(@RequestBody String username, String password ) {
        studentService.login(username, password);
    }

    @PutMapping("/students/{studentId}")
    public void updateStudent(@PathVariable UUID studentId, @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("students/{studentId}")
    public void deleteStudent(@PathVariable UUID studentId) {
        studentService.deleteStudent(studentId);
    }

}
