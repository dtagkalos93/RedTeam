package com.codingschool.redIotProject.Repositories;

import com.codingschool.redIotProject.Entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    List<Device> findByName(String name);
    List<Device> findAll();
    List<Device> findByNameContaining(String searchterm);
    Device findById(long id);
    List<Device> findByRoomName(String roomname);
    List<Device> findByRoomId(Long roomid);
    void deleteById(long id);
}
