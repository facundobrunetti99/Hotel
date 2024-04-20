package com.dailycodework.lakeSidehotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;//nombre del que reserve
    private String guestEmail;

    private int numberOfAdults;//Cantidad de adultos que vienen
    private int numberOfChildren;
    private int totalNumberOfGuest;//cantidad total de invitados
    private String BookingConfimationCode;//Este es el codigo de confirmacion de reserva
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private  Room room;
    //Ahora crearemos un metodo para calcular el numero total de invitados


    public void calculatedTotalNumberOfGuest(){
        this.totalNumberOfGuest=this.numberOfAdults+this.numberOfChildren;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
        calculatedTotalNumberOfGuest();
        /*Aplicamos este metodo porque cada vez que la persona agregue un niño o adulto
        la cantidad total se calculara solo*/
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
        calculatedTotalNumberOfGuest();
    }
}
