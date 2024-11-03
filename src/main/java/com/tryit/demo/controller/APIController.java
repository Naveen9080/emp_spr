package com.tryit.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tryit.demo.model.Details;
import com.tryit.demo.model.Login;
import com.tryit.demo.model.TableMapping;
import com.tryit.demo.service.DetailsService;
import com.tryit.demo.service.LoginService;
import com.tryit.demo.service.TableService;

import jakarta.persistence.Table;
import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/doit")
public class APIController {

	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private TableService tableservice;
	
	@Autowired
	private DetailsService detailsservice;
	
	@PostMapping("/add_user")
	public Login addlogin(@RequestBody Login loginfo) {
    	loginservice.save(loginfo);
    	return loginfo;
	}
	
	@PostMapping("/add_table/{uid}")
	public TableMapping addtable(@RequestBody TableMapping log,@PathVariable int uid) {
		tableservice.save(log,uid);
		return log;
	}
	
	@PostMapping("/add_details/{tid}")
	public Details adddetails(@RequestBody Details data,@PathVariable int tid) {
		detailsservice.save(data,tid);
		return data;
	}
	
	@GetMapping("/getuser/{email}")
	public Login getuser(@PathVariable String email) {
		Login log= loginservice.getuser(email);
		if(log==null)
			return new Login();
		return log;
//	  return loginservice.getById(id);
	}
	
	@GetMapping("/gettable/{uid}")
	public List<TableMapping> gettable(@PathVariable int uid){
		return tableservice.getUid(uid);
	}
	
	@GetMapping("/getdetails/{tid}")
	public List<Details> getdetails(@PathVariable int tid) {
		return detailsservice.getTid(tid);
	}
	
	@PutMapping("/editD/{id}")
	public Details editDetails(@RequestBody Details data,@PathVariable int id) {
		Details d=detailsservice.get(id);
		data.setDmap(d.getDmap());
		return detailsservice.save(data);
	}
	
	@PutMapping("editT/{id}")
	public TableMapping editTable(@RequestBody TableMapping data,@PathVariable int id) {
		TableMapping l=tableservice.get(id);
		data.setLogin(l.getLogin());
		data.setDetails(l.getDetails());
		return tableservice.save(data);
	}
	
	@DeleteMapping("details/{id}")
	public String deleteDetails(@PathVariable int id) {
		detailsservice.deleteByDid(id);
		return "Delete Successfully";
	}
	
	@DeleteMapping("table/{id}")
	public String deleteTable(@PathVariable int id) {
		tableservice.deleteByTid(id);
		return "Delete Successfully";
	}
	
}
