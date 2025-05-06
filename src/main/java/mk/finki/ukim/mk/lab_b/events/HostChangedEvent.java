package mk.finki.ukim.mk.lab_b.events;

import lombok.Getter;
import mk.finki.ukim.mk.lab_b.model.domain.Host;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class HostChangedEvent extends ApplicationEvent {

    private final LocalDateTime when;

    public HostChangedEvent(Host source) {
        super(source);
        this.when = LocalDateTime.now();
    }
}
