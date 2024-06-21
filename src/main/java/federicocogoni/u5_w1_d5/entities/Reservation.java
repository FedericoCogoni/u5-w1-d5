package federicocogoni.u5_w1_d5.entities;


import federicocogoni.u5_w1_d5.enums.Station_type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID reservation_id;
    @Column(name = "reservation_date")
    private LocalDate reservationDate;
    @Enumerated(EnumType.STRING)
    private Station_type stationType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;


    public Reservation(LocalDate reservationDate, Station_type stationType, User user, Station station) {
        this.reservationDate = reservationDate;
        this.stationType = stationType;
        this.user = user;
        this.station = station;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", reservationDate=" + reservationDate +
                ", stationType=" + stationType +
                ", user=" + user +
                ", station=" + station +
                '}';
    }
}
