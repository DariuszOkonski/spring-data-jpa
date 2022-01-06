package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

            Student ahmed = new Student(
                    "Ahmed",
                    "Ali",
                    "ahmed.ali@amigoscode.edu",
                    21
            );

//            System.out.println("==> Adding maria and ahmed");
            studentRepository.saveAll(List.of(maria, ahmed));
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

            System.out.println("=======================================================");

            studentRepository
                    .findStudentByEmail("ahmed.ali@amigoscode.edu")
                    .ifPresentOrElse(
                            student -> {
                                System.out.println("Student: " + student);
                            },
                            () -> System.out.println("Student not found")
                    );


        };
    }

}
