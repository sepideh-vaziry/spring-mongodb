package com.example.springmongodb;

import com.example.springmongodb.dto.CreateStudentRequest;
import com.example.springmongodb.dto.StudentResponse;
import com.example.springmongodb.model.Student;
import com.example.springmongodb.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  public StudentResponse create(@RequestBody CreateStudentRequest request) {
    Student student = studentService.create(request);

    return mapToResponse(student);
  }

  @GetMapping
  public List<StudentResponse> getAll() {
    List<Student> students = studentService.getAll();

    return students.stream().map(this::mapToResponse).toList();
  }

  @GetMapping("/email/{email}")
  public StudentResponse getByEmail(@PathVariable String email) {
    Student student = studentService.getStudent(email);

    return mapToResponse(student);
  }

  private StudentResponse mapToResponse(Student student) {
    return StudentResponse.builder()
        .id(student.getId())
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .email(student.getEmail())
        .gender(student.getGender())
        .address(student.getAddress())
        .favouriteSubjects(student.getFavouriteSubjects())
        .totalSpentInBook(student.getTotalSpentInBook())
        .createdAt(student.getCreatedAt())
        .build();
  }

}
