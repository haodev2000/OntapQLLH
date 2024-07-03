package model;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private static int idCounter = 1;
    private int studentId;
    private String name;
    private LocalDate birthDate;
    private String cccd;
    private LocalDate enrollmentDate;

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCccd() {
        return cccd;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
    public Student(String name, LocalDate birthDate, String cccd, LocalDate enrollmentDate) {
        this.studentId = idCounter++;
        this.name = name;
        this.birthDate = birthDate;
        this.cccd = cccd;
        this.enrollmentDate = enrollmentDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }



    @Override
    public String toString() {
        return "Student ID: " + studentId + "\nName: " + name + "\nBirth Date: " + birthDate + "\nCCCD: " + cccd + "\nEnrollment Date: " + (enrollmentDate != null ? enrollmentDate : "Not enrolled yet");
    }
}
