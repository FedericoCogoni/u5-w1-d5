package federicocogoni.u5_w1_d5.repositories;


import federicocogoni.u5_w1_d5.entities.Reservation;
import federicocogoni.u5_w1_d5.entities.Station;
import federicocogoni.u5_w1_d5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;
@Repository
public interface Reservation_repo extends JpaRepository<Reservation, UUID> {

    boolean existsByStationAndReservationDate(Station station, LocalDate data);




}
