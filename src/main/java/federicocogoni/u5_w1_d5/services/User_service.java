package federicocogoni.u5_w1_d5.services;

import federicocogoni.u5_w1_d5.entities.User;
import federicocogoni.u5_w1_d5.repositories.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_service {

    @Autowired
    private User_repo userRepo;
}
