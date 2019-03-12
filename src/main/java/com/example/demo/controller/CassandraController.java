package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SimpleTable;
import com.example.demo.repository.CassandraRepository;

@RestController
@RequestMapping("/cassandra")
public class CassandraController {

	@Autowired
	private CassandraRepository cassandraRepository;
	
	@PostMapping
	public ResponseEntity<SimpleTable> saveInToSimpleTable(@RequestBody SimpleTable simpleTable)
	{
		SimpleTable savedData = cassandraRepository.save(simpleTable);
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	@GetMapping("/hello") 
	private String hello()
	{
		return "Hello World";
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<SimpleTable> fetchRecordsFromSimpleTable(@PathVariable("id") String id)
	{
		Optional<SimpleTable> fetchData = cassandraRepository.findById(id);
		return new ResponseEntity<>(fetchData.get(), HttpStatus.OK);
	}
}
