package com.tryit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tryit.demo.model.Login;
import com.tryit.demo.repository.LoginRepository;

@Service
public class LoginService {
    
	@Autowired
	private LoginRepository Loginrepo;
	
	public void save(List<Login> l) {
		Loginrepo.saveAll(l);
	}
	public void save(Login l) {
		Loginrepo.save(l);
	}
	
	public List<Login> listAll(){
		return Loginrepo.findAll();
	}
	
	public Login getById(int id) {
		return Loginrepo.findById(id).get();
	}
	
	public Login getuser(String st) {
		return Loginrepo.getByEmailId(st);
	}
}
