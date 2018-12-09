package com.codingschool.redIotProject.Controllers;


import com.codingschool.redIotProject.Entities.Device;
import com.codingschool.redIotProject.Services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // returns all the devices
    @GetMapping
    public List<Device> findAll(){
        return deviceService.findAll();
    }

    // returns a device by id
    @GetMapping("/{id}")
    public Device findOne(@PathVariable long id) {
        return deviceService.findById(id);
    }

    // creates new device
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device create(@RequestBody Device d) {
        return deviceService.save(d);
    }

    // updates device-status found by id
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Device changeStatus(@RequestBody Device d, @PathVariable Long id) {
        return deviceService.changeStatus(d, id);
    }

    // deletes device by id
    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable long id) {
        deviceService.deleteById(id);
    }
    

}
