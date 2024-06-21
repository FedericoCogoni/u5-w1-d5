package federicocogoni.u5_w1_d5.services;

import federicocogoni.u5_w1_d5.repositories.Station_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Station_service {

    @Autowired
    private Station_repo stationRepo;
}
