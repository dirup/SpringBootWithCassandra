package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("SIMPLETABLE")
public class SimpleTable implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	@Column("ID")
	@Getter
	@Setter
	private String id;
	
	@Column("NAME")
	@Getter
	@Setter
	private String name;
	
	@Column("CREATED_TIME")
	@Getter
	@Setter
	private Date createdTime = new Date();
	
	
	

}
