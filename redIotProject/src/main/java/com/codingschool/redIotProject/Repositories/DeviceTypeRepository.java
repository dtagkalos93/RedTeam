package com.codingschool.redIotProject.Repositories;

import com.codingschool.redIotProject.Entities.DeviceType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceTypeRepository extends JpaRepository<DeviceType,Long> {
	
	DeviceType findByTypeName(String typeName);

}
