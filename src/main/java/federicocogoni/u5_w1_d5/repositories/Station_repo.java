package federicocogoni.u5_w1_d5.repositories;

import federicocogoni.u5_w1_d5.entities.Station;
import federicocogoni.u5_w1_d5.enums.Station_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface Station_repo extends JpaRepository<Station, UUID> {

    @Query("SELECT s FROM Station s WHERE s.building.city = :city AND s.stationType = :stationType")
    List<Station> filterByCityAndStationType(String city, Station_type stationType);

}
