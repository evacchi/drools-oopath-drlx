package org.kie.examples;

public class Exam {
    private final String title;
    private Grade grade;

    public Exam(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
