package com.codingschool.redIotProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;


@Entity
@Table(name="DEVICE_TYPE")
public class DeviceType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEVICE_TYPE_ID")
    private long id;
    @Column(name="DEVICE_TYPE_NAME")
    private String typeName;
    
    @OneToMany(mappedBy="deviceType")
    private List<Device> devices;

	public DeviceType() {
    }

    public DeviceType( String typeName) {
        this.typeName = typeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @JsonIgnore
    public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
    
}
