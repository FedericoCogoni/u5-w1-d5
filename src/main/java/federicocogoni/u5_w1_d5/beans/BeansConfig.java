package federicocogoni.u5_w1_d5.beans;

import com.github.javafaker.Faker;
import federicocogoni.u5_w1_d5.entities.Building;
import federicocogoni.u5_w1_d5.entities.Reservation;
import federicocogoni.u5_w1_d5.entities.Station;
import federicocogoni.u5_w1_d5.entities.User;
import federicocogoni.u5_w1_d5.enums.Station_type;
import federicocogoni.u5_w1_d5.services.Reservation_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Locale;

@Configuration
    public class BeansConfig {
        Faker faker = new Faker(Locale.ITALIAN);
        @Autowired
        Reservation_service reservationService;

    @Bean
    Building building1() {
        return new Building(faker.company().name(),faker.address().streetAddress(),faker.address().cityName());
    }

    @Bean
    Station station1() {
        return new Station("tavolo singolo fronte mare",4, Station_type.PRIVATE,building1());
    }

    @Bean
    User user1() {
        return new User(faker.name().username(), faker.name().firstName(), faker.name().lastName(),  faker.internet().emailAddress());
    }

    @Bean
    Reservation reservation1() {
        return new Reservation(LocalDate.of(2024, 6, 22), Station_type.PRIVATE, user1(), station1());
    }
}
