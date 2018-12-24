package com.feng.array;

/**
 * @author: PMTY
 * @create: 2018-12-24 14:46
 **/
public class Student {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)",this.name,this.score);
    }

    public static void main(String[] args) {
        Student s1 = new Student("小明", 100);
        Student s2 = new Student("小红", 90);
        Student s3 = new Student("小北", 99);
        Array<Student> arr = new Array<>();
        arr.addLast(s1);
        arr.addLast(s2);
        arr.addLast(s3);
        System.out.println(arr);
    }
}