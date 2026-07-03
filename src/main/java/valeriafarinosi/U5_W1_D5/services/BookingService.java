package valeriafarinosi.U5_W1_D5.services;

import org.springframework.stereotype.Service;
import valeriafarinosi.U5_W1_D5.repositories.BookingRepository;
import valeriafarinosi.U5_W1_D5.repositories.BuildingRepository;
import valeriafarinosi.U5_W1_D5.repositories.UserRepository;
import valeriafarinosi.U5_W1_D5.repositories.WorkstationRepository;

@Service
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


}
