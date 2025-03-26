package mk.finki.ukim.mk.lab_b.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Host host;
    private int numRooms;
    private boolean active;

    public Accommodation(String name, Category category, Host host, int numRooms, boolean active) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.active = active;
    }

    public Accommodation() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Host getHost() {
        return host;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
