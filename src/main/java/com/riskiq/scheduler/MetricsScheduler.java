package com.riskiq.scheduler;

import com.riskiq.service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MetricsScheduler {

    @Autowired
    private DefaultUserService defaultUserService;

    @Scheduled(fixedDelay = 300000)
    public void recordLines() throws IOException {

        defaultUserService.recordLines();

        defaultUserService.recordOwner();

    }
}
