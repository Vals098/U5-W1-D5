package valeriafarinosi.U5_W1_D5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import valeriafarinosi.U5_W1_D5.entities.Building;
import valeriafarinosi.U5_W1_D5.entities.User;
import valeriafarinosi.U5_W1_D5.entities.Workstation;
import valeriafarinosi.U5_W1_D5.exceptions.TakenValueException;
import valeriafarinosi.U5_W1_D5.repositories.BookingRepository;
import valeriafarinosi.U5_W1_D5.repositories.BuildingRepository;
import valeriafarinosi.U5_W1_D5.repositories.UserRepository;
import valeriafarinosi.U5_W1_D5.repositories.WorkstationRepository;

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
        if (this.userRepository.existsByUsername(newUser.getUsername()))
            throw new TakenValueException("The username " + newUser.getUsername() + " is already taken!");
        if (this.userRepository.existsByEmail(newUser.getEmail()))
            throw new TakenValueException("The email " + newUser.getEmail() + " is already taken!");

        userRepository.save(newUser);

        log.info("The user " + newUser.getName() + " has been saved!");
    }

    //    BUILDINGS METHODS
//    SAVE
    public void save(Building newBuilding) {
        buildingRepository.save(newBuilding);
    }

    //    WORKSTATIONS METHODS
//    SAVE
    public void save(Workstation newWorkstation) {
        workstationRepository.save(newWorkstation);
    }

//    BOOKINGS METHODS


}
