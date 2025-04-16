package mk.finki.ukim.mk.lab_b.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Accommodation> accommodations;

    public Booking(User user) {
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.accommodations = new ArrayList<>();
    }

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }
}
