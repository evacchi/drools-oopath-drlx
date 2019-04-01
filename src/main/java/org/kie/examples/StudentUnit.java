package org.kie.examples;

public class StudentUnit {

    DataSource<Student> students;
    DataSource<University> universities;

    @OOPath("/students[ name != 'paul' ]")
    public void nameIsNotPaul(Student s) {
        System.out.printf("Hello %s, age %d", s.getName(), s.getAge());
    }

    @OOPath("/students/plan/exams[ course == 'Big Data' ]/grade")
    public void allGradesForBigData(Student s, Grade g) {
        System.out.printf("Student %s scored %d in Big Data", s.getName(), g.getResult());
    }

    @OOPath("/students/plan/exams[ course == 'Big Data' ]/grade[ result < 18 ]")
    public void removeBadStudents(Student s) {
        // insert, updates, removes are done on the datasources (working memory)
        // which are fields of the class/unit
        students.remove(s);
    }

    // two proposed syntaxes for joins
    // 1)
    @OOPath("/students/university")
    @OOPath("/universities[ name == $uname ]")
    public void allUniversitiesAlt(
            String uname,
            University u) {
        System.out.println(u.getName());
    }

    // 2)
    // notice that here bindings are on the params
    public void allUniversities(
            @OOPath("/students/university")
                    String uname,
            @OOPath("/universities[ name == $uname ]")
                    University u) {
        System.out.println(u.getName());
    }

}
