package com.dailycodework.lakeSidehotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType;
    private BigDecimal roomPrice;
    private Boolean isBooked = false;

    @Lob
    private Blob photoRoom;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    /*Este cascade nos permite que si elimnamos todo
     lo que tiene que ver con una habitacion tambien se eliminara la reserva de la misma lo mismo con actualizar una
     habitacion*/
    private List<BookedRoom> bookings;//Creo una lista de habitaciones reservadas, llamada reservas
    public Room() {
        this.bookings=new ArrayList<>();
    }

    public void addBooking(BookedRoom booking){
        /*Ahora debo añadir una reserva(booking) a mis reservas(bookings)*/
            if(bookings == null){
                bookings=new ArrayList<>();
            }
            bookings.add(booking);//Agrego una reserva a las reservas
            booking.setRoom(this);//Actualizo en reservas esta habitacion
            //Aca lo que hago es entrelazar los bookedRoom con Room
            //Una vez creada la reserva debo cambiar el estado de la habitacion
            isBooked=true;
            //Y ademas debo agregar el codigo que se genera de confirmacion de habitacion
            String bookingCode= RandomStringUtils.randomNumeric(10);
            booking.setBookingConfimationCode(bookingCode);
    }

}
