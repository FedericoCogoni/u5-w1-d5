package federicocogoni.u5_w1_d5.repositories;

import federicocogoni.u5_w1_d5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Reservation_repo extends JpaRepository<Reservation_repo, UUID> {
}
