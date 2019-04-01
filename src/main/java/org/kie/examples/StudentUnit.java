package org.kie.examples;

/**
 * A "pure-Java", OOPath-centric alternative to DRLX.
 * Use of annotations makes it potentially available to other JVM languages
 * such as Scala, Kotlin.
 * <p>
 * Class fields (or accessors?) define the working memory of the Unit
 * Annotated methods define **rules**. The RHS is the method body,
 * the annotation defines the predicate(s), similarly to how JAX-RS annotations
 * define a REST endpoint.
 * <p>
 * This is not intended as a complete replacement to "regular" DRL, but
 * it's a new, Java-friendly notation that simplifies a bit our current language
 * with a smallish DSL.
 * <p>
 * Other pros: potentially free debugger support.
 */
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

    @OOPath("/students/plan/exams[ course == 'Big Data' ]/grade[ result < 18 ]")
    public void corrupt(@Modify({"result", "laude"}) Grade g) {
        g.setResult(30);
        g.setLaude();
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
