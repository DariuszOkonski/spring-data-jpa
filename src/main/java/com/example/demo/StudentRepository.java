package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);

    List<Student> findStudentsByFirstName(String firstName);
    List<Student> findStudentsByFirstNameAndAge(String firstName, Integer age);
    List<Student> findStudentsByFirstNameAndAgeIsGreaterThan(String firstname, Integer age);
}
