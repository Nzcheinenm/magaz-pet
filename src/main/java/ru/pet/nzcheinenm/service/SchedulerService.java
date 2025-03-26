package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.pet.nzcheinenm.types.StatusType;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerService {

    private final DatabaseProductService databaseProductService;

    @Scheduled(cron = "${magazine-service.scheduler.cron}")
    public void scheduler() {
        databaseProductService.findAllByStatus(StatusType.COMPLETED);
        //TODO обработка раз в сутки для отправки готовых задач
    }
}
