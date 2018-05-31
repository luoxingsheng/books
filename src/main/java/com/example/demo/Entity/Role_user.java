package com.example.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role_user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int user_id;
private int role_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Role_user() {
    }

    public Role_user(int id, int user_id, int role_id) {
        this.id = id;
        this.user_id = user_id;
        this.role_id = role_id;
    }
}
