package com.codingschool.redIotProject.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;

import javax.persistence.OneToMany;

@Entity
@Table(name="ROLE")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLE_ID")
    private long id;
    @Column(name="ROLE_NAME")
    private String role;
    
    @OneToMany(mappedBy="role")
    private List<User> users;

	public Role() {
    }
	
    public Role( String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
