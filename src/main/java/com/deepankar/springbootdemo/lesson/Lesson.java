package com.deepankar.springbootdemo.lesson;

import com.deepankar.springbootdemo.course.Course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lesson {
    private String name;
    @Id
    private String id;
    private String description;
    @ManyToOne
    private Course course;

    public Lesson(){}

    public Lesson (String name, String id, String description, String courseId) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.course =  new Course (courseId, "", "", "");
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Course getCourse () {
        return course;
    }

    public void setCourse (Course course) {
        this.course = course;
    }
}
