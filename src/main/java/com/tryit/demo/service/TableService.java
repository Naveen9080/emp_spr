package com.tryit.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tryit.demo.repository.TabelRepository;
import com.tryit.demo.model.Login;
import com.tryit.demo.model.TableMapping;

@Service
public class TableService {

	@Autowired
	private TabelRepository Tablerepo;
	
	@Autowired
	private LoginService logservice;
	
//	@Autowired
//	private DetailsService detailsService;
	
	public TableMapping save(TableMapping tmp,int uid) {
	       tmp.setLogin(logservice.getById(uid));
	       logservice.getById(uid).getTmap().add(tmp);
	       return Tablerepo.save(tmp);
	}
	public TableMapping save(TableMapping tmp) {
		return Tablerepo.save(tmp);
	}
	public List<TableMapping> getUid(int id) {
		return Tablerepo.findByLogin(logservice.getById(id));
	}
	public TableMapping get(int id) {
		return Tablerepo.findById(id).get();
	}
    
	public void deleteByTid(int id) {
//		new DetailsService().deleteByRefereence(get(id));
		Tablerepo.deleteById(id);
	}
	
}
