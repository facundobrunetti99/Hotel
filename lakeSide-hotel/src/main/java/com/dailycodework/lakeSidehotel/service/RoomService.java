package com.dailycodework.lakeSidehotel.service;

import com.dailycodework.lakeSidehotel.model.Room;
import com.dailycodework.lakeSidehotel.repository.RoomRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.rowset.serial.SerialBlob;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService{
    private final RoomRepository roomRepository;
    @SneakyThrows
    @Override
    public Room addNewRoom(MultipartFile photo, String RoomType, BigDecimal RoomPrice){
        Room room=new Room();
        room.setRoomType(RoomType);
        room.setRoomPrice(RoomPrice);
        if(!photo.isEmpty()){
            byte [] photoByte=photo.getBytes();
            Blob photoLob= new SerialBlob(photoByte);
            room.setPhotoRoom(photoLob);
        }
    return  roomRepository.save(room);
    }
    @Override
    public List<String> getAllRoomTypes() {
        return roomRepository.findDistinctRoomTypes();
    }

}
