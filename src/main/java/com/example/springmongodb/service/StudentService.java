package com.example.springmongodb.service;

import com.example.springmongodb.dto.CreateStudentRequest;
import com.example.springmongodb.model.Student;
import com.example.springmongodb.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public Student create(CreateStudentRequest request) {
    Student student = Student.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .gender(request.getGender())
        .address(request.getAddress())
        .favouriteSubjects(request.getFavouriteSubjects())
        .totalSpentInBook(request.getTotalSpentInBook())
        .build();

    return studentRepository.save(student);
  }

  public Student getStudent(String email) {
    return studentRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Student not found."));
  }

  public List<Student> getAll() {
    return studentRepository.findAll();
  }

}
