package com.tryit.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableMapping {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer tid;
	 private String dname;
	  
	 @ManyToOne
	 @JoinColumn(name="uid")
	 @JsonBackReference
	 private Login login;
	 
	 @OneToMany(mappedBy = "dmap",cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	 @JsonIgnoreProperties("dmap")
	 private List<Details> details;
	 
}
