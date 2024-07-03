package service;


import model.DropStudent;
import model.Student;
import responsitory.ClassRoomResponsitory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomService implements ClassRoomResponsitory {

    private static final int MAX_CAPACITY= 10;
    private List<Student> students = new ArrayList<>();
    private List<DropStudent> dropStudents = new ArrayList<>();

    boolean classStarted = false;

    public void addStudent(String name, LocalDate birthDate, String cccd, LocalDate enrollmentDate){
        if(students.size() >= 10){

            System.out.println("Lớp đã đầy !");
            return;
        }

        Student newStudent = new Student(name,birthDate,cccd,enrollmentDate);
        if(newStudent.getAge() >= 18 && newStudent.getAge()<=20){
            students.add(newStudent);
            if (students.size() == MAX_CAPACITY){
                startClass();
            }
        }else {
            System.out.println("Thêm thất bại - tuổi học sinh phải từ 18 đến 20 !");
        }
    }

    public void startClass(){
        classStarted = true;
        LocalDate start = LocalDate.now();
        System.out.println("Lớp học đã bắt đầu vào : " + start);
    }

    public void getListStudent(){
        if(students.isEmpty()){
            System.out.println("Không có học sinh nào !");
        }else {
            String leftAlignFormat = "| %-10d | %-20s | %-15s | %-20s | %-15s |%n";
            System.out.format("+------------+----------------------+-----------------+----------------------+-----------------+%n");
            System.out.format("| Student ID | Name                 | Birth Date      | CCCD                 | Enrollment Date |%n");
            System.out.format("+------------+----------------------+-----------------+----------------------+-----------------+%n");
            for (Student student : students) {
                System.out.format(leftAlignFormat, student.getStudentId(), student.getName(), student.getBirthDate(), student.getCccd(), (student.getEnrollmentDate() != null ? student.getEnrollmentDate() : "Not enrolled yet"));
            }
            System.out.format("+------------+----------------------+-----------------+----------------------+-----------------+%n");



        }
    }

    public void updateStudent(int id, String name, LocalDate birthDay, String cccd){
        for (Student s : students){
            if (s.getStudentId()==id){

                s.setName(name);
                s.setBirthDate(birthDay);
                s.setCccd(cccd);
                System.out.println("Cập nhật thông tin thành công !");
                break;
            }

        }

    }

    public void dropStudent(int id, String reason){
        for (Student s : students){
            if (s.getStudentId()==id){
                students.remove(s);
                dropStudents.add(new DropStudent(s, reason));
                System.out.println("Xóa học sinh thành công !");
                return;
            }else {
                System.out.println("Không tìm thấy id học sinh !");
            }
        }
    }

    public void getListDropStudent(){
        if (dropStudents.isEmpty()){
            System.out.println("Danh sách rỗng !");
        }else {
            String leftAlignFormat = "| %-10d | %-20s | %-15s | %-20s | %-15s | %-20s |%n";

            System.out.format("+------------+----------------------+-----------------+----------------------+-----------------+----------------------+%n");
            System.out.format("| Student ID | Name                 | Birth Date      | CCCD                 | Enrollment Date | Reason               |%n");
            System.out.format("+------------+----------------------+-----------------+----------------------+-----------------+----------------------+%n");
            for (DropStudent droppedStudent : dropStudents) {
                Student student = droppedStudent.getStudent();
                System.out.format(leftAlignFormat, student.getStudentId(), student.getName(), student.getBirthDate(), student.getCccd(), (student.getEnrollmentDate() != null ? student.getEnrollmentDate() : "Not enrolled yet"), droppedStudent.getReason());
            }
            System.out.format("+------------+----------------------+-----------------+----------------------+-----------------+----------------------+%n");
        }
    }

}
