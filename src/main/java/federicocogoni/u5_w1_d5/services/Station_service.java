package federicocogoni.u5_w1_d5.services;

import federicocogoni.u5_w1_d5.entities.Building;
import federicocogoni.u5_w1_d5.entities.Station;
import federicocogoni.u5_w1_d5.enums.Station_type;
import federicocogoni.u5_w1_d5.repositories.Station_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Station_service {

    @Autowired
    private Station_repo stationRepo;

    public void save(Station station){
        stationRepo.save(station);
        System.out.println("station saved");
    }

    public Station findById(UUID station_id){
        Optional<Station> found = stationRepo.findById(station_id);
        return found.get();
    }

    public List<Station> findAll(){
        return stationRepo.findAll();
    }


    public void findByIdAndUpdate(UUID station_id, Station updatedWorkstation){
        Station found = this.findById(station_id);
        found.setBuilding(updatedWorkstation.getBuilding());
        found.setDescription(updatedWorkstation.getDescription());
        found.setStationType(updatedWorkstation.getStationType());
        found.setMax_user(updatedWorkstation.getMax_user());
        stationRepo.save(found);
        System.out.println("Workstation updated.");
    }

    public void findByIdAndDelete(UUID station_id){
        Station found = this.findById(station_id);
        stationRepo.delete(found);
        System.out.println("Workstation deleted.");
    }


    public List<Station> getStationByCityAndStationType(String city, Station_type stationType) {
        return stationRepo.filterByCityAndStationType(city, stationType);
    }
}
