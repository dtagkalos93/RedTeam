package com.codingschool.redIotProject.Services;

import com.codingschool.redIotProject.Entities.Room;
import java.util.List;


public interface RoomService {
	List<Room> findAll();
	Room findByName (String name);
	Room findById (long id);
//	void deleteById(long id);

}