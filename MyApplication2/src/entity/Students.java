/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Students {
    private int thao;
    private int id;
    private String name;
    private String phone;
    private String address;
    private String rollNumber;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void printInfo() {
        System.out.println("Name is " + this.name + ",ID is " + this.id + ",Phone is " + this.phone + ",Address is " + this.address + ",rollnumber is " + this.rollNumber);
    }
    
    public boolean isValid() {
        if (name == null || name.length() <= 7) {
            return false;
        }
//        if (rollNumber == null || rollNumber.length() != 8) {
//            return false;
//        }
//        if (phone == null || phone.length() != 11) {
//            return false;
//        }
//        if (address.length() == 0 || address == null) {
//            return false;
//        }
        return true;
    }

    public Students(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Students(int id, String name, String rollNumber) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Students() {
    }

}
