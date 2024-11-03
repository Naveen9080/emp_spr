package com.tryit.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Details {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer did;
	private String firstname;
	private String lastname;
	private long salary;
	private int age;
	private String dob;
	private String role;
	@Column(name="pno")
	private String pno;
	@Column(name="email")
	private String email;
	private String address;
	@Column(nullable = true)
	private String url;
	
	
	@ManyToOne
	@JoinColumn(name = "tid")
	@JsonBackReference
	private TableMapping dmap;
	
	
	
}
