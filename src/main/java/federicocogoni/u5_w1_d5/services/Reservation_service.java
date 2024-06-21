package federicocogoni.u5_w1_d5.services;

import federicocogoni.u5_w1_d5.entities.Reservation;
import federicocogoni.u5_w1_d5.entities.Station;
import federicocogoni.u5_w1_d5.entities.User;
import federicocogoni.u5_w1_d5.repositories.Reservation_repo;
import federicocogoni.u5_w1_d5.repositories.Station_repo;
import federicocogoni.u5_w1_d5.repositories.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class Reservation_service {

    @Autowired
    private Reservation_repo reservationRepo;

    @Autowired
    private Station_repo stationRepo;

    @Autowired
    private User_repo userRepo;

    public void save(Reservation reservation) {
        reservationRepo.save(reservation);
        System.out.println("Reservation saved");
    }

    public Reservation findById(UUID reservation_id) throws Exception {
        return reservationRepo.findById(reservation_id)
                .orElseThrow(() -> new Exception("Reservation not found"));
    }

    public List<Reservation> findAll() {
        return reservationRepo.findAll();
    }

    public void findByIdAndUpdate(UUID reservation_id, Reservation updatedReservation) throws Exception {
        Reservation found = this.findById(reservation_id);
        found.setReservationDate(updatedReservation.getReservationDate());
        found.setStation(updatedReservation.getStation());
        found.setUser(updatedReservation.getUser());
        reservationRepo.save(found);
        System.out.println("Reservation updated.");
    }

    public void findByIdAndDelete(UUID reservation_id) throws Exception {
        Reservation found = this.findById(reservation_id);
        reservationRepo.delete(found);
        System.out.println("Reservation deleted.");
    }

    public Reservation reservationStation(UUID station_id, UUID user_id, LocalDate reservation_date) throws Exception {
        Station station = stationRepo.findById(station_id)
                .orElseThrow(() -> new Exception("Station not found"));

        User user = userRepo.findById(user_id)
                .orElseThrow(() -> new Exception("User not found"));

        if (reservationRepo.existsByStationAndReservationDate(station, reservation_date)) {
            throw new Exception("Station : " +station.getStation_id()+ " Occuped");
        }

        Reservation reservation = new Reservation();
        reservation.setStation(station);
        reservation.setUser(user);
        reservation.setReservationDate(reservation_date);

        reservationRepo.save(reservation);
        System.out.println("Reservation created.");
        return reservation;
    }
}
