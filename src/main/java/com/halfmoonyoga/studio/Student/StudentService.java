package com.halfmoonyoga.studio.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
    public void createStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
    }

}
