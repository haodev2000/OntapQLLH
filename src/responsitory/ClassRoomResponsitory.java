package responsitory;

import java.time.LocalDate;

public interface ClassRoomResponsitory {
    void addStudent(String name, LocalDate birthDate, String cccd, LocalDate enrollmentDate);
    void startClass();
    void getListStudent();
    void updateStudent(int id, String name, LocalDate birthDay, String cccd);
    void dropStudent(int id, String reason);
    void getListDropStudent();
}
