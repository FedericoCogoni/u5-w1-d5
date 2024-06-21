package federicocogoni.u5_w1_d5.services;


import federicocogoni.u5_w1_d5.entities.Building;
import federicocogoni.u5_w1_d5.repositories.Building_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Building_service {

    @Autowired
    private Building_repo buildingRepo;

    public void save(Building building){
        buildingRepo.save(building);
        System.out.println("building saved");
    }

    public Building findById(UUID building_id){
        Optional<Building> found = buildingRepo.findById(building_id);
        return found.get();
    }

    public List<Building> findAll(){
        return buildingRepo.findAll();
    }

    public void findByIdAndDelete(UUID building_id){
        Building found = this.findById(building_id);
        buildingRepo.delete(found);
        System.out.println("Building deleted.");
    }

    public void findByIdAndUpdate(UUID building_id, Building updatedBuilding){
        Building found = this.findById(building_id);
        found.setAddress(updatedBuilding.getAddress());
        found.setCity(updatedBuilding.getCity());
        found.setName(updatedBuilding.getName());
        buildingRepo.save(found);
        System.out.println("Building updated.");
    }


}
