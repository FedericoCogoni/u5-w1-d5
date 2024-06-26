package federicocogoni.u5_w1_d5.runners;

import federicocogoni.u5_w1_d5.entities.Building;
import federicocogoni.u5_w1_d5.entities.Reservation;
import federicocogoni.u5_w1_d5.entities.Station;
import federicocogoni.u5_w1_d5.entities.User;
import federicocogoni.u5_w1_d5.enums.Station_type;
import federicocogoni.u5_w1_d5.repositories.User_repo;
import federicocogoni.u5_w1_d5.services.Building_service;
import federicocogoni.u5_w1_d5.services.Reservation_service;
import federicocogoni.u5_w1_d5.services.Station_service;
import federicocogoni.u5_w1_d5.services.User_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Component
public class My_runner implements CommandLineRunner {

    @Autowired
    private AnnotationConfigApplicationContext ctx;
    @Autowired
    private Building_service buildingService;
    @Autowired
    private Reservation_service reservationService;
    @Autowired
    private Station_service stationService;
    @Autowired
    private User_service userService;

    @Override
    public void run(String... args) throws Exception {


        buildingService.save((Building) ctx.getBean("building1"));
        stationService.save((Station) ctx.getBean("station1"));
        userService.save((User) ctx.getBean("user1"));
        reservationService.save((Reservation) ctx.getBean("reservation1"));

        try {
            reservationService.reservationStation(UUID.fromString("02c9358d-6759-4ef4-abd8-6dfd089834ae"), UUID.fromString("e38df34e-e43c-4e9e-b917-4f443eb9e94f"), LocalDate.of(2024, 06, 22));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Station> stations;
        try {
            stations = stationService.getStationByCityAndStationType("Quarto Soriana ligure", Station_type.PRIVATE);
            stations.forEach(station -> System.out.println(station));
        } catch (Exception e) {
            System.out.println("Errore durante il recupero delle stazioni: " + e.getMessage());
        }
    }
}
