package com.SportManagement.landon.business.service;

import com.SportManagement.landon.business.domain.RoomReservation;
import com.SportManagement.landon.data.entity.Guest;
import com.SportManagement.landon.data.entity.Reservation;
import com.SportManagement.landon.data.entity.Room;
import com.SportManagement.landon.data.repository.GuestRepository;
import com.SportManagement.landon.data.repository.ReservationRepository;
import com.SportManagement.landon.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationService {
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String dateString){
        Date date = this.createDateFromDateString(dateString);
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room->{
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if(null!=reservations){
            reservations.forEach(reservation -> {
                Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestId());
//                if(null != guest){
                guest.ifPresent(guestt -> {
//                if(guest.isPresent()){
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                    roomReservation.setDate(date);
                    String firstName = guestt.getFirstName();
                    roomReservation.setFirstName(firstName);
//                    roomReservation.setFirstName(guest.flatMap(Guest::getFirstName).orElse("UNKNOWN"));
//                    roomReservation.setFirstName(guest.getFirstName()));
                    roomReservation.setLastName(guestt.getLastName());
                    roomReservation.setGuestId(guestt.getId());
//                }
                });
//                }
            });
        }
        List<RoomReservation> roomReservations = new ArrayList<>();
        for(Long roomId:roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }

    private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }
}
