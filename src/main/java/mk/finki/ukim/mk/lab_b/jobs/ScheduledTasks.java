package mk.finki.ukim.mk.lab_b.jobs;


import mk.finki.ukim.mk.lab_b.service.application.AccommodationApplicationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    AccommodationApplicationService accommodationApplicationService;

    public ScheduledTasks(AccommodationApplicationService accommodationApplicationService) {
        this.accommodationApplicationService = accommodationApplicationService;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void refreshMaterializedView() {
        this.accommodationApplicationService.refreshMaterializedView();
    }
}
