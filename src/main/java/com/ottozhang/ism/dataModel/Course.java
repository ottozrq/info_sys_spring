package com.ottozhang.ism.dataModel;

import javax.persistence.*;

/**
 * Created by zhangruoqiu on 2017/5/1.
 */
@Entity
@Table(name="tbl_courses")
public class Course {
    public Course(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatet() {
        return datet;
    }

    public void setDatet(String datat) {
        this.datet = datat;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGroyps() {
        return groups;
    }

    public void setGroyps(String groups) {
        this.groups = groups;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "datet")
    private String datet;
    @Column(name = "duration")
    private String duration;
    @Column(name = "room")
    private String room;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "groups")
    private String groups;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", datat='" + datet + '\'' +
                ", duration='" + duration + '\'' +
                ", room='" + room + '\'' +
                ", teacher='" + teacher + '\'' +
                ", groups='" + groups + '\'' +
                '}';
    }
}
