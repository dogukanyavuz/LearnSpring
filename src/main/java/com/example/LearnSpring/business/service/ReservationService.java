package com.example.LearnSpring.business.service;

import com.example.LearnSpring.business.domain.RoomReservation;
import com.example.LearnSpring.data.entity.Guest;
import com.example.LearnSpring.data.entity.Reservation;
import com.example.LearnSpring.data.entity.Room;
import com.example.LearnSpring.data.repository.GuestRepository;
import com.example.LearnSpring.data.repository.ReservationRepository;
import com.example.LearnSpring.data.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;


    public List<RoomReservation> getRoomReservationsForDate(Date date)
    {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long,RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstnName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id: roomReservationMap.keySet())
        {
            roomReservations.add(roomReservationMap.get(id));
        }
        return roomReservations;
    }


}
