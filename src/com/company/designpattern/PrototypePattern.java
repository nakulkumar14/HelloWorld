package com.company.designpattern;

import java.util.ArrayList;
import java.util.List;

class Student implements Cloneable {

  private List<String> subjects;
  private String name;

  public Student(List<String> subjects, String name) {
    this.subjects = subjects;
    this.name = name;
  }

  public List<String> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<String> subjects) {
    this.subjects = subjects;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    List<String> list = new ArrayList<>(subjects);
    return new Student(list, this.name);
  }

  @Override
  public String toString() {
    return "Student{" +
        "subjects=" + subjects +
        ", name='" + name + '\'' +
        '}';
  }
}

public class PrototypePattern {
  public static void main(String[] args) throws CloneNotSupportedException {
    Student student1 = new Student(List.of("english", "maths"), "s1");
    Student student2 = (Student) student1.clone();
    System.out.println("student1 : " + student1);
    System.out.println("student2 : " + student2);
    System.out.println(student1 == student2);
  }
}
