package federicocogoni.u5_w1_d5.repositories;

import federicocogoni.u5_w1_d5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Building_repo extends JpaRepository<Building, UUID> {

}
