package com.example.demo.rest.controllers;


import com.example.demo.rest.models.ProducerRequestModel;
import com.example.demo.rest.models.ProducerResponseModel;
import com.example.demo.service.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProducerController {
    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/producer")
    public ResponseEntity<ProducerResponseModel> createProducer(@RequestBody ProducerRequestModel producerRequestModel) {
        ProducerResponseModel producer = producerService.createProducer(producerRequestModel);
        return ResponseEntity.ok(producer);
    }

    @PutMapping(value = "/producer/{id}")
    public ResponseEntity<ProducerResponseModel> updateMovie(@PathVariable Long id, @RequestBody ProducerRequestModel producerRequestModel) {
        ProducerResponseModel producerResponseModel = producerService.updateProducer(id, producerRequestModel);
        return ResponseEntity.ok(producerResponseModel);
    }

    @GetMapping(value = "/producer")
    public ResponseEntity<List<ProducerResponseModel>> findAll() {
        List<ProducerResponseModel> all = producerService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/producer/{id}")
    public ResponseEntity<ProducerResponseModel> findById(@PathVariable Long id) {
        ProducerResponseModel producerResponseModel = producerService.findById(id);
        return ResponseEntity.ok(producerResponseModel);
    }

    @DeleteMapping("/producer/{id}")
    public ResponseEntity<ProducerResponseModel> deleteProducer(@PathVariable Long id) {
        ProducerResponseModel delete = producerService.deleteProducer(id);
        return ResponseEntity.ok(delete);
    }
}
