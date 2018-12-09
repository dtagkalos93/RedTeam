package com.codingschool.redIotProject.Services;


import com.codingschool.redIotProject.Entities.Device;

import java.util.List;

public interface DeviceService {
    List<Device> findByName(String name);
    List<Device> findAll();
    List<Device> findByNameContaining(String searchterm);
    Device findById(long id);
    Device save(Device d);
    Device changeStatus (Device newDevice, long id);
    //Device turnOn (Device d);
    //Device switchOff (Device d);
    void deleteById(long id);

}
