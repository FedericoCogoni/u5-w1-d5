package federicocogoni.u5_w1_d5.repositories;

import federicocogoni.u5_w1_d5.entities.Building;
import federicocogoni.u5_w1_d5.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Station_repo extends JpaRepository<Station, UUID> {
}
