package com.example.demo.schedulingtasks;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.service.WalletService;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
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
    private StatefulRedisConnection redisConnection;

    @Autowired
    WalletService walletService;

    @Scheduled(fixedRate = 300000)
    public void checkExpiredPresent() {
        log.info("Check Expired Present at {}", dateFormat.format(new Date()));
        walletService.checkExprired();
    }

    @Scheduled(cron = "0 55 23 * * *", zone="Asia/Ho_Chi_Minh")
    public void createKey(){
        System.out.println("working");
        RedisCommands update = redisConnection.sync();
        System.out.println(LocalDate.now().plusDays(1));
        String nextDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyMMdd"));
        String nextTwoDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyMMdd"));
        List<String> prefixs = new ArrayList<String>();
        prefixs.add("user");
        prefixs.add("trans");
        for (String prefix: prefixs){
            String key = prefix+"_"+nextDate;
            System.out.println(key);
            update.set(key, "0");
            update.expire(key, 87000);
        }
    }
}