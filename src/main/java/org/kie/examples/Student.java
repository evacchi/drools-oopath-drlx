package org.kie.examples;

public class Student {
    private final String name;
    private final int age;
    private final String university;
    private final Plan plan;

    public Student(String name, int age, String university, Plan plan) {
        this.name = name;
        this.age = age;
        this.university = university;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUniversity() {
        return university;
    }

    public Plan getPlan() {
        return plan;
    }
}
