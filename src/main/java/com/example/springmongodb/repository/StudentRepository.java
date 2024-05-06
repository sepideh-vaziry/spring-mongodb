package com.example.springmongodb.repository;

import com.example.springmongodb.model.Student;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

  Optional<Student> findByEmail(String email);

}
