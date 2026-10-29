package com.thinkitive.practice2.repository;

import com.thinkitive.practice2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository already gives us save(), findById(), findAll(), etc.
// For the methods below, Spring creates the SQL query from the method name.
public interface StudentRepository extends JpaRepository<Student, Long> {

    // SELECT * FROM students WHERE deleted = false
    List<Student> findByDeletedFalse();

    // SELECT * FROM students WHERE deleted = true
    List<Student> findByDeletedTrue();

    // SELECT * FROM students WHERE id = ? AND deleted = false   (returns null if not found)
    Student findByIdAndDeletedFalse(Long id);

    // SELECT * FROM students WHERE id = ? AND deleted = true    (returns null if not found)
    Student findByIdAndDeletedTrue(Long id);

    // SELECT * FROM students WHERE course = ? AND deleted = false
    List<Student> findByCourseAndDeletedFalse(String course);
}
