package com.example.demo.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SimpleTable;

@Repository
public interface CassandraRepository extends CrudRepository<SimpleTable, Long>{

	Optional<SimpleTable> findById(String id);

}
