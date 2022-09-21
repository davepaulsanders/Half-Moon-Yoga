package com.halfmoonyoga.studio.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StudentService {
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Optional<Student> findStudent(UUID studentId) {
            return studentRepository.findById(studentId);
    }
    public void createStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
    }

    public boolean login(String username, String password) {
        Optional<Student> student = studentRepository.findByUsername(username);
        if (student.equals()) {
            boolean matches = BCrypt.checkpw(student.get().getPassword(), password);
            if (matches) {
                System.out.println("Logged in");
                return true;
            }
        } else {
            System.out.println("didn't work");
            return false;
        }
    return false;
    }
    public void updateStudent(UUID studentId, Student student) {
        if (studentRepository.findById(studentId).isPresent()) {
            studentRepository.save(student);
        }
    }
    public void deleteStudent(UUID studentId) {
        studentRepository.deleteById(studentId);
    }

}
