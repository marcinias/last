package com.example.demo.student;

import com.example.demo.student.exeption.BadRequestException;
import com.example.demo.student.exeption.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existEmail = studentRepository.existsByEmail(student.getEmail());
        if (existEmail)
            throw new BadRequestException("Email : " + student.getEmail() + " taken");
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId))
            throw new StudentNotFoundException("Student with id" + studentId + "not exists");
        studentRepository.deleteById(studentId);
    }
}
