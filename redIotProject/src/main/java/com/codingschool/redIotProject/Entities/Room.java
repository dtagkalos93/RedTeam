package com.codingschool.redIotProject.Entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="ROOM")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROOM_ID")
    private long id;
    @Column(name="NAME")
    private String name;
    
    
    @OneToMany(mappedBy="room")
    private List<Device> devices;

	public Room() {
    }

    public Room( String name) {

        this.name = name;
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
    
    
    public List<Device> getDevices() {
		return devices;
	}
    
    
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
}
