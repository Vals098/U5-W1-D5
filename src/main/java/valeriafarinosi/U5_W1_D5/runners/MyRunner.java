package valeriafarinosi.U5_W1_D5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import valeriafarinosi.U5_W1_D5.entities.Booking;
import valeriafarinosi.U5_W1_D5.entities.Building;
import valeriafarinosi.U5_W1_D5.entities.User;
import valeriafarinosi.U5_W1_D5.entities.Workstation;
import valeriafarinosi.U5_W1_D5.services.BookingService;

import java.time.LocalDate;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {

    //    Service's DI
    private final BookingService bookingService;
    //    context's DI
    private final ApplicationContext ctx;

    public MyRunner(BookingService bookingService, ApplicationContext ctx) {
        this.bookingService = bookingService;
        this.ctx = ctx;
    }

    @Override
    public void run(String... args) throws Exception {

//        ----------------------- FIRST DATA SAVE ----------------------------

//        USERS
//        User frodo = ctx.getBean("frodo", User.class);
//        User sam = ctx.getBean("sam", User.class);
//        User gandalf = ctx.getBean("gandalf", User.class);
//        User legolas = ctx.getBean("legolas", User.class);
//        User aragorn = ctx.getBean("aragorn", User.class);
//        User gimli = ctx.getBean("gimli", User.class);

//        bookingService.save(frodo);
//        bookingService.save(sam);
//        bookingService.save(gandalf);
//        bookingService.save(legolas);
//        bookingService.save(aragorn);
//        bookingService.save(gimli);

//        BUILDINGS
//        Building bagEndHub = ctx.getBean("bagEndHub", Building.class);
//        Building minasTirithHeadQuarters = ctx.getBean("minasTirithHeadQuarters", Building.class);
//        Building durinMountainOffice = ctx.getBean("durinMountainOffice", Building.class);

//        bookingService.save(bagEnd);
//        bookingService.save(minasTirithHeadQuarters);
//        bookingService.save(durinMountainOffice);

//        WORKSTATIONS
//        Workstation garden = ctx.getBean("garden", Workstation.class);
//        Workstation fireplace = ctx.getBean("fireplace", Workstation.class);
//        Workstation tower = ctx.getBean("tower", Workstation.class);
//        Workstation council = ctx.getBean("council", Workstation.class);
//        Workstation gondorWorkers = ctx.getBean("gondorWorkers", Workstation.class);
//        Workstation gardengeneeringWorkspaceen = ctx.getBean("engeneeringWorkspace", Workstation.class);
//        Workstation miningOpRoom = ctx.getBean("miningOpRoom", Workstation.class);

//        bookingService.save(garden);
//        bookingService.save(fireplace);
//        bookingService.save(tower);
//        bookingService.save(council);
//        bookingService.save(gondorWorkers);
//        bookingService.save(gardengeneeringWorkspaceen);
//        bookingService.save(miningOpRoom);


//        ---------------------------- DATA FROM DB --------------------------------------

//        USERS
        User frodo = bookingService.findUserByUsername("frodo.b");
        User sam = bookingService.findUserByUsername("samG");
        User gandalf = bookingService.findUserByUsername("gangre");
        User legolas = bookingService.findUserByUsername("leggre");
        User aragorn = bookingService.findUserByUsername("arag.ele");
        User gimli = bookingService.findUserByUsername("gimli.s");

//        BUILDINGS
        Building bagEndHub = bookingService.findBuildingByName("Bag End");
        Building minasTirithHeadQuarters = bookingService.findBuildingByName("Minas Tirith Citadel");
        Building durinMountainOffice = bookingService.findBuildingByName("Durin's Hall");

//        WORKSTATIONS
        Workstation garden = bookingService.findWorkstationByWSCode("GRDN");
        Workstation fireplace = bookingService.findWorkstationByWSCode("FRPLC");
        Workstation tower = bookingService.findWorkstationByWSCode("TWR");
        Workstation council = bookingService.findWorkstationByWSCode("CNCL");
        Workstation gondorWorkers = bookingService.findWorkstationByWSCode("GNDWK");
        Workstation gardengeneeringWorkspaceen = bookingService.findWorkstationByWSCode("GNDWK");
        Workstation miningOpRoom = bookingService.findWorkstationByWSCode("MNGOP");


//        ------------------------------------ BOOKINGS --------------------------------------

//        test with date before today. VERIFIED
//        Booking TestDateBeforeToday = new Booking(LocalDate.of(2025, 8, 21), frodo, garden);
        Booking bookingF1 = new Booking(LocalDate.of(2026, 8, 21), frodo, garden);
//        test with same date and same ws of an already existing booking.
        Booking TestSameDateSameWS = new Booking(LocalDate.of(2026, 8, 21), frodo, garden);


//        SAVE BOOKINGS
//        bookingService.save(TestDateBeforeToday); //throws DateNotValidException //VERIFIED
//        bookingService.save(bookingF1); //SAVED
//        bookingService.save(TestSameDateSameWS); // throws TakenValueException "The workstation GRDN you requested is already booked for the date 2026-08-21" //VERIFIED


    }
}
