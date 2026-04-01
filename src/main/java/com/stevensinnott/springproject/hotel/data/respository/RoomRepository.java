package com.stevensinnott.springproject.hotel.data.respository;

import com.stevensinnott.springproject.hotel.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
    Optional<Room> findAllByBedInfo(String befInfo);
    Optional<Room> findAllByName(String name);
}
