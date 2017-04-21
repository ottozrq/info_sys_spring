package com.ottozhang.ism.dataModel;

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
    }

    public Identity(String name, String displayname, String password, String email) {
        this.name = name;
        this.displayname = displayname;
        this.password = password;
        this.email = email;
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
