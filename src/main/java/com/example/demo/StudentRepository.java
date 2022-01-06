package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1")
    List<Student> findStudentsByFirstName(String firstName);

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age = ?2")
    List<Student> findStudentsByFirstNameAndAge(String firstName, Integer age);

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 and s.age > ?2")
    List<Student> findStudentsByFirstNameAndAgeIsGreaterThan(String firstname, Integer age);
}
