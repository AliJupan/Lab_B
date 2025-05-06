package mk.finki.ukim.mk.lab_b.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JoinColumn(name = "user_username", referencedColumnName = "username", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
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
