package com.ottozhang.ism.dataModel;

/**
 * Created by zhangruoqiu on 2017/4/20.
 */
public class Identity {
    public Identity(){
        id = 0;
        name = "";
        displayname = "";
        password = "";
        email = "";
    }

    private Integer id;
    private String name;
    private String displayname;
    private String password;
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
}
