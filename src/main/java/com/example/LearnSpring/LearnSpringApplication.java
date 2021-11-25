package com.example.LearnSpring;

import com.example.LearnSpring.data.entity.Guest;
import com.example.LearnSpring.data.entity.Reservation;
import com.example.LearnSpring.data.entity.Room;
import com.example.LearnSpring.data.repository.GuestRepository;
import com.example.LearnSpring.data.repository.ReservationRepository;
import com.example.LearnSpring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringApplication.class, args);
	}


}
