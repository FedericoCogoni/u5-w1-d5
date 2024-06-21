package federicocogoni.u5_w1_d5.services;


import federicocogoni.u5_w1_d5.repositories.Building_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Building_service {

    @Autowired
    private Building_repo buildingRepo;
}
