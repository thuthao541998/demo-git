/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentModel {
    
    public boolean insert(Students std) {
        try { //khi lệnh try đúng thì thực hiện try, khi k đúng thì thực hiện catch
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8",
                    "root", "");
            //trả về 1 đối tg nằm trong đối tượng connection
            //tạo 1 kết nối vào database : username,pass
            Statement stt = connection.createStatement(); //câu truy vấn trả về một 1 đối tượng thuộc lớp statement
            stt.execute("insert into student (ten,diaChi,dienThoai,maSinhVien) values ('" + std.getName() + "','" + std.getAddress() + "','" + std.getPhone() + "','" + std.getRollNumber() + "')");
            //đang thực hiện 1 câu lệnh vào database
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public ArrayList<Students> getList() {
        ArrayList<Students> listStudent = new ArrayList<>();
        try { //khi lệnh try đúng thì thực hiện try, khi k đúng thì thực hiện catch
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8",
                    "root", "");
            //trả về 1 đối tg nằm trong đối tượng connection
            //tạo 1 kết nối vào database : username,pass
            Statement stt = connection.createStatement(); //câu truy vấn trả về một 1 đối tượng thuộc lớp statement
            ResultSet rs = stt.executeQuery("SELECT * FROM student");
            System.out.println("Danh sách sinh viên");
            System.out.println("====================");
            System.out.printf("%10s \t\t %10s\n", "Tên", "MaSV");
            while (rs.next()) {
//                int id = rs.getInt("id");
                rs.next();
                String name = rs.getString("ten");
                String rollNumber = rs.getString("maSinhVien");
                Students students = new Students(name, rollNumber);
                listStudent.add(students);
                for (int i = 0; i < listStudent.size(); i++) {
                    Students std = listStudent.get(i);
                    System.out.printf("%10s \t\t %10s\n", std.getName(), std.getRollNumber());
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listStudent;
    }
    
    public Students getByID(int id) {
        //hàm này nhân tham số dầu vào là id Students
        //Trả về mốt đối tượng student trong database tồn tại bản ghi
        //với id truyền vào. Trong trg hơp k tồn tại trả về null
        Students std = null;
        try { //khi lệnh try đúng thì thực hiện try, khi k đúng thì thực hiện catch
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8",
                    "root", "");
            //trả về 1 đối tg nằm trong đối tượng connection
            //tạo 1 kết nối vào database : username,pass
            Statement stt = connection.createStatement(); //câu truy vấn trả về một 1 đối tượng thuộc lớp statement            
            ResultSet rs = stt.executeQuery("SELECT * FROM student where id =" + id);
            if (rs.next()) {
//                int id = rs.getInt("id");
                int sId = rs.getInt("id");
                String name = rs.getString("ten");
                String rollNumber = rs.getString("maSinhVien");
                std = new Students(sId, name, rollNumber);
                System.out.printf("%10s \t\t %10s\n", std.getName(), std.getRollNumber());
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return std;
    }    

    public ArrayList<Students> searchByName(String name) {
        ArrayList<Students> list = new ArrayList<>();
        try { //khi lệnh try đúng thì thực hiện try, khi k đúng thì thực hiện catch
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8",
                    "root", "");
            //trả về 1 đối tg nằm trong đối tượng connection
            //tạo 1 kết nối vào database : username,pass
            Statement stt = connection.createStatement(); //câu truy vấn trả về một 1 đối tượng thuộc lớp statement            
            ResultSet rs = stt.executeQuery("SELECT * FROM student where ten like '%"+name+"' ");
            if (rs.next()) {
//                int id = rs.getInt("id");
                int sId = rs.getInt("id");
                String sName = rs.getString("ten");
                String rollNumber = rs.getString("maSinhVien");
                Students std = new Students(sId, name, rollNumber);
                list.add(std);
                for (int i = 0; i < list.size(); i++) {
                    Students std1 = list.get(i);
                    System.out.printf("%10s \t\t %10s\n", std1.getName(), std1.getRollNumber());
                }
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean checkExistRollNumber(String rollNumber) {
        //Kiểm tra sự tồn tại
        Students std = null;
        try { //khi lệnh try đúng thì thực hiện try, khi k đúng thì thực hiện catch
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8",
                    "root", "");
            //trả về 1 đối tg nằm trong đối tượng connection
            //tạo 1 kết nối vào database : username,pass
            Statement stt = connection.createStatement(); //câu truy vấn trả về một 1 đối tượng thuộc lớp statement            
            ResultSet rs = stt.executeQuery("SELECT * FROM student where maSinhVien ="+rollNumber );
            if (rs.next()) {
                System.out.println("Có tồn tại sinh viên");
                return true;
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Không tồn tại sv");
        return false;
    }
    public static void update(){
         try { //khi lệnh try đúng thì thực hiện try, khi k đúng thì thực hiện catch
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien?useUnicode=true&characterEncoding=utf-8",
                    "root", "");
            //trả về 1 đối tg nằm trong đối tượng connection
            //tạo 1 kết nối vào database : username,pass
            Statement stt = connection.createStatement(); //câu truy vấn trả về một 1 đối tượng thuộc lớp statement            
            ResultSet rs = stt.executeQuery("SELECT * FROM student where maSinhVien =" );
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
       
        StudentModel model = new StudentModel();
//        model.getList();
        int id = 0;
        model.getByID(1);
        model.searchByName("Thao");
        model.checkExistRollNumber("123");
    }
    
}
