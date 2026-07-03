package valeriafarinosi.U5_W1_D5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
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

    }
}
