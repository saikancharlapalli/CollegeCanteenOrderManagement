package com.canteen.entity;

public class Student {
    private int studentId;
    private String name;
    private String department;

    public Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Student [ID=" + studentId + ", Name=" + name + ", Dept=" + department + "]";
    }
}
