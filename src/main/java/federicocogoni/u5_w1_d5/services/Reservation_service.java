package federicocogoni.u5_w1_d5.services;

import federicocogoni.u5_w1_d5.entities.Reservation;
import federicocogoni.u5_w1_d5.entities.Station;
import federicocogoni.u5_w1_d5.repositories.Reservation_repo;
import federicocogoni.u5_w1_d5.repositories.Station_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Reservation_service {


    @Autowired
    private Reservation_repo reservationRepo;

    public void save(Reservation reservation){
        reservationRepo.save(reservation);
        System.out.println("reservation saved");
    }


    public Reservation findById(UUID reservation_id){
        Optional<Reservation> found = reservationRepo.findById(reservation_id);
        return found.get();
    }

    public List<Reservation> findAll(){
        return reservationRepo.findAll();
    }
    //setReservationDate(updatedBook.getReservationDate());

    public void findByIdAndUpdate(UUID reservation_id, Reservation updatedReservation){
        Reservation found = this.findById(reservation_id);
        found.setReservation_date(updatedReservation.getReservation_date());
        found.setStation(updatedReservation.getStation());
        found.setUser(updatedReservation.getUser());
        reservationRepo.save(updatedReservation);
        System.out.println("Book updated.");
    }

    public void findByIdAndDelete(UUID reservation_id){
        Reservation found = this.findById(reservation_id);
        reservationRepo.delete(found);
        System.out.println("Book deleted.");
    }


}
