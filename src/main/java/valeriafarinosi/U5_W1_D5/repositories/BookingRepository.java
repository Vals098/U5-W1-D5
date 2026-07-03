package valeriafarinosi.U5_W1_D5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valeriafarinosi.U5_W1_D5.entities.Booking;
import valeriafarinosi.U5_W1_D5.entities.User;
import valeriafarinosi.U5_W1_D5.entities.Workstation;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    boolean existsByBookingDateAndWorkstation(LocalDate bookingDate, Workstation workstation);

    boolean existsByBookingDateAndUser(LocalDate bookingDate, User user);
}
