package valeriafarinosi.U5_W1_D5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import valeriafarinosi.U5_W1_D5.entities.User;
import valeriafarinosi.U5_W1_D5.services.BookingService;

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

//        USERS
        User frodo = ctx.getBean("frodo", User.class);
        User sam = ctx.getBean("sam", User.class);
        User gandalf = ctx.getBean("gandalf", User.class);
        User legolas = ctx.getBean("legolas", User.class);
        User aragorn = ctx.getBean("aragorn", User.class);
        User gimli = ctx.getBean("gimli", User.class);

//        bookingService.save(frodo);
//        bookingService.save(sam);
//        bookingService.save(gandalf);
//        bookingService.save(legolas);
//        bookingService.save(aragorn);
//        bookingService.save(gimli);

//        BUILDINGS
//        Building bagEnd = ctx.getBean("bagEnd", Building.class);
//        Building minasTirithHeadQuarters = ctx.getBean("minasTirithHeadQuarters", Building.class);
//        Building durinMountainOffice = ctx.getBean("durinMountainOffice", Building.class);
//
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
//
//        bookingService.save(garden);
//        bookingService.save(fireplace);
//        bookingService.save(tower);
//        bookingService.save(council);
//        bookingService.save(gondorWorkers);
//        bookingService.save(gardengeneeringWorkspaceen);
//        bookingService.save(miningOpRoom);


    }
}
