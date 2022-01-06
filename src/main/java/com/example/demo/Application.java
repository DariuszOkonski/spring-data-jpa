package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

// next -> native queries

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "Jones",
                    "maria.jones@amigoscode.edu",
                    21);

            Student maria2 = new Student(
                    "Maria",
                    "Phillips",
                    "maria2.jones@amigoscode.edu",
                    25);

            Student ahmed = new Student(
                    "Ahmed",
                    "Ali",
                    "ahmed.ali@amigoscode.edu",
                    21
            );

            Student ahmedSecond = new Student(
                    "Ahmed",
                    "Johnston",
                    "ahmed.johnston@gmail.com",
                    35
            );

//            System.out.println("==> Adding maria and ahmed");
            studentRepository.saveAll(List.of(maria, maria2, ahmed, ahmedSecond));
//
//            System.out.println("===================================");
//
//            System.out.println("==> Number of students");
//            System.out.println(studentRepository.count());
//
//            studentRepository.findById(2L)
//                    .ifPresentOrElse(
//                            System.out::println,
//                            () -> {
//                                System.out.println("Student with id 2 not found");
//                            });
//
//
//            studentRepository.findById(3L)
//                    .ifPresentOrElse(
//                            System.out::println,
//                            () -> {
//                                System.out.println("Student with id 3 not found");
//                            }
//                    );
//
//            System.out.println("==> Select all students");
//            List<Student> students = studentRepository.findAll();
//            students.forEach(System.out::println);
//
//            System.out.println("==> Delete maria");
//            studentRepository.deleteById(1L);
//
//            System.out.println("==> Number of students");
//            System.out.println(studentRepository.count());

            System.out.println("1 =======================================================");

            studentRepository
                    .findStudentByEmail("ahmed.ali@amigoscode.edu")
                    .ifPresentOrElse(
                            student -> {
                                System.out.println("Student: " + student);
                            },
                            () -> System.out.println("Student not found")
                    );

            System.out.println("2 =======================================================");
            studentRepository
                    .findStudentsByFirstName("Ahmed")
                    .stream()
                    .forEach(student -> {
                        System.out.println(student);
                    });

            System.out.println("3 =======================================================");
            studentRepository
                    .findStudentsByFirstNameAndAge("Ahmed", 35)
                    .forEach(System.out::println);

            System.out.println("4 =======================================================");
            studentRepository
                    .findStudentsByFirstNameAndAgeIsGreaterThan("Maria", 20)
                    .forEach(System.out::println);


        };
    }

}
