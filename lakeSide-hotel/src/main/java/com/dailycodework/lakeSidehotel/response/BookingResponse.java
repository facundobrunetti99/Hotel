package com.dailycodework.lakeSidehotel.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingResponse {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestEmail;
    private int numberOfAdults;
    private int numberOfChildren;
    private int totalNumberOfGuest;
    private String BookingConfimationCode;

    public BookingResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate,
            String bookingConfimationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        BookingConfimationCode = bookingConfimationCode;
    }

}
