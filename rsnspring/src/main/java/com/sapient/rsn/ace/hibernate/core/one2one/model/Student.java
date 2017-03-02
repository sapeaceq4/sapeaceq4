package com.sapient.rsn.ace.hibernate.core.one2one.model;

import javax.persistence.*;

/**
 * Created by Ravdeep Singh on 3/2/2017.
 */
public class Student {
    private long studentId;
    private String studentName;
    private Address studentAddress;

    public Student() {
    }

    public Student(String studentName, Address studentAddress) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Column(name = "STUDENT_NAME", nullable = false, length = 100)
    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Address getStudentAddress() {
        return this.studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }
}
