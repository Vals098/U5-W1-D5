package valeriafarinosi.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import valeriafarinosi.U5_W1_D5.entities.Booking;
import valeriafarinosi.U5_W1_D5.entities.Building;
import valeriafarinosi.U5_W1_D5.entities.User;
import valeriafarinosi.U5_W1_D5.entities.Workstation;
import valeriafarinosi.U5_W1_D5.enums.WS_TYPE;
import valeriafarinosi.U5_W1_D5.exceptions.NotFoundException;
import valeriafarinosi.U5_W1_D5.exceptions.TakenValueException;
import valeriafarinosi.U5_W1_D5.repositories.BookingRepository;
import valeriafarinosi.U5_W1_D5.repositories.BuildingRepository;
import valeriafarinosi.U5_W1_D5.repositories.UserRepository;
import valeriafarinosi.U5_W1_D5.repositories.WorkstationRepository;

import java.util.List;

@Service
@Slf4j
public class BookingService {

    //    Repositories DI
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final WorkstationRepository workstationRepository;
    private final BuildingRepository buildingRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, WorkstationRepository workstationRepository, BuildingRepository buildingRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.workstationRepository = workstationRepository;
        this.buildingRepository = buildingRepository;
    }

    //    USERS METHODS
//    SAVE
    public void save(User newUser) {
//        username is unique
        if (this.userRepository.existsByUsername(newUser.getUsername()))
            throw new TakenValueException("The username " + newUser.getUsername() + " is already taken!");
//        email is unique
        if (this.userRepository.existsByEmail(newUser.getEmail()))
            throw new TakenValueException("The email " + newUser.getEmail() + " is already taken!");

        userRepository.save(newUser);

        log.info("The user " + newUser.getName() + " has been saved!");
    }

    //    FINDBYUSERNAME
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("No user with username: " + username + " has been found."));
    }

    //    BUILDINGS METHODS
//    SAVE
    public void save(Building newBuilding) {
// name is unique
        if (this.buildingRepository.existsByName(newBuilding.getName()))
            throw new TakenValueException("The building name " + newBuilding.getName() + " is already taken!");


        buildingRepository.save(newBuilding);

        log.info("The building " + newBuilding.getName() + " has been saved!");
    }

    //    FINDBYNAME
    public Building findBuildingByName(String name) {
        return buildingRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("No building with name: " + name + " has been found."));
    }

    //    WORKSTATIONS METHODS
//    SAVE
    public void save(Workstation newWorkstation) {
//        WScode is unique
        if (this.workstationRepository.existsByWSCode(newWorkstation.getWSCode()))
            throw new TakenValueException("A workstation with code " + newWorkstation.getWSCode() + " already exists!");


        workstationRepository.save(newWorkstation);

        log.info("The workstation " + newWorkstation.getWSCode() + " has been saved!");
    }

    //    FINDBYWSCODE
    public Workstation findWorkstationByWSCode(String WSCode) {
        return workstationRepository.findByWSCode(WSCode)
                .orElseThrow(() -> new NotFoundException("No workspace with code: " + WSCode + " has been found."));
    }

    //    FINDBYWSTYPEANDCITY
    public List<Workstation> findWorkstationByWSTypeAndCity(WS_TYPE WSType, String city) {
        List<Workstation> workstations = workstationRepository.findByWSTypeAndCity(WSType, city);

        if (workstations.isEmpty()) {
            throw new NotFoundException(
                    "No workspaces of type " + WSType + " in " + city + " have been found.");
        }

        return workstations;
    }


    //    BOOKINGS METHODS
//    SAVE
    public void save(Booking newBooking) {
//no other bookings with the same workspace and date
        if (this.bookingRepository.existsByBookingDateAndWorkstation(newBooking.getBookingDate(), newBooking.getWorkstation()))
            throw new TakenValueException("The workstation " + newBooking.getWorkstation().getWSCode() + " you requested is already booked for the date " + newBooking.getBookingDate());
//a single user can't book more than once on the same date. Verified
        if (this.bookingRepository.existsByBookingDateAndUser(newBooking.getBookingDate(), newBooking.getUser()))
            throw new TakenValueException("Dear user " + newBooking.getUser().getName() + " you already have a booking under your name for the day " + newBooking.getBookingDate());
//nMaxOccupants and actual partecipants control missing

        bookingRepository.save(newBooking);

        log.info("Thank you " + newBooking.getUser().getName() + "! The booking for the workspace " + newBooking.getWorkstation().getWSCode() + " for the day " + newBooking.getBookingDate() + " has been saved!");
    }

//    metodo di prima, sono costretto ad usare un metodo(findBy) prima di usare il mio metodo
//    sempre, mentre se facciamo così:
//    public void savePrenotazione(UUID userId, UUID workstationId, LocalDate data){}
//    uso un solo metodo,
//    utilizzabile in più punti del codice e non ha bisogno di una prenotazione già costruita
//    più facilmente usabili e riutilizzabili possibie
//    così creo la prenotazione dentro il metodo e non serve creare prima la prenotazione
//    ragiona su chi dovrà usare il metodo

}
