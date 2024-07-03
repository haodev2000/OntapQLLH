package model;

public class DropStudent {
    private Student student;
    private String reason;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DropStudent(Student student, String reason) {
        this.student = student;
        this.reason = reason;
    }

    public DropStudent() {
    }

    @Override
    public String toString() {
        return "DropStudent{" +
                "student=" + student +
                ", reason='" + reason + '\'' +
                '}';
    }
}
