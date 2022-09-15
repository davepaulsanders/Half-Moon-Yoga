package com.halfmoonyoga.studio.Student;

import javax.persistence.*;
import java.util.Arrays;
import java.util.UUID;


@Entity
public class Student {

    @Id
    @GeneratedValue
    private UUID studentId;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String photo;
    private String aboutMe;
    private int[] futureClasses;
    private int[] pastClasses;

    public Student() {

    }

    public Student(String name, String photo, String aboutMe, int[] futureClasses, int[] pastClasses) {
        this.studentId = UUID.randomUUID();
        this.name = name;
        this.photo = photo;
        this.aboutMe = aboutMe;
        this.futureClasses = futureClasses;
        this.pastClasses = pastClasses;
    }

    public UUID getStudentId() {
        return studentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int[] getFutureClasses() {
        return futureClasses;
    }

    public void setFutureClasses(int[] futureClasses) {
        this.futureClasses = futureClasses;
    }

    public int[] getPastClasses() {
        return pastClasses;
    }

    public void setPastClasses(int[] pastClasses) {
        this.pastClasses = pastClasses;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", futureClasses=" + Arrays.toString(futureClasses) +
                ", pastClasses=" + Arrays.toString(pastClasses) +
                '}';
    }
}
