package federicocogoni.u5_w1_d5.services;

import federicocogoni.u5_w1_d5.entities.Building;
import federicocogoni.u5_w1_d5.entities.User;
import federicocogoni.u5_w1_d5.repositories.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class User_service {

    @Autowired
    private User_repo userRepo;

    public void save(User user){
        userRepo.save(user);
        System.out.println("user saved");
    }

    public User findById(UUID user_id){
        Optional<User> found = userRepo.findById(user_id);
        return found.get();
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public void findByIdAndUpdate(UUID user_id, User updatedUser){
        User found = this.findById(user_id);
        found.setName(updatedUser.getName());
        found.setSurname(updatedUser.getSurname());
        found.setEmail(updatedUser.getEmail());
        found.setUsername(updatedUser.getUsername());
        userRepo.save(found);
        System.out.println("User updated.");
    }

    public void findByIdAndDelete(UUID user_id){
        User found = this.findById(user_id);
        userRepo.delete(found);
        System.out.println("User deleted.");
    }
}
