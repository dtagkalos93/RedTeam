package com.codingschool.redIotProject.Controllers;


import com.codingschool.redIotProject.Entities.Room;
import com.codingschool.redIotProject.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rooms")
public class RoomController {

	/*
    private RoomRepository repository;
    private RoomService roomService;

    public RoomController(RoomRepository repository, RoomService roomService) {
        this.repository = repository;
        this.roomService = roomService;
    }*/
	@Autowired
	private RoomService roomService;

	// returns all the rooms
	@GetMapping
	public List<Room> findAll(){
		return roomService.findAll();
	}

	// returns a room by id
	@GetMapping("/{id}")
	public Room findOne(@PathVariable long id) {
		return roomService.findById(id);
	}


//	// deletes a room by id-- does not work--
//	@DeleteMapping("/{id}")
//	public void deleteRoom(@PathVariable long id) {
//		roomService.deleteById(id);
//	}


}