package com.example.camel.controller;

import com.example.camel.service.TransformationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transform")
public class TransformController {

    private final TransformationService transformationService;

    public TransformController(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    @PostMapping("/{templateId}")
    public String transform(@PathVariable Long templateId, @RequestBody String payload) throws Exception {
        return transformationService.transform(templateId, payload);
    }
}
