package valeriafarinosi.U5_W1_D5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import valeriafarinosi.U5_W1_D5.exceptions.DateNotValidException;
import valeriafarinosi.U5_W1_D5.exceptions.NotNullableException;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@Getter
@ToString
public class Booking {

    @Id
    @GeneratedValue
    private UUID bookingID;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ws_id", nullable = false)
    private Workstation workstation;

    public Booking(LocalDate bookingDate, User user, Workstation workstation) {
        setBookingDate(bookingDate);
        setUser(user);
        setWorkstation(workstation);
    }

    public void setBookingDate(LocalDate bookingDate) {
        if (bookingDate == null) {
            throw new NotNullableException("You must add a date for your booking.");
        }
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new DateNotValidException("\"The booking date cannot be before today's date.");
        }
        this.bookingDate = bookingDate;
    }

    public void setUser(User user) {
        if (user == null) {
            throw new NotNullableException("You must add a user for your booking.");
        }
        this.user = user;
    }

    public void setWorkstation(Workstation workstation) {
        if (workstation == null) {
            throw new NotNullableException("You must add a workstation for your booking.");
        }
        this.workstation = workstation;
    }
}
