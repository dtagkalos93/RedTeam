package com.codingschool.redIotProject.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PERSON_ID")
    private long id;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="person_device", joinColumns=@JoinColumn(name="device_id"), inverseJoinColumns=@JoinColumn(name="person_id"))
    private List<Device> devices;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PERSON_NAME")
    private String name;
    @Column(name="SURNAME")
    private String surname;
    @Column(name="MAIL")
    private String mail;
    @Column(name="PASSWORD")
    private String password;
    //@Column(name="ROLE")
    //private String role;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private Role role;
    
	public User() {

    }



    public User(String username, String name, String surname, String mail, String password, Role role) {
	    this.username = username;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        //this.role=new Role(role);
        //this.role.setRole(role);
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public Role getRole() {
		return role;
	}
    
    @JsonIgnore
    public String getRoleToString() {
    	return role.getRole();
    }

	@JsonProperty
	public void setRole(Role role) {
		this.role = role;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
