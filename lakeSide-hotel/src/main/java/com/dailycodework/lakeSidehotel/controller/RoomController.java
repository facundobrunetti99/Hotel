package com.dailycodework.lakeSidehotel.controller;

import com.dailycodework.lakeSidehotel.model.Room;
import com.dailycodework.lakeSidehotel.response.RoomResponse;
import com.dailycodework.lakeSidehotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    public final IRoomService roomService;
    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
          @RequestParam("photo") MultipartFile photo,
          @RequestParam("roomType")  String RoomType,
          @RequestParam("roomPrice") BigDecimal RoomPrice ){
        Room savedRoom=roomService.addNewRoom(photo,RoomType,RoomPrice);
        RoomResponse response=new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }

    {

    }


}
