package com.codingschool.redIotProject;

import com.codingschool.redIotProject.Entities.*;
import com.codingschool.redIotProject.Repositories.DeviceRepository;
import com.codingschool.redIotProject.Repositories.UserRepository;
import com.codingschool.redIotProject.Repositories.RoomRepository;
import com.codingschool.redIotProject.Repositories.DeviceTypeRepository;
import com.codingschool.redIotProject.Repositories.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication

public class RedIotProjectApplication {

	public static void main(String[] args) {
		run(RedIotProjectApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init (UserRepository userRepository, DeviceRepository deviceRepository , RoomRepository roomRepository, DeviceTypeRepository devicetypeRepository, RoleRepository roleRepository ){
		return args -> {
			
			//PersonaRepository
			Role admin = new Role ("ADMIN");
			Role user = new Role ("USER");
			roleRepository.save(admin);
			roleRepository.save(user);
			
			userRepository.save(new User("vbalioukos","Vassilis","Balioukos","vbalioukos@gmail.com","123456",roleRepository.findByRole("ADMIN")));
			userRepository.save(new User("dtagkalos","Dimitris","Tagkalos","kobe@bryant.com","123456",roleRepository.findByRole("ADMIN")));
			userRepository.save(new User("atasios","Aris","Tasios","lebron@james.com","123456",roleRepository.findByRole("USER")));
			userRepository.save(new User("EllePpl","Eleni","Pipeli","mike@jordan.com","123456",roleRepository.findByRole("USER")));
			//RoomRepository
			Room l=new Room("Living Room");
			
			//DeviceTypeRepository
			DeviceType airco = new DeviceType("Air Condition");
			//Device d1 = new Device("Lionnel Messi",false,"",airco,l);
			
			
			//List<Device> devices = new ArrayList<>();
			//devices.add(d1);
			//airco.setDevices(devices);
			//l.setDevices(devices);
			
			
			DeviceType lights = new DeviceType("Lights");
			DeviceType tv = new DeviceType("TV");
			DeviceType coffeemaker = new DeviceType("Coffee Maker");
			DeviceType cooker = new DeviceType("Cooker");
			DeviceType washmachine = new DeviceType("Wash Machine");
			DeviceType tent = new DeviceType("Tent");
			DeviceType door = new DeviceType("Door");
			devicetypeRepository.save(airco);
			devicetypeRepository.save(lights);
			devicetypeRepository.save(tv);
			devicetypeRepository.save(coffeemaker);
			devicetypeRepository.save(washmachine);
			devicetypeRepository.save(tent);
			devicetypeRepository.save(door);
			devicetypeRepository.save(cooker);
			
	
			Room k=new Room("Kitchen");
			Room b=new Room("Bedroom");
			Room ba=new Room("Bathroom");
			Room bal=new Room("Balcony");
			Room g=new Room("Garage");
			
			roomRepository.save(l);
			roomRepository.save(k);
			roomRepository.save(b);
			roomRepository.save(ba);
			roomRepository.save(bal);
			roomRepository.save(g);

			//DeviceRepository
			
			Device d1 = new Device("Living Room TV",false,"",devicetypeRepository.findByTypeName("TV"),roomRepository.findByName("Living Room"));
			Device d2 = new Device("Kitchen Lights",false,"",devicetypeRepository.findByTypeName("Lights"),roomRepository.findByName("Kitchen"));
			Device d4 = new Device("Kitchen Cooker",false,"",devicetypeRepository.findByTypeName("Cooker"),roomRepository.findByName("Kitchen"));
			Device d5 = new Device("Bedroom Lights",false,"",devicetypeRepository.findByTypeName("Lights"),roomRepository.findByName("Bedroom"));
			Device d6 = new Device("Bedroom Airco",false,"",devicetypeRepository.findByTypeName("Air Condition"),roomRepository.findByName("Bedroom"));
			Device d3 = new Device("Living Room Airco",false,"",devicetypeRepository.findByTypeName("Air Condition"),roomRepository.findByName("Living Room"));
			Device d7 = new Device("Bedroom Airco",false,"",devicetypeRepository.findByTypeName("Air Condition"),roomRepository.findByName("Bedroom"));
			Device d8 = new Device("Kitchen Coffee Maker",false,"",devicetypeRepository.findByTypeName("Coffee Maker"),roomRepository.findByName("Kitchen"));
			Device d9 = new Device("Garage Door",false,"",devicetypeRepository.findByTypeName("Door"),roomRepository.findByName("Garage"));
			Device d10 = new Device("Balcony Tent",false,"",devicetypeRepository.findByTypeName("Tent"),roomRepository.findByName("Balcony"));
			
			deviceRepository.save(d1);
			deviceRepository.save(d2);
			deviceRepository.save(d3);
			deviceRepository.save(d4);
			deviceRepository.save(d5);
			deviceRepository.save(d6);
			deviceRepository.save(d7);
			deviceRepository.save(d8);
			deviceRepository.save(d9);
			deviceRepository.save(d10);
			//deviceRepository.save(new Device("Lionnel Messi",false,"",devicetypeRepository.findByTypeName("Aircondition"),roomRepository.findByName("Living Room")));
			//deviceRepository.save(new Device("Cristiano Ronaldo",true,"",light,b));
			//deviceRepository.save(new Device("Dele Ali",true,"channel-CosmoteSports1,vol-15",tv,l));

			//Check if Everything store in h2 db
			userRepository.findAll().forEach(x->System.out.println(x.getId()+" :: "+x.getName()+" "+ x.getSurname()+" " + x.getMail() +" " +x.getPassword()));
			//deviceRepository.findAll().forEach(x->System.out.println(x.getId()+" :: "+x.getName()+" "+ " " +x.getInformation() + " " + x.getDevicetype().getTypeName()));
			roomRepository.findAll().forEach(x->System.out.println(x.getId()+" :: "+x.getName()));
			devicetypeRepository.findAll().forEach(x->System.out.println(x.getId()+" :: "+x.getTypeName()));
			System.out.println(devicetypeRepository.findByTypeName("Air Condition").getTypeName());
			System.out.println(devicetypeRepository.findByTypeName("Air Condition").getId());
			System.out.println("device type of lionel messi: "+d1.getDeviceType().getTypeName());
		};



	}
}
