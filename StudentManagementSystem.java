package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String studentID;
    private String name;
    private int age;
    private List<String> courses;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
        System.out.println();
    }

    public void updateAge(int newAge) {
        this.age = newAge;
    }

    public List<String> getCourses() {
        return courses;
    }

    public int getAge() {
        return age;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding sample students
        Student student1 = new Student("1", "Nicole", 20);
        student1.addCourse("Java advanced programming");
        student1.addCourse("Python basics");

        Student student2 = new Student("2", "Jessica", 18);
        student2.addCourse("ASP.net Core");
        student2.addCourse("Cloud Computing");

        Student student3 = new Student("3", "Christina", 18);
        student3.addCourse("Lifestyle Management");

        students.addAll(Arrays.asList(student1, student2, student3));

        // Display details of all students
        System.out.println("Details of all students:");
        students.forEach(Student::displayDetails);

        // Display students enrolled in a specific course
        String targetCourse = "Lifestyle Management";
        List<Student> studentsInCourse = students.stream()
                .filter(student -> student.getCourses().contains(targetCourse))
                .collect(Collectors.toList());

        System.out.println("Students enrolled in " + targetCourse + ":");
        studentsInCourse.forEach(Student::displayDetails);

        // Update the age of a specific student
        String targetStudentID = "002";
        int newAge = 23;

        students.stream()
                .filter(student -> student.getStudentID().equals(targetStudentID))
                .findFirst()
                .ifPresent(student -> {
                    student.updateAge(newAge);
                    System.out.println("Age updated for student with ID " + targetStudentID);
                });

        // Display details of all students after the age update
        System.out.println("Details of all students after age update:");
        students.forEach(Student::displayDetails);

        // Calculate and display the average age of all students
        double averageAge = students.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Average age of all students: " + averageAge);
    }
}
