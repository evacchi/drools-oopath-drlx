package org.kie.examples;

import java.util.List;

public class Plan {

    private final List<Exam> exams;

    public Plan(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Exam> getExams() {
        return exams;
    }
}
