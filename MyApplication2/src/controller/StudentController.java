/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Students;
import java.util.ArrayList;
import java.util.Scanner;
import view.MainThread;

/**
 *
 * @author Admin
 */
public class StudentController {

    public Students/*vì trả về 1 thằng sv*/ getStudentInfo() {
        Scanner scn1 = new Scanner(System.in);
        System.out.println("Nhập tên");
        String name = scn1.nextLine();
        System.out.println("Nhập ma sv");
        String rollNumber = scn1.nextLine();
        Students student = new Students(name, rollNumber);
        System.out.println("Sinh viên mới là " + name + " mã sv : " +rollNumber);
        return student;
        
        /*3 dòng trên có thể viết là
            return new student(name, phone,address,rollNumber);
        */
    }

    public void displayStdList(ArrayList<Students> listStudents) {
        System.out.println("Danh sách sinh viên");
        System.out.println("Tên SV"+"\t" +"Mã SV ");
        for (int i = 0; i < listStudents.size(); i++) {
            Students std = listStudents.get(i);            
            System.out.println(std.getName()+ "\t"+ std.getRollNumber() );
        }
    }
}
