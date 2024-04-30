package com.dailycodework.lakeSidehotel.response;

import com.dailycodework.lakeSidehotel.model.BookedRoom;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;

import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {

    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private Boolean isBooked = false;
    @Lob
    private String photoRoom;

    private List<BookingResponse> bookings;

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice,
                        Boolean isBooked, byte[] photoBytes, List<BookingResponse> bookings) {

        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.photoRoom = photoBytes != null ? Base64.encodeBase64String(photoBytes):null;
        this.bookings = bookings;
        /*Importante aclarar que aca lo que hago es transformar este photBytes en
        * En string y asignarselo a bookings para poder establecer el url de la foto
        * */
    }

    


}
