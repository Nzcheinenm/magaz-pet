package ru.pet.nzcheinenm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import ru.pet.nzcheinenm.types.StatusType;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerService {

    private final DatabaseProductService databaseProductService;

    @Scheduled(cron = "${magazine-service.scheduler.cron}")
    public void scheduler() {
        String lid = String.valueOf(Math.random());
        log.info("[{}] Scheduler start...", lid);
        databaseProductService.findAllByStatus(StatusType.COMPLETED);
        //TODO обработка раз в сутки для отправки готовых задач
    }
}
