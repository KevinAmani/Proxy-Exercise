package com.riskiq.controller;

import com.riskiq.cache.MetricsCache;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @GetMapping("/owner")
    public ResponseEntity<?> countLines(@RequestParam("service-name") String serviceName) {

        try {
            String owner = MetricsCache.getInstance().getOwner(serviceName);
            return new ResponseEntity<>(owner, new HttpHeaders(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }

}
