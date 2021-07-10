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
@RequestMapping("/file")
public class FileController {

    @GetMapping("/lines")
    public ResponseEntity<?> countLines() {

        try {
            Long lines = MetricsCache.getInstance().getLines();
            return new ResponseEntity<>(lines, new HttpHeaders(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }

}
