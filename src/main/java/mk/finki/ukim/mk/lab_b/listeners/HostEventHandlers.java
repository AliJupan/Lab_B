package mk.finki.ukim.mk.lab_b.listeners;

import mk.finki.ukim.mk.lab_b.events.HostChangedEvent;
import mk.finki.ukim.mk.lab_b.events.HostCreatedEvent;
import mk.finki.ukim.mk.lab_b.events.HostDeletedEvent;
import mk.finki.ukim.mk.lab_b.service.application.CountryApplicationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HostEventHandlers {
    private final CountryApplicationService countryApplicationService;

    public HostEventHandlers(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @EventListener
    public void onHostCreated(HostCreatedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
    @EventListener
    public void onHostDeleted(HostDeletedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
    @EventListener
    public void onHostChanged(HostChangedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
}
