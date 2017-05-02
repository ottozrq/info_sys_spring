package com.ottozhang.ism.dataModel;

import com.mysql.cj.x.json.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;

/**
 * Created by zhangruoqiu on 2017/4/20.
 */
@Entity
@Table(name="tbl_user")
public class Identity {
    public Identity(){
        id = 0;
        name = "";
        displayname = "";
        password = "";
        email = "";
        courses = "[]";
    }

    public Identity(String name, String displayname, String password, String email) {
        this.name = name;
        this.displayname = displayname;
        this.password = password;
        this.email = email;
        courses = "[]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "displayname")
    private String displayname;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "courses")
    private String courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void addCourse(String course){
        JSONArray js = null;
        if (this.courses.equals("[]")) {
            js = new JSONArray();
        } else {
            js = new JSONArray(this.courses);
        }
        JSONObject jo = new JSONObject(course);
        js.put(jo);
        this.courses = js.toString();
    }

    public void deleteCourse(String course){
        JSONArray js = new JSONArray(this.courses);
        for (int i = 0; i < js.length(); i++){
            if (js.get(i).toString().equals(course))
                js.remove(i);
        }
        this.courses = js.toString();
    }


    @Override
    public String toString() {
        return "Identity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayname='" + displayname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
