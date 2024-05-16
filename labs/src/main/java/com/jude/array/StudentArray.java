package com.jude.array;

import com.jude.Student;

import java.util.Arrays;
import java.util.Objects;

public class StudentArray {
    private final Student[] students;
    public StudentArray(){
        this( 10);
    }

    public StudentArray(int capacity){
       this.students = new Student[capacity];
    }
    private byte counter = 0;


    public void add(Student student){
        if(counter > 3){
          System.out.println("Student List is full");
          return;
        }
        students[counter] = student;
        if(counter < this.students.length-1){
            this.counter++;
        }
    }

    public Student search(String name){
        for (Student student : students) {
            if (student!=null && student.name().equals(name)) {
                return student;
            }
        }
        return null;
    }
    public Student delete(String name){
        for (byte i =0; i<this.students.length; i++) {
            if (this.students[i]!=null && students[i].name().equals(name)) {
                final Student deletedStudent = this.students[i];
                reArrangeArrayOnDelete(i);
                counter--;
                return  deletedStudent;
            }
        }
        return null;
    }

    public  void display(){
        System.out.println(Arrays.toString(this.students));
    }

    private void reArrangeArrayOnDelete(byte index){
        for(byte i = index; i<this.students.length-1; i++ ){
            this.students[i] = this.students[i+1];
        }
        this.students[this.counter] = null;
    }
}
