package com.company.functionalinterfaces;

class Student implements Comparable {

  String name;

  public Student(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Object o) {
    return this.name.equals(((Student) o).name) ? 1 : 0;
  }
}

public class Demo1 {
  public static void main(String[] args) {
    Student s1 = new Student("ravi");
    Student s2 = new Student("ravi");
    System.out.println(s1.compareTo(s2));

    Comparable<Student> comparable = (s) -> s.name.length() > 4 ? 1 : 0;
    int nakul = comparable.compareTo(new Student("nakul"));
    int sun = comparable.compareTo(new Student("sun"));
    System.out.println(nakul);
    System.out.println(sun);

  }
}
