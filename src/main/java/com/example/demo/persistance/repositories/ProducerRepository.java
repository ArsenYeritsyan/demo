package com.example.demo.persistance.repositories;

import com.example.demo.persistance.model.Movie;
import com.example.demo.persistance.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProducerRepository extends MongoRepository<Producer,Long> {
    Optional<Producer> findById(Long id);
    Set<Producer> findAllByMovies(Long id);
    List<Producer>findByMovis(Long id);
}
