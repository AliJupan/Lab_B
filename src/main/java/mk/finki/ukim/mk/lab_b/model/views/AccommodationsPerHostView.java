package mk.finki.ukim.mk.lab_b.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM accommodations_per_host")
@Immutable
public class AccommodationsPerHostView {

    @Id
    @Column(name = "host_id")
    private Long hostId;

    private String hostName;

    @Column(name = "num_accommodations")
    private Long numAccommodationsPerHost;
}
