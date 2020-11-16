package com.example.demo.service;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.persistance.model.Producer;
import com.example.demo.rest.models.*;
import com.example.demo.persistance.repositories.ProducerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public Producer requestToProducer(ProducerRequestModel producerRequestModel) {
        Producer producer = new Producer();
        producer.setName(producerRequestModel.getName());
        producer.setAge(producerRequestModel.getAge());
        return producer;
    }

    private ProducerResponseModel producerToResponse(Producer producer) {
        ProducerResponseModel producerResponseModel = new ProducerResponseModel();
        producerResponseModel.setId(producer.getId());
        producerResponseModel.setName(producer.getName());
        producerResponseModel.setAge(producer.getAge());
        producer.setMovies(producer.getMovies()) ;
        return producerResponseModel;
    }

    public ProducerResponseModel createProducer(ProducerRequestModel producerRequestModel) {
        Producer producer = requestToProducer(producerRequestModel);
        producerRepository.save(producer);
        return producerToResponse(producer);
    }

    public List<ProducerResponseModel> findAll() {
        List<Producer> all = producerRepository.findAll();
        return all.stream()
                .map(this::producerToResponse)
                .collect(Collectors.toList());
    }

    public ProducerResponseModel findById(Long id){
        Producer producer;
        if(producerRepository.findById(id).isPresent()){ producer = producerRepository.findById(id).get();}
        else throw new ObjectNotFoundException("The Producer not found");
        return producerToResponse(producer);
    }

    public ProducerResponseModel updateProducer(Long id , ProducerRequestModel producerRequestModel){
        Producer producer;
        if(producerRepository.findById(id).isPresent()){ producer = producerRepository.findById(id).get();
        producer.setAge(producer.getAge());
        producer.setName(producerRequestModel.getName());
        producerRepository.save(producer);}
        else throw new ObjectNotFoundException("The Producer not found");
        return producerToResponse(producer);
    }
    public Set<ProducerResponseModel> findByMovie(Long id){
        Set<Producer> all = producerRepository.findAllByMovies(id);
        return all.stream()
                .map(this::producerToResponse)
                .collect(Collectors.toSet());
    }
    public ProducerResponseModel deleteProducer(Long id){
        producerRepository.deleteById(id);
        return null;
    }
}
