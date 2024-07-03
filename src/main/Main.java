package main;

import service.ClassRoomService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static ClassRoomService room = new ClassRoomService();

    public static void main(String[] args) {
        System.out.println("----------CLASS A-----------");
        while (true){
            System.out.println("-----Chọn chức năng-----");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Xem danh sách học sinh");
            System.out.println("3. Cập nhật học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Xem danh sách học sinh bị xóa");
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năng: ");

            int choise = sc.nextInt();
            switch (choise){
                case 1:
                    registerStudent();
                    break;
                case 2:
                    room.getListStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    dropStudent();
                    break;
                case 5:
                    room.getListDropStudent();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn số !");
            }
        }

    }

    private static void updateStudent() {
        System.out.println("-----Cập nhật thông tin học sinh-----");
        System.out.println("ID: ");
        int id = sc.nextInt();
        System.out.println("Tên: ");
        String name = sc.next();
        System.out.println("Ngày sinh (yyyy-dd-mm): ");
        LocalDate birthDay = LocalDate.parse(sc.next());
        System.out.println("Cccd: ");
        String cccd = sc.next();
        room.updateStudent(id,name,birthDay,cccd);

    }

    private static void registerStudent() {
        System.out.println("-----Thêm học sinh-----");
       try {
           System.out.println("Tên: ");
           String name = sc.next();
           System.out.println("Ngày sinh (yyyy-dd-mm): ");
           LocalDate birthDay = LocalDate.parse(sc.next());
           System.out.println("Cccd: ");
           String cccd = sc.next();

           LocalDate enrollmentDate = LocalDate.now();

           room.addStudent(name,birthDay,cccd, enrollmentDate);
       }catch (Exception e){
           System.out.println("Vui lòng nhập đúng định dạng");
       }

    }

    private static void dropStudent(){
        System.out.println("Id cần xóa : ");
        int idDrop = sc.nextInt();
        sc.nextLine();
        System.out.println("Lý do: ");
        String reason = sc.nextLine();

        room.dropStudent(idDrop, reason);
    }
}
