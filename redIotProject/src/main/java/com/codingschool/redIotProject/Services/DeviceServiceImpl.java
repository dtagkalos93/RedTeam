package com.codingschool.redIotProject.Services;

import com.codingschool.redIotProject.Entities.Device;
import com.codingschool.redIotProject.Repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceRepository deviceRep;


    @Override
    public List<Device> findByName(String name){
        return deviceRep.findByName(name);
    }

    @Override
    public List<Device> findAll(){


        return deviceRep.findAll();
    }

    @Override
    public List<Device> findByNameContaining(String searchterm){
        return deviceRep.findByNameContaining(searchterm);
    }

    @Override
    public Device findById(long id) {
        return deviceRep.findById(id);
    }

    @Override
    public Device save(Device d) {
        return deviceRep.save(d);
    }
    
    @Override
    public Device changeStatus (Device newDevice, long id) {
    	
    	Device currentDevice = deviceRep.findById(id);
    	currentDevice.setStatus(newDevice.isStatus());
    	return deviceRep.save(currentDevice);
    
    }

    @Override
    public void deleteById(long id){ deviceRep.deleteById(id);}


    /*@Override
    public Device turnOn (Device d) {
    	d.setStatus(true);
    	return deviceRep.save(d);
    	
    }
    
    @Override
    public Device switchOff (Device d) {
    	d.setStatus(false);
    	return deviceRep.save(d);
    }*/
}
