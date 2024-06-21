package federicocogoni.u5_w1_d5.entities;


import federicocogoni.u5_w1_d5.enums.Station_type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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
    @ManyToOne
    @JoinColumn(name = "building")
    private Building building;
    @OneToMany(mappedBy = "station")
    private List<Reservation> reservationStationList;

    public Station(String description, int max_user, Station_type stationType, Building building) {
        this.description = description;
        this.max_user = max_user;
        this.stationType = stationType;
        this.building = building;
    }
}
