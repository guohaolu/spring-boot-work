package com.stealandfire.demo.stream;

import lombok.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalStreamTest {
    @Test
    public void testStream() {
        List<Student> students = Stream.of(
                Student.builder().name("tom").age(15).teacher(new Teacher("tea1")).build(),
                Student.builder().name("jack").age(16).teacher(new Teacher("tea2")).build()
        ).collect(Collectors.toList());
        List<Student> returnStudents = students.stream().map(obj -> {
            Student student = new Student();
            BeanUtils.copyProperties(obj, student);
            return student;
        }).collect(Collectors.toList());
        System.out.println(students);
        // returnStudents.get(0).getTeacher().setName("tea100");
        System.out.println(students);
    }

    @Test
    public void testArrayOfIndex() {
        Student stu = Student.builder().name("tom").age(15).teacher(new Teacher("tea1")).build();
        System.out.println(stu);
        System.out.println(stu);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Student {
        private String name;
        private Integer age;
        private Teacher teacher;
    }

    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    static final class Teacher {
        private String name;
    }
}
