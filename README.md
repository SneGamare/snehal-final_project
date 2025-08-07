package com.example.transformer.controller;

import com.example.transformer.model.TransformRequest;
import com.example.transformer.service.TransformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transform")
@RequiredArgsConstructor
public class TransformController {

    private final TransformService transformService;

    @PostMapping
    public ResponseEntity<?> transform(@RequestBody TransformRequest request) {
        try {
            Object result = transformService.process(request);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("Invalid Request", ex.getMessage())
            );
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ErrorResponse("Transformation Failed", ex.getMessage())
            );
        }
    }

    // Inner class for simple error response
    private record ErrorResponse(String error, String message) {}
}



POST /api/transform
Content-Type: application/json

{
  "templateId": "camt-to-json",
  "inputFormat": "xml",
  "outputFormat": "json",
  "payload": "<Document><Amt>100.00</Amt><Ccy>EUR</Ccy></Document>"
}
