package com.example.demo.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.demo.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    TransferService transferService;
    @Scheduled(fixedRate = 300000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        transferService.checkExprired();
    }
}