//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 # This patch file was generated by NetBeans IDE
//# It uses platform neutral UTF-8 encoding and \n newlines.
//--- a/<html>MainThread.java (<b>Today 4:03:17 PM</b>)</html>
//+++ b/<html><b>Current File</b></html>
//@@ -1,68 +1 @@
package view;

import java.util.Scanner;
import controller.StudentController;
import entity.Students;
import java.util.ArrayList;
import model.StudentModel;

/**
 *
 * @author Admin
 */
public class MainThread {

    public static void main(String[] args) {         
        generateMenu(); 
        inSert();
    }
    public static void inSert(){
        StudentModel studentModel = new StudentModel();
        Students student = new Students();
//        student.setName("Thu");
//        student.setAddress("SG");
//        student.setPhone("0913570779");
//        student.setRollNumber("1617740076");
        studentModel.insert(student);
    }
//    public static void demoArrayList() {
//        ArrayList<Students> listStudents = new ArrayList<>();
//        for (int i = 0; i < listStudents.size(); i++) {
//            Students student = listStudents.get(i);
//            System.out.println(student.getName());
//        }
//    }
    public static void generateMenu() {
        StudentModel studentModel = new StudentModel();
        StudentController stdCtrl = new StudentController();
        Scanner scn1 = new Scanner(System.in);
        ArrayList<Students> listStudents = new ArrayList<>();
        while (true) {
            System.out.println("Xin mời nhập lựa chọn của bạn");
            System.out.println("1.Thêm mới sinh viên");
            System.out.println("2.Hiển thị danh sách");
            System.out.println("3.Thoát");
            System.out.println("Quản lý sinh viên");
            int a = scn1.nextInt();
            switch (a) {

                case 1:
                    Students student = stdCtrl.getStudentInfo();
                    if(student.isValid()){
//                        listStudents.add(student);
                        studentModel.insert(student);                        
                    }
                    else {
                        System.err.println("thông tin sv không hợp lệ");
                    }
                    break;
                case 2:
//                  stdCtrl.displayStdList(listStudents);
                    ArrayList<Students> listStudent = studentModel.getList();
                    
                    break;
                case 3:
                    System.out.println("Thoát");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn sai");
                    System.out.println("xin mời nhập lại");
                    break;
            }
            if (a == 3) {
                break;
            }
        }
    }

}
