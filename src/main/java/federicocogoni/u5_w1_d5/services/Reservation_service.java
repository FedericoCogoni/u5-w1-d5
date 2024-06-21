package federicocogoni.u5_w1_d5.services;

import federicocogoni.u5_w1_d5.repositories.Reservation_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reservation_service {


    @Autowired
    private Reservation_repo reservationRepo;
}
