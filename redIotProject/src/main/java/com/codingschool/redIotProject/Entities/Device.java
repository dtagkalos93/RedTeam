package com.codingschool.redIotProject.Entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Table(name="DEVICE")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEVICE_ID")
    private long id;
    @ManyToMany(mappedBy="devices")
    private List<User> users;
    @Column(name="NAME")
    private String name;
    @Column(name="STATUS")
    private boolean status;
    @Column(name="INFORMATION")
    private String information;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ROOM_ID")
    private Room room;
    
    @ManyToOne
    @JoinColumn(name="DEVICE_TYPE_ID")
    private DeviceType deviceType;

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Device() {
    }

    public Device( String name, boolean status, String information, DeviceType type, Room room) {
        this.name = name;
        this.status = status;
        this.information = information;
        this.deviceType = type;
        this.room = room;
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


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    
    @JsonIgnore
    public Room getRoom() {
		return room;
	}

    @JsonProperty
	public void setRoom(Room room) {
		this.room = room;
	}


}
