package com.learn.struts.action;

import com.learn.struts.demain.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author songshuiyang
 * @title:
 * @description:
 * @date 2017/9/16 20:41
 */
public class LoginAction extends ActionSupport {
    public String Name;
    public int Age;
    public User user;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        return "success";
    }
}
