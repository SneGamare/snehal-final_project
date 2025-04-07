package com.javatechie.controller;

import com.javatechie.dto.PlutusFinacleData;
import com.javatechie.producer.PlutusFinacleDataProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finacle")
public class PlutusFinacleDataController {

    @Autowired
    private PlutusFinacleDataProducer producer;

    @PostMapping("/data")
    public String sendData(@RequestBody PlutusFinacleData data) {
        producer.send(data);
        return "PlutusFinacleData sent successfully!";
    }
} 