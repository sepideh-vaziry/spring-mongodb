package com.example.springmongodb.dto;

import com.example.springmongodb.model.Address;
import com.example.springmongodb.model.Gender;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class CreateStudentRequest implements Serializable {

  private String firstName;
  private String lastName;
  private String email;
  private Gender gender;
  private Address address;
  private List<String> favouriteSubjects;
  private BigDecimal totalSpentInBook;

}
