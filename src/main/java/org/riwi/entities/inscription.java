package org.riwi.entities;

public class inscription {
    private Integer id_Course;
    private Integer id_Student;

    public inscription() {
    }

    public inscription(Integer id_Course, Integer id_Student) {
        this.id_Course = id_Course;
        this.id_Student = id_Student;
    }

    public Integer getId_Course() {
        return id_Course;
    }

    public void setId_Course(Integer id_Course) {
        this.id_Course = id_Course;
    }

    public Integer getId_Student() {
        return id_Student;
    }

    public void setId_Student(Integer id_Student) {
        this.id_Student = id_Student;
    }

    @Override
    public String toString() {
        return "inscription{" +
                "id_Course=" + id_Course +
                ", id_Student=" + id_Student +
                '}';
    }
}
