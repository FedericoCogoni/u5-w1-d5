package federicocogoni.u5_w1_d5.entities;


import federicocogoni.u5_w1_d5.enums.Station_type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID station_id;
    private String description;
    private int max_user;
    @Enumerated(EnumType.STRING)
    private Station_type stationType;

}
