package com.dailycodework.lakeSidehotel.service;

import com.dailycodework.lakeSidehotel.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public interface IRoomService {

        Room addNewRoom(MultipartFile photo,String RoomType, BigDecimal RoomPrice);


}
